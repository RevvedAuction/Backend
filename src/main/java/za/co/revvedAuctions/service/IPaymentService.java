package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Payment;
import java.util.List;

public interface IPaymentService {
    Payment savePayment(Payment payment);
    Payment getPaymentByID(int id);
    List<Payment> getAllPayments();
    void deletePayment(int id);
    // Custom business methods
    List<Payment> getPaymentsByBuyer(int buyerId);
    List<Payment> getPaymentsByAuction(int auctionId);
    List<Payment> getPaymentsByStatus(String status);
    Payment processPayment(int paymentId);
    Payment refundPayment(int paymentId);
}