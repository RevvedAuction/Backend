package za.co.revvedAuctions.controller;

/*
Author: Fhumulani Moses Makungo (230787932)
alias: KodeKnack
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Payment;
import za.co.revvedAuctions.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:8082")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentByID(@PathVariable("id") int id) {
        Payment payment = paymentService.getPaymentByID(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") int id, @RequestBody Payment updatedPayment) {
        Payment existingPayment = paymentService.getPaymentByID(id);

        if (existingPayment != null) {
            Payment paymentToUpdate = new Payment.Builder()
                    .copy(existingPayment)
                    .setAmount(updatedPayment.getAmount())
                    .setPaymentMethod(updatedPayment.getPaymentMethod())
                    .setPaymentDate(updatedPayment.getPaymentDate())
                    .setStatus(updatedPayment.getStatus())
                    .setBuyerID(updatedPayment.getBuyerID())
                    .setAuctionID(updatedPayment.getAuctionID())
                    .setRefunded(updatedPayment.isRefunded())
                    .setProcessPay(updatedPayment.isProcessPay())
                    .build();

            Payment savedPayment = paymentService.savePayment(paymentToUpdate);
            return ResponseEntity.ok(savedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable("id") int id) {
        Payment payment = paymentService.getPaymentByID(id);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}