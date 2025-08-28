package za.co.revvedAuctions.factory;

import org.junit.jupiter.api.Test;
import za.co.revvedAuctions.domain.Buyer;

import static org.junit.jupiter.api.Assertions.*;

class BuyerFactoryTest {

//    @Test
//    void createBuyer_withValidData_returnsBuyerObject() {
//        Buyer buyer = BuyerFactory.createBuyer(
//                "BYR001",
//                "Esihle Mlinjana",
//                "esihlem@gmail.com",
//                "mleeJay",
//                "0735537078",
//                "Sedan",
//                "Credit Card",
//                true
//        );
//
//        assertNotNull(buyer, "Buyer should not be null");
//        assertNotNull(buyer.getBuyerId(), "Buyer ID should be generated");
//        assertEquals("BYR001", buyer.getUserId());
//        assertEquals("Esihle Mlinjana", buyer.getFullName());
//        assertEquals("esihlem@gmail.com", buyer.getEmail());
//        assertEquals("0735537078", buyer.getPhoneNumber());
//        assertEquals("Sedan", buyer.getPreferredCarType());
//        assertEquals("Credit Card", buyer.getPaymentMethod());
//        assertTrue(buyer.isVerified());
//    }
//
//    @Test
//    void createBuyer_withMissingRequiredFields_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            BuyerFactory.createBuyer(
//                    "BYR002",
//                    "",
//                    "zeentlezee@gmail.com",
//                    "Bubbles",
//                    "0764849235",
//                    "SUV",
//                    "Bank Transfer",
//                    false
//            );
//        }, "Should throw IllegalArgumentException for empty fullName");
//    }
//
//    @Test
//    void createBuyer_withNullEmail_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            BuyerFactory.createBuyer(
//                    "BYR003",
//                    "Liam Matthews",
//                    null,
//                    "CloudNine",
//                    "0849833351",
//                    "Hatchback",
//                    "Bank Transfer",
//                    false
//            );
//        }, "Should throw IllegalArgumentException for null email");
//    }
//
//    @Test
//    void createBuyer_withInvalidEmail_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            BuyerFactory.createBuyer(
//                    "BYR004",
//                    "Alexander Eguasa",
//                    "invalid-email", // Invalid email
//                    "Liyana2024",
//                    "0784460783",
//                    "Coupe",
//                    "Credit Card",
//                    true
//            );
//        }, "Should throw IllegalArgumentException for invalid email");
//    }
}
