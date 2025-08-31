package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.AuctionHistory;

import java.util.List;

@Repository
public interface AuctionHistoryRepository extends JpaRepository<AuctionHistory, Integer> {
    List<AuctionHistory> findAuctionHistoryByHistoryId(Integer historyId);
}
