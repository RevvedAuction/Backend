package za.co.revvedAuctions.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.revvedAuctions.domain.Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

    private static IPaymentRepository repository = (IPaymentRepository) PaymentRepository.getRepository();
    private static int testPaymentId;

    private Payment payment = new Payment.Builder()
            .setAmount(15000.00)
            .setPaymentMethod("Credit Card")
            .setPaymentDate(LocalDateTime.now())
            .setStatus("PENDING")
            .setBuyerID(101)
            .setAuctionID(201)
            .setRefunded(false)
            .setProcessPay(false)
            .build();

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertNotNull(created);
        testPaymentId = created.getPaymentID();
        System.out.println("Created: " + created.toString());
    }

    @Test
    void b_read() {
        Payment read = repository.read(testPaymentId);
        assertNotNull(read);
        assertEquals(testPaymentId, read.getPaymentID());
        assertEquals(15000.00, read.getAmount());
        assertEquals("Credit Card", read.getPaymentMethod());
        System.out.println("Read: " + read.toString());
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment)
                .setPaymentID(testPaymentId)
                .setStatus("COMPLETED")
                .setProcessPay(true)
                .build();
        Payment updatedPayment = repository.update(updated);
        assertNotNull(updatedPayment);
        assertEquals("COMPLETED", updatedPayment.getStatus());
        assertTrue(updatedPayment.isProcessPay());
        System.out.println("Updated: " + updatedPayment.toString());
    }

    @Test
    void d_delete() {
        boolean deleted = repository.delete(testPaymentId);
        assertTrue(deleted);
        System.out.println("Deleted payment: " + testPaymentId);

        // Verify deletion
        Payment deletedPayment = repository.read(testPaymentId);
        assertNull(deletedPayment);
    }

    @Test
    void e_getAll() {
        // Create another payment for testing getAll
        Payment secondPayment = new Payment.Builder()
                .setAmount(20000.00)
                .setPaymentMethod("PayPal")
                .setPaymentDate(LocalDateTime.now())
                .setStatus("COMPLETED")
                .setBuyerID(102)
                .setAuctionID(202)
                .setRefunded(false)
                .setProcessPay(true)
                .build();
        repository.create(secondPayment);

        System.out.println("All Payments: " + repository.getAll());
        assertTrue(repository.getAll().size() >= 2);
    }

    @Test
    void f_findByBuyerID() {
        // Create payment for specific buyer
        Payment buyerPayment = new Payment.Builder()
                .setAmount(25000.00)
                .setPaymentMethod("Bank Transfer")
                .setPaymentDate(LocalDateTime.now())
                .setStatus("PENDING")
                .setBuyerID(105) // Specific buyer ID
                .setAuctionID(205)
                .setRefunded(false)
                .setProcessPay(false)
                .build();
        repository.create(buyerPayment);

        var buyerPayments = repository.findByBuyerID(105);
        assertFalse(buyerPayments.isEmpty());
        assertEquals(105, buyerPayments.get(0).getBuyerID());
        System.out.println("Payments for Buyer 105: " + buyerPayments);
    }

    @Test
    void g_findByAuctionID() {
        // Create payment for specific auction
        Payment auctionPayment = new Payment.Builder()
                .setAmount(30000.00)
                .setPaymentMethod("Credit Card")
                .setPaymentDate(LocalDateTime.now())
                .setStatus("COMPLETED")
                .setBuyerID(106)
                .setAuctionID(210) // Specific auction ID
                .setRefunded(false)
                .setProcessPay(true)
                .build();
        repository.create(auctionPayment);

        var auctionPayments = repository.findByAuctionID(210);
        assertFalse(auctionPayments.isEmpty());
        assertEquals(210, auctionPayments.get(0).getAuctionID());
        System.out.println("Payments for Auction 210: " + auctionPayments);
    }

    @Test
    void h_findByStatus() {
        // Create a completed payment
        Payment completedPayment = new Payment.Builder()
                .setAmount(18000.00)
                .setPaymentMethod("Debit Card")
                .setPaymentDate(LocalDateTime.now())
                .setStatus("COMPLETED")
                .setBuyerID(107)
                .setAuctionID(207)
                .setRefunded(false)
                .setProcessPay(true)
                .build();
        repository.create(completedPayment);

        var completedPayments = repository.findByStatus("COMPLETED");
        var pendingPayments = repository.findByStatus("PENDING");

        assertFalse(completedPayments.isEmpty());
        assertFalse(pendingPayments.isEmpty());
        assertEquals("COMPLETED", completedPayments.get(0).getStatus());
        System.out.println("Completed Payments: " + completedPayments);
        System.out.println("Pending Payments: " + pendingPayments);
    }

    @Test
    void i_findByIsRefunded() {
        // Create a refunded payment
        Payment refundedPayment = new Payment.Builder()
                .setAmount(12000.00)
                .setPaymentMethod("Credit Card")
                .setPaymentDate(LocalDate.now())
                .setStatus("REFUNDED")
                .setBuyerID(108)
                .setAuctionID(208)
                .setRefunded(true) // This one is refunded
                .setProcessPay(true)
                .build();
        repository.create(refundedPayment);

        var refundedPayments = repository.findByIsRefunded(true);
        var nonRefundedPayments = repository.findByIsRefunded(false);

        assertFalse(refundedPayments.isEmpty());
        assertTrue(refundedPayments.get(0).isRefunded());
        System.out.println("Refunded Payments: " + refundedPayments);
        System.out.println("Non-Refunded Payments: " + nonRefundedPayments);
    }
}