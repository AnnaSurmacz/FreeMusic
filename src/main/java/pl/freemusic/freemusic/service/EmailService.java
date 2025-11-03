package pl.freemusic.freemusic.service;

import org.springframework.stereotype.Service;
import pl.freemusic.freemusic.model.Purchase;
import pl.freemusic.freemusic.model.PurchaseItem;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

/**
 * MVP: „wysyłka maila” wypisywana do konsoli.
 * Gdy podepniemy SMTP, treść z buildera wyślemy jako email.
 */
@Service
public class EmailService {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Symulacja wysyłki potwierdzenia zakupu do klienta.
     * Wypisuje pełną treść „maila” w konsoli.
     */
    public void sendPurchaseEmail(Purchase purchase, Object unused) {
        if (purchase == null) return;

        String to = purchase.getCustomerEmail() != null ? purchase.getCustomerEmail() : "(brak e-maila)";
        String subject = "MusicForBusiness – potwierdzenie zakupu i linki do pobrania";
        String body = buildEmailBody(purchase);

        // „Wysyłka” – na razie do konsoli.
        System.out.println("==============================================");
        System.out.println("TO: " + to);
        System.out.println("SUBJECT: " + subject);
        System.out.println("----------------------------------------------");
        System.out.println(body);
        System.out.println("==============================================");
    }

    // ====== Helpers ======

    private String buildEmailBody(Purchase purchase) {
        StringBuilder sb = new StringBuilder();

        sb.append("Dziękujemy za zakup licencji muzycznej w MusicForBusiness!\n\n");

        sb.append("Zakupione pozycje:\n");
        BigDecimal total = BigDecimal.ZERO;

        for (PurchaseItem item : purchase.getItems()) {
            BigDecimal price = item.getPrice() != null ? item.getPrice() : BigDecimal.ZERO;
            total = total.add(price);

            sb.append(" - ")
                    .append(nullSafe(item.getAlbumName()))
                    .append(" | ilość: 1")
                    .append(" | cena: ")
                    .append(price)
                    .append(" PLN\n");
        }

        sb.append("\nSuma zamówienia: ").append(total).append(" PLN\n");

        sb.append("\nDane do faktury:\n");
        sb.append("  Firma: ").append(nullSafe(purchase.getBillingCompanyName())).append("\n");
        sb.append("  NIP: ").append(nullSafe(purchase.getBillingVatId())).append("\n");
        sb.append("  Adres: ").append(nullSafe(purchase.getBillingStreet()))
                .append(", ").append(nullSafe(purchase.getBillingZip()))
                .append(" ").append(nullSafe(purchase.getBillingCity())).append("\n");
        sb.append("  Kontakt: ").append(nullSafe(purchase.getBillingContactName())).append("\n");

        sb.append("\nDane licencji (lokal):\n");
        sb.append("  Nazwa lokalu: ").append(nullSafe(purchase.getVenueName())).append("\n");
        sb.append("  Adres lokalu: ").append(nullSafe(purchase.getVenueAddress())).append("\n");

        sb.append("\nTwoje linki do pobrania (ważne do ")
                .append(purchase.getValidUntil() != null ? purchase.getValidUntil().format(DATE_FMT) : "(brak daty)")
                .append("):\n");

        for (PurchaseItem item : purchase.getItems()) {
            sb.append("  • ")
                    .append(nullSafe(item.getAlbumName()))
                    .append(" → ")
                    .append("http://localhost:8080/api/download/")
                    .append(item.getDownloadToken())
                    .append("\n");
        }

        sb.append("\nJeśli nie widzisz tej wiadomości w skrzynce, sprawdź folder SPAM/Oferty.\n");
        sb.append("W razie pytań – odpisz na tę wiadomość.\n");

        return sb.toString();
    }

    private static String nullSafe(String s) {
        return s == null ? "" : s;
    }
}