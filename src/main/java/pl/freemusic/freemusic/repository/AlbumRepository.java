package pl.freemusic.freemusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.freemusic.freemusic.model.Album;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findBySlug(String slug);
}