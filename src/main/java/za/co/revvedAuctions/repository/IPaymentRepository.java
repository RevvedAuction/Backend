package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Payment;
import java.util.List;

public interface IPaymentRepository extends IRepository<Payment, Integer> {
    List<Payment> findByBuyerID(int buyerId);
    List<Payment> findByAuctionID(int auctionId);
    List<Payment> findByStatus(String status);
    List<Payment> findByIsRefunded(boolean isRefunded);
}