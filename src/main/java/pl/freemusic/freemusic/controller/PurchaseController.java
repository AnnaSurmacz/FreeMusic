package pl.freemusic.freemusic.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pl.freemusic.freemusic.controller.dto.CheckoutRequest;
import pl.freemusic.freemusic.controller.dto.CheckoutResponse;
import pl.freemusic.freemusic.model.PurchaseItem;
import pl.freemusic.freemusic.service.PurchaseService;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // ✅ MVP: tworzy zakup, ustawia paid=true i zwraca tokeny pobrań
    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout(@RequestBody CheckoutRequest req) {
        CheckoutResponse res = purchaseService.createPurchase(req);
        return ResponseEntity.ok(res);
    }

    // ✅ Pobieranie ZIP-a po tokenie pozycji
    @GetMapping("/download/{token}")
    public ResponseEntity<byte[]> download(@PathVariable String token) throws Exception {
        PurchaseItem item = purchaseService.resolveDownload(token);
        byte[] bytes = purchaseService.getDownloadBytesAndIncrement(item);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String safe = item.getAlbumName() != null ? item.getAlbumName().replaceAll("\\s+", "_") : "album";
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + safe + ".zip\"");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}