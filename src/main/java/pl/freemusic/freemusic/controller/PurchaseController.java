package pl.freemusic.freemusic.controller;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.freemusic.freemusic.controller.dto.CheckoutRequest;
import pl.freemusic.freemusic.controller.dto.CheckoutResponse;
import pl.freemusic.freemusic.model.PurchaseItem;
import pl.freemusic.freemusic.service.PurchaseService;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // ✅ checkout (MVP: paid=true i zwracamy tokeny)
    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout(@RequestBody CheckoutRequest req) {
        CheckoutResponse res = purchaseService.createPurchase(req);
        return ResponseEntity.ok(res);
    }

    // ✅ Pobieranie ZIP-a po tokenie
    @GetMapping(value = "/download/{token}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> download(@PathVariable String token) throws Exception {
        PurchaseItem item = purchaseService.resolveDownload(token);
        byte[] bytes = purchaseService.getDownloadBytesAndIncrement(item);

        // bezpieczna nazwa pliku (ASCII) + .zip
        String baseName = (item.getAlbumName() != null && !item.getAlbumName().isBlank())
                ? item.getAlbumName().replaceAll("\\s+", "_")
                : "album";
        String fileName = baseName + ".zip";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(bytes.length);

        // RFC 5987 – poprawne kodowanie nazw z PL znakami
        ContentDisposition cd = ContentDisposition.attachment()
                .filename(fileName, StandardCharsets.UTF_8)
                .build();
        headers.setContentDisposition(cd);

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
