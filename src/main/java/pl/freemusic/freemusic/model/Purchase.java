package pl.freemusic.freemusic.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PURCHASES")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kontakt
    private String customerEmail;

    // Status
    private boolean paid;
    private LocalDateTime createdAt;
    private LocalDateTime validUntil;

    // (opcjonalnie) powiązanie z użytkownikiem jeśli zalogowany
    private Long userId;

    // Dane do faktury
    private String billingCompanyName;
    private String billingVatId;
    private String billingStreet;
    private String billingZip;
    private String billingCity;
    private String billingContactName;

    // Dane licencji – lokal, w którym będzie odtwarzana muzyka
    private String venueName;
    private String venueAddress;

    // Suma zamówienia
    private BigDecimal totalAmount = BigDecimal.ZERO;

    // Token zamówienia (np. do potwierdzeń/maili)
    private String purchaseToken;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PurchaseItem> items = new ArrayList<>();

    public Purchase() {
        this.createdAt = LocalDateTime.now();
        // np. rok ważności licencji – dostosuj według potrzeb
        this.validUntil = this.createdAt.plusMonths(12);
        this.purchaseToken = UUID.randomUUID().toString();
        // W MVP mieliśmy od razu paid=true – jeśli podepniesz bramkę, ustawiaj false i przełącz po webhooku
        this.paid = true;
    }

    public void addItem(PurchaseItem item) {
        item.setPurchase(this);
        items.add(item);
    }

    public void removeItem(PurchaseItem item) {
        items.remove(item);
        item.setPurchase(null);
    }

    // ===== Gettery / Settery =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getValidUntil() { return validUntil; }
    public void setValidUntil(LocalDateTime validUntil) { this.validUntil = validUntil; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getBillingCompanyName() { return billingCompanyName; }
    public void setBillingCompanyName(String billingCompanyName) { this.billingCompanyName = billingCompanyName; }

    public String getBillingVatId() { return billingVatId; }
    public void setBillingVatId(String billingVatId) { this.billingVatId = billingVatId; }

    public String getBillingStreet() { return billingStreet; }
    public void setBillingStreet(String billingStreet) { this.billingStreet = billingStreet; }

    public String getBillingZip() { return billingZip; }
    public void setBillingZip(String billingZip) { this.billingZip = billingZip; }

    public String getBillingCity() { return billingCity; }
    public void setBillingCity(String billingCity) { this.billingCity = billingCity; }

    public String getBillingContactName() { return billingContactName; }
    public void setBillingContactName(String billingContactName) { this.billingContactName = billingContactName; }

    public String getVenueName() { return venueName; }
    public void setVenueName(String venueName) { this.venueName = venueName; }

    public String getVenueAddress() { return venueAddress; }
    public void setVenueAddress(String venueAddress) { this.venueAddress = venueAddress; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public String getPurchaseToken() { return purchaseToken; }
    public void setPurchaseToken(String purchaseToken) { this.purchaseToken = purchaseToken; }

    public List<PurchaseItem> getItems() { return items; }
    public void setItems(List<PurchaseItem> items) { this.items = items; }
}