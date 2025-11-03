package pl.freemusic.freemusic.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.freemusic.freemusic.model.PurchaseItem;

/**
 * Lekki serwis pobierania: deleguje do PurchaseService,
 * żeby cała walidacja (paid, expiry, limit) była w jednym miejscu.
 */
@Service
public class DownloadService {

    private final PurchaseService purchaseService;

    public DownloadService(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    /**
     * Zwraca plik ZIP dla danego tokenu pozycji zamówienia.
     * Walidacja tokenu, statusu płatności, ważności i limitu pobrań
     * jest wykonywana w PurchaseService.
     */
    public ResponseEntity<byte[]> getFileForToken(String token) throws Exception {
        // 1) Walidacja tokenu + reguł (paid, expiry, limit)
        PurchaseItem item = purchaseService.resolveDownload(token);

        // 2) Pobranie bajtów i inkrementacja licznika pobrań
        byte[] bytes = purchaseService.getDownloadBytesAndIncrement(item);

        // 3) Nagłówki HTTP dla pobierania
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String safeName = item.getAlbumName() != null
                ? item.getAlbumName().replaceAll("\\s+", "_")
                : "album";
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + safeName + ".zip\"");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}