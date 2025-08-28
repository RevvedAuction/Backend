package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Payment;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // These methods will be implemented by Spring Data JPA
    List<Payment> findByBuyerID(int buyerId);
    List<Payment> findByAuctionID(int auctionId);
    List<Payment> findByStatus(String status);
//    List<Payment> findByIsRefunded(boolean isRefunded);
}