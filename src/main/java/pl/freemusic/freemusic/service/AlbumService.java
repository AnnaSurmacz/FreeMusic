package pl.freemusic.freemusic.service;

import org.springframework.stereotype.Service;
import pl.freemusic.freemusic.model.Album;
import pl.freemusic.freemusic.repository.AlbumRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbum(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Album not found: " + id));
    }
}