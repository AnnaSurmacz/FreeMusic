package pl.freemusic.freemusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // e-mail używany jako login
    @Column(nullable = false, unique = true)
    private String email;

    // hasz hasła (nie będziemy trzymać hasła w czystym tekście)
    private String passwordHash;

    // dane firmy do faktury / certyfikatu
    private String companyName;
    private String vatId;          // np. NIP
    private String street;
    private String zip;
    private String city;
    private String contactName;    // np. "Tawerna Pitagyros"

    public UserAccount() {
    }

    // Gettery / settery

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getVatId() { return vatId; }
    public void setVatId(String vatId) { this.vatId = vatId; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
}