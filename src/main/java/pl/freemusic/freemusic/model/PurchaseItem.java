package pl.freemusic.freemusic.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "PURCHASE_ITEMS")
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Połączenie z Purchase
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    // Dane albumu (snapshot w momencie zakupu)
    private Long albumId;
    private String albumName;
    private BigDecimal price;
    private String coverUrl;

    // Ścieżka do pliku ZIP (backend lub S3)
    private String fileKey;

    // URL podglądu (fragment 40s)
    private String previewUrl;

    // Token pobrania – unikalny per album
    @Column(unique = true, nullable = false, length = 64)
    private String downloadToken;

    // Liczba i limit pobrań
    private int downloadCount = 0;
    private int maxDownloads = 5;

    public PurchaseItem() {
        this.downloadToken = UUID.randomUUID().toString().replace("-", "");
    }

    // ==== GETTERY i SETTERY ====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getDownloadToken() {
        return downloadToken;
    }

    public void setDownloadToken(String downloadToken) {
        this.downloadToken = downloadToken;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getMaxDownloads() {
        return maxDownloads;
    }

    public void setMaxDownloads(int maxDownloads) {
        this.maxDownloads = maxDownloads;
    }
}
