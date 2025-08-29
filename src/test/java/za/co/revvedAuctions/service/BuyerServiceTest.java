package za.co.revvedAuctions.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Buyer;
import za.co.revvedAuctions.factory.BuyerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BuyerServiceTest {

    @Autowired
    private IBuyerService service;

    private final Buyer buyer = BuyerFactory.createBuyer(
            "BYR001",
            "Esihle Mlinjana",
            "esihle@gmail.com",
            "mleeJay",
            "0735537078",
            "Sedan",
            "Credit Card",
            true
    );

    @Test
    void create() {
        Buyer created = service.create(buyer);
        assertNotNull(created, "Created Buyer should not be null");
        assertNotNull(created.getBuyerId(), "Buyer ID should be generated");
        assertEquals("Esihle Mlinjana", created.getFullName());
        System.out.println(created);

        Buyer invalidBuyer = new Buyer.Builder()
                .setBuyerId("BYR999")
                .setUserId("BYR002")
                .setFullName("Invalid User")
                .setEmail("invalid-email") // invalid email
                .setPassword("mleeJay")
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            service.create(invalidBuyer);
        }, "Should throw IllegalArgumentException for invalid email");
    }

    @Test
    void read() {
        Buyer created = service.create(buyer);
        Buyer read = service.read(created.getBuyerId());
        assertNotNull(read, "Read Buyer should not be null");
        assertEquals(created.getBuyerId(), read.getBuyerId(), "Buyer ID should match");
        System.out.println(read);

        assertThrows(IllegalArgumentException.class, () -> {
            service.read(null);
        }, "Should throw IllegalArgumentException for null buyerId");
    }

    @Test
    void update() {
        Buyer created = service.create(buyer);
        Buyer updatedBuyer = new Buyer.Builder()
                .copy(created)
                .setPreferredCarType("SUV")
                .build();

        Buyer updated = service.update(updatedBuyer);
        assertNotNull(updated, "Updated Buyer should not be null");
        assertEquals("SUV", updated.getPreferredCarType(), "Preferred car type should be updated");
        System.out.println(updated);

        Buyer invalidBuyer = new Buyer.Builder()
                .copy(created)
                .setEmail("bad-email") // invalid email
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            service.update(invalidBuyer);
        }, "Should throw IllegalArgumentException for invalid email");
    }

    @Test
    void delete() {
        Buyer created = service.create(buyer);
        boolean deleted = service.delete(created.getBuyerId());
        assertTrue(deleted, "Buyer should be deleted");
        System.out.println("Buyer successfully deleted! :)");

        boolean notFound = service.delete("NON_EXISTENT_ID");
        assertFalse(notFound, "Deleting non-existent Buyer should return false");

        assertThrows(IllegalArgumentException.class, () -> {
            service.delete(null);
        }, "Should throw IllegalArgumentException for null buyerId");
    }

    @Test
    void getAll() {
        service.create(buyer);
        List<Buyer> buyers = service.getAll();
        assertNotNull(buyers, "Buyer list should not be null");
        assertFalse(buyers.isEmpty(), "Buyer list should not be empty");
        System.out.println(buyers);
    }
}
