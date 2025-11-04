package pl.freemusic.freemusic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.freemusic.freemusic.controller.dto.CheckoutRequest;
import pl.freemusic.freemusic.controller.dto.CheckoutResponse;
import pl.freemusic.freemusic.model.Album;
import pl.freemusic.freemusic.model.Purchase;
import pl.freemusic.freemusic.model.PurchaseItem;
import pl.freemusic.freemusic.repository.AlbumRepository;
import pl.freemusic.freemusic.repository.PurchaseItemRepository;
import pl.freemusic.freemusic.repository.PurchaseRepository;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepo;
    private final PurchaseItemRepository itemRepo;
    private final AlbumRepository albumRepo;

    @Value("${app.files.root:./files}")
    private String filesRoot; // katalog bazowy z ZIP-ami

    public PurchaseService(PurchaseRepository purchaseRepo,
                           PurchaseItemRepository itemRepo,
                           AlbumRepository albumRepo) {
        this.purchaseRepo = purchaseRepo;
        this.itemRepo = itemRepo;
        this.albumRepo = albumRepo;
    }

    @Transactional
    public CheckoutResponse createPurchase(CheckoutRequest req) {
        if (req == null || req.items == null || req.items.isEmpty()) {
            throw new IllegalArgumentException("Koszyk jest pusty.");
        }

        Purchase p = new Purchase();

        if (req.buyer != null) {
            p.setCustomerEmail(req.buyer.email);
            p.setUserId(req.buyer.userId);
            p.setBillingCompanyName(req.buyer.companyName);
            p.setBillingVatId(req.buyer.vatId);
            p.setBillingStreet(req.buyer.street);
            p.setBillingZip(req.buyer.zip);
            p.setBillingCity(req.buyer.city);
            p.setBillingContactName(req.buyer.contactName);
        }
        if (req.license != null) {
            p.setVenueName(req.license.venueName);
            p.setVenueAddress(req.license.venueAddress);
        }

        if (p.getCreatedAt() == null) p.setCreatedAt(LocalDateTime.now());
        if (p.getValidUntil() == null) p.setValidUntil(p.getCreatedAt().plusMonths(12));

        BigDecimal total = BigDecimal.ZERO;

        for (CheckoutRequest.CartItemDTO ci : req.items) {
            Album album;

            if (ci.albumSlug != null && !ci.albumSlug.isBlank()) {
                album = albumRepo.findBySlug(ci.albumSlug)
                        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono albumu o slug: " + ci.albumSlug));
            } else if (ci.albumId != null) {
                album = albumRepo.findById(ci.albumId)
                        .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono albumu o id: " + ci.albumId));
            } else {
                throw new IllegalArgumentException("Pozycja koszyka wymaga albumSlug lub albumId.");
            }

            PurchaseItem pi = new PurchaseItem();
            pi.setAlbumId(album.getId());
            pi.setAlbumName(album.getName());
            pi.setPrice(album.getPrice());
            pi.setCoverUrl(album.getCoverUrl());
            pi.setFileKey(album.getFileKey());
            pi.setPreviewUrl(album.getPreviewUrl());
            pi.setMaxDownloads(5);

            p.addItem(pi);
            if (album.getPrice() != null) total = total.add(album.getPrice());
        }

        p.setTotalAmount(total);
        p.setPaid(true);

        purchaseRepo.save(p);

        CheckoutResponse res = new CheckoutResponse();
        res.purchaseId = p.getId();
        res.paid = p.isPaid();
        res.purchaseToken = p.getPurchaseToken();
        res.totalAmount = p.getTotalAmount();
        res.items = p.getItems().stream().map(pi -> {
            CheckoutResponse.ItemLink il = new CheckoutResponse.ItemLink();
            il.itemId = pi.getId();
            il.albumId = pi.getAlbumId();
            il.albumName = pi.getAlbumName();
            il.downloadToken = pi.getDownloadToken();
            return il;
        }).collect(Collectors.toList());

        return res;
    }

    @Transactional(readOnly = true)
    public PurchaseItem resolveDownload(String token) {
        var item = itemRepo.findByDownloadToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Nieprawidłowy token pobierania."));

        var purchase = item.getPurchase();
        if (purchase == null) throw new IllegalStateException("Pozycja nie ma powiązanego zamówienia.");
        if (!purchase.isPaid()) throw new IllegalStateException("Zamówienie nieopłacone.");
        if (purchase.getValidUntil() != null && LocalDateTime.now().isAfter(purchase.getValidUntil())) {
            throw new IllegalStateException("Licencja wygasła.");
        }
        if (item.getDownloadCount() >= item.getMaxDownloads()) {
            throw new IllegalStateException("Limit pobrań dla tej pozycji został wyczerpany.");
        }
        return item;
    }

    @Transactional
    public byte[] getDownloadBytesAndIncrement(PurchaseItem item) throws Exception {
        Path path = Path.of(filesRoot).resolve(item.getFileKey()).normalize();
        byte[] bytes = Files.readAllBytes(path);
        item.setDownloadCount(item.getDownloadCount() + 1);
        itemRepo.save(item);
        return bytes;
    }
}