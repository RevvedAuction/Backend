package za.co.revvedAuctions.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Payment;
import za.co.revvedAuctions.factory.PaymentFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

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
    void a_createPayment() {
        Payment created = paymentController.createPayment(payment);
        assertNotNull(created);
        testPaymentId = created.getPaymentID();
        System.out.println("Created via Controller: " + created.toString());
    }

    @Test
    void b_getPaymentByID() {
        Payment found = paymentController.getPaymentByID(testPaymentId);
        assertNotNull(found);
        assertEquals(testPaymentId, found.getPaymentID());
        System.out.println("Found via Controller: " + found.toString());
    }

    @Test
    void c_getAllPayments() {
        System.out.println("All Payments via Controller: " + paymentController.getAllPayments());
        assertNotNull(paymentController.getAllPayments());
    }

    @Test
    void d_updatePayment() {
        Payment updatedPayment = new Payment.Builder().copy(payment)
                .setPaymentID(testPaymentId)
                .setStatus("COMPLETED")
                .setProcessPay(true)
                .build();

        Payment updated = paymentController.updatePayment(testPaymentId, updatedPayment);
        assertNotNull(updated);
        assertEquals("COMPLETED", updated.getStatus());
        System.out.println("Updated via Controller: " + updated.toString());
    }

    @Test
    void e_deletePayment() {
        String result = paymentController.deletePayment(testPaymentId);
        assertEquals("Payment deleted successfully", result);
        System.out.println("Deleted via Controller: " + testPaymentId);
    }

    @Test
    void f_getPaymentsByBuyer() {
        System.out.println("Payments for Buyer 101 via Controller: " + paymentController.getPaymentsByBuyer(101));
    }

    @Test
    void g_getPaymentsByAuction() {
        System.out.println("Payments for Auction 201 via Controller: " + paymentController.getPaymentsByAuction(201));
    }

    @Test
    void h_processPayment() {
        Payment processed = paymentController.processPayment(testPaymentId);
        assertNotNull(processed);
        assertEquals("PROCESSED", processed.getStatus());
        System.out.println("Processed via Controller: " + processed.toString());
    }
}