package pl.freemusic.freemusic.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ALBUMS")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;

    @Column(length = 2000)
    private String description;

    private BigDecimal price;
    private String coverUrl;
    private String previewUrl;
    private String fileKey;

    public Album() {
    }

    public Album(Long id, String name, String genre, String description, BigDecimal price,
                 String coverUrl, String previewUrl, String fileKey) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.coverUrl = coverUrl;
        this.previewUrl = previewUrl;
        this.fileKey = fileKey;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }

    public String getPreviewUrl() { return previewUrl; }
    public void setPreviewUrl(String previewUrl) { this.previewUrl = previewUrl; }

    public String getFileKey() { return fileKey; }
    public void setFileKey(String fileKey) { this.fileKey = fileKey; }
}