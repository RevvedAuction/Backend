package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.AuctionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionSessionRepository extends JpaRepository<AuctionSession, String> {
}
