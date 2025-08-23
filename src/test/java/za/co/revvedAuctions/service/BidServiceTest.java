package za.co.revvedAuctions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Bid;
import za.co.revvedAuctions.repository.BidRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BidServiceTest {

    @Autowired
    private BidService bidService;

    @Autowired
    private BidRepository bidRepository;

    private Bid testBid;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up test at " + LocalDate.now() + " " + java.time.LocalTime.now() + " SAST");
        // Clear the repository before each test
        bidRepository.deleteAll();
        System.out.println("Repository cleared.");

        // Create a test Bid using the Builder pattern with current date
        testBid = new Bid.Builder()
                .setCarVIN("LUCVXL4X")
                .setAuctionSessionId("SESSION_001")
                .setUserId("USER_001")
                .setBidAmount(69000.0)
                .setBidDate(LocalDate.now()) // Current date: 2025-08-23
                .setStatus("ACTIVE")
                .setTotalBids(1)
                .build();
        System.out.println("Test Bid created: " + testBid);
    }

    @Test
    @Order(1)
    void testCreate() {
        System.out.println("Running testCreate...");
        Bid created = bidService.create(testBid);
        System.out.println("Created Bid: " + created);
        assertNotNull(created);
        assertTrue(created.getBidId() > 0); // Verify auto-generated ID is positive
        assertEquals("LUCVXL4X", created.getCarVIN());
        assertEquals(69000.0, created.getBidAmount());
        assertEquals(LocalDate.now(), created.getBidDate());
    }

    @Test
    @Order(2)
    void testRead() {
        System.out.println("Running testRead...");
        Bid created = bidService.create(testBid);
        System.out.println("Created Bid for read test: " + created);
        Bid found = bidService.read(created.getBidId());
        System.out.println("Found Bid: " + found);
        assertNotNull(found);
        assertEquals("USER_001", found.getUserId());
        assertEquals(created.getBidId(), found.getBidId()); // Verify the same ID
    }

    @Test
    @Order(3)
    void testUpdate() {
        System.out.println("Running testUpdate...");
        Bid created = bidService.create(testBid);
        System.out.println("Created Bid for update test: " + created);
        Bid updatedBid = new Bid.Builder()
                .copy(created) // Copy existing bid with auto-generated bidId
                .setAuctionSessionId("SESSION_002")
                .setBidAmount(70000.0)
                .setBidDate(LocalDate.now().plusDays(1)) // Next day: 2025-08-24
                .setStatus("PENDING")
                .setTotalBids(2)
                .build();
        System.out.println("Updated Bid: " + updatedBid);
        Bid updated = bidService.update(updatedBid);
        System.out.println("Updated Bid result: " + updated);
        assertNotNull(updated);
        assertEquals("SESSION_002", updated.getAuctionSessionId());
        assertEquals(70000.0, updated.getBidAmount());
        assertEquals(LocalDate.now().plusDays(1), updated.getBidDate());
    }

    @Test
    @Order(4)
    void testDelete() {
        System.out.println("Running testDelete...");
        Bid created = bidService.create(testBid);
        System.out.println("Created Bid for delete test: " + created);
        boolean deleted = bidService.delete(created.getBidId());
        System.out.println("Delete result: " + deleted);
        assertTrue(deleted);
        Bid found = bidService.read(created.getBidId());
        System.out.println("Bid after delete: " + found);
        assertNull(found);
    }
}