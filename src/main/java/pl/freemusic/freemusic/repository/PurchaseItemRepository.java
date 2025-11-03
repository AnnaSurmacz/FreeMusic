package pl.freemusic.freemusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.freemusic.freemusic.model.PurchaseItem;

import java.util.Optional;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
    Optional<PurchaseItem> findByDownloadToken(String downloadToken);
}