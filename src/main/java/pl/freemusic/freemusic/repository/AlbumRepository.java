package pl.freemusic.freemusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.freemusic.freemusic.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}