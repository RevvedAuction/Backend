package za.co.revvedAuctions.factory;

import org.junit.jupiter.api.Test;
import za.co.revvedAuctions.domain.Admin;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {


//    @Test
//    void createAdmin_withValidData_returnsAdminObject() {
//        Admin admin = AdminFactory.createAdmin(
//                12345,
//                "Zintle Mgqongose",
//                "zeentlezee@gmail.com",
//                "Happiness!",
//                "0764849235",
//                "System Admin",
//                true
//        );
//
//        assertNotNull(admin, "Admin should not be null");
//        assertNotNull(admin.getAdminId(), "Admin ID should be generated");
//        assertEquals("Zintle Mgqongose", admin.getFullName());
//        assertEquals("zeentlezee@gmail.com", admin.getEmail());
//        assertEquals("Happiness!", admin.getPassword());
//        assertEquals("0764849235", admin.getPhoneNumber());
//        assertEquals("System Admin", admin.getRole());
//        assertTrue(admin.isActive());
//        assertEquals(LocalDate.now(), admin.getDateCreated(), "Date created should be today");
//    }
//
//
//    @Test
//    void createAdmin_withMissingRequiredFields_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            AdminFactory.createAdmin(
//                    1234,
//                    "zeentlezee@gmail.com",
//                    "Happiness!",
//                    "0764849235",
//                    "System Admin",
//                    "user",
//                    true
//            );
//        }, "Should throw IllegalArgumentException for empty fullName");
//    }
//
//
//    @Test
//    void createAdmin_withNullEmail_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            AdminFactory.createAdmin(
//                    1234,
//                    "Zintle Mgqongose",
//                    null,
//                    "Happiness!",
//                    "0764849235",
//                    "System Admin",
//                    true
//            );
//        }, "Should throw IllegalArgumentException for null email");
//    }
//
//
//    @Test
//    void createAdmin_withInvalidEmail_throwsException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            AdminFactory.createAdmin(
//                    12345,
//                    "Zintle Mgqongose",
//                    "invalid-email", // Invalid email
//                    "Happiness!",
//                    "0764849235",
//                    "System Admin",
//                    true
//            );
//        }, "Should throw IllegalArgumentException for invalid email");
//    }
}