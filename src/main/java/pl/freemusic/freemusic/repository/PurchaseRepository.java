package pl.freemusic.freemusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.freemusic.freemusic.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {}