package za.co.revvedAuctions.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.factory.AdminFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminServiceTest {

    @Autowired
    private IAdminService service;

    private final Admin admin = AdminFactory.createAdmin(
            "Zintle Mgqongose",
            "zeentlezee@gmail.com",
            "Happiness!",
            "0764849235",
            "System Admin",
            true
    );

    @Test
    void create() {
        Admin created = service.create(admin);
        assertNotNull(created, "Created Admin should not be null");
        assertNotNull(created.getAdminId(), "Admin ID should be generated"); // FIXED
        System.out.println(created);

        Admin invalidAdmin = new Admin.Builder()
                .setAdminId("ADM002")
                .setFullName("Caitlin")
                .setEmail("invalid-email")
                .setPassword("pass123")
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(invalidAdmin);
        }, "Should throw IllegalArgumentException for invalid email");
    }

    @Test
    void read() {
        Admin created = service.create(admin);
        Admin read = service.read(created.getAdminId()); // FIX: use created.getAdminId()
        assertNotNull(read, "Read Admin should not be null");
        assertEquals(created.getAdminId(), read.getAdminId(), "Admin ID should match");
        System.out.println(read);

        assertThrows(IllegalArgumentException.class, () -> {
            service.read(null);
        }, "Should throw IllegalArgumentException for null adminId");
    }

    @Test
    void update() {
        Admin created = service.create(admin);
        Admin updatedAdmin = new Admin.Builder()
                .copy(created)
                .setFullName("Zintle Mgqongose")
                .build();
        Admin updated = service.update(updatedAdmin);
        assertNotNull(updated, "Updated Admin should not be null");
        assertEquals("Zintle Mgqongose", updated.getFullName(), "Full name should be updated");
        System.out.println(updated);

        Admin invalidAdmin = new Admin.Builder()
                .copy(created)
                .setEmail("invalid-email")
                .build();
        assertThrows(IllegalArgumentException.class, () -> {
            service.update(invalidAdmin);
        }, "Should throw IllegalArgumentException for invalid email");
    }

    @Test
    void delete() {
        Admin created = service.create(admin);
        boolean deleted = service.delete(created.getAdminId()); // FIX: use created.getAdminId()
        assertTrue(deleted, "Admin should be deleted");
        System.out.println("Admin has been successfully deleted! :)");

        boolean notFound = service.delete("NON_EXISTENT_ID");
        assertFalse(notFound, "Deleting non-existent Admin should return false");

        assertThrows(IllegalArgumentException.class, () -> {
            service.delete(null);
        }, "Should throw IllegalArgumentException for null adminId");
    }

    @Test
    void getAll() {
        service.create(admin);
        List<Admin> admins = service.getAll();
        assertNotNull(admins, "Admin list should not be null");
        assertFalse(admins.isEmpty(), "Admin list should not be empty");
        System.out.println(admins);
    }
}
