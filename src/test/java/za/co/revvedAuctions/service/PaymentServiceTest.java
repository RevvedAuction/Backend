package za.co.revvedAuctions.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.revvedAuctions.domain.Payment;
import za.co.revvedAuctions.factory.PaymentFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    private static IPaymentService service = PaymentService.getService();
    private static int testPaymentId;

    private Payment payment = PaymentFactory.createPayment(
            15000.00,
            "Credit Card",
            LocalDateTime.now(),
            "PENDING",
            101,
            201,
            false,
            false
    );

    @Test
    void a_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        testPaymentId = created.getPaymentID();
        System.out.println("Created: " + created.toString());
    }

    @Test
    void b_read() {
        Payment read = service.read(testPaymentId);
        assertNotNull(read);
        assertEquals(testPaymentId, read.getPaymentID());
        System.out.println("Read: " + read.toString());
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment)
                .setPaymentID(testPaymentId)
                .setStatus("COMPLETED")
                .build();
        Payment updatedPayment = service.update(updated);
        assertNotNull(updatedPayment);
        assertEquals("COMPLETED", updatedPayment.getStatus());
        System.out.println("Updated: " + updatedPayment.toString());
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(testPaymentId);
        assertTrue(deleted);
        System.out.println("Deleted payment: " + testPaymentId);
    }

    @Test
    void e_getAll() {
        System.out.println("All Payments: " + service.getAll());
    }

    @Test
    void f_processPayment() {
        Payment processed = service.processPayment(testPaymentId);
        assertNotNull(processed);
        assertEquals("PROCESSED", processed.getStatus());
        assertTrue(processed.isProcessPay());
        System.out.println("Processed: " + processed.toString());
    }

    @Test
    void g_refundPayment() {
        Payment refunded = service.refundPayment(testPaymentId);
        assertNotNull(refunded);
        assertEquals("REFUNDED", refunded.getStatus());
        assertTrue(refunded.isRefunded());
        System.out.println("Refunded: " + refunded.toString());
    }

    @Test
    void h_getPaymentsByBuyer() {
        System.out.println("Payments for Buyer 101: " + service.getPaymentsByBuyer(101));
    }

    @Test
    void i_getPaymentsByAuction() {
        System.out.println("Payments for Auction 201: " + service.getPaymentsByAuction(201));
    }

    @Test
    void j_getPaymentsByStatus() {
        System.out.println("Completed Payments: " + service.getPaymentsByStatus("COMPLETED"));
    }
}