package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Payment;
import za.co.revvedAuctions.repository.PaymentRepository;
import za.co.revvedAuctions.service.IPaymentService;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByID(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getPaymentsByBuyer(int buyerId) {
        return paymentRepository.findByBuyerID(buyerId);
    }

    @Override
    public List<Payment> getPaymentsByAuction(int auctionId) {
        return paymentRepository.findByAuctionID(auctionId);
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public Payment processPayment(int paymentId) {
        Payment payment = getPaymentByID(paymentId);
        if (payment != null) {
            // Business logic for processing payment
            // This would integrate with payment gateway in real scenario
            payment.setStatus("PROCESSED");
            payment.setProcessPay(true);
            return savePayment(payment);
        }
        return null;
    }

    @Override
    public Payment refundPayment(int paymentId) {
        Payment payment = getPaymentByID(paymentId);
        if (payment != null && payment.isProcessPay()) {
            // Business logic for refund
            payment.setStatus("REFUNDED");
            payment.setRefunded(true);
            return savePayment(payment);
        }
        return null;
    }
}