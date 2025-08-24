package za.co.revvedAuctions.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.co.revvedAuctions.domain.Bid;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BidControllerTest {

    private static Bid bid;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "/bids";

    @BeforeAll
    public static void setUp() {
        bid = new Bid.Builder()
                .setCarVIN("VIN123")
                .setAuctionSessionId("AUCTION1")
                .setUserId("USER1")
                .setBidAmount(5000)
                .setBidDate(LocalDate.now())
                .setStatus("PENDING")
                .setTotalBids(1)
                .build();
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Bid> response = restTemplate.postForEntity(url, bid, Bid.class);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getBidId());
        bid = response.getBody(); // save generated ID for later
        System.out.println("Created Bid: " + bid);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + bid.getBidId();
        ResponseEntity<Bid> response = restTemplate.getForEntity(url, Bid.class);
        assertNotNull(response.getBody());
        assertEquals(bid.getBidId(), response.getBody().getBidId());
        System.out.println("Read Bid: " + response.getBody());
    }

    @Test
    void c_update() {
        Bid updatedBid = new Bid.Builder().copy(bid)
                .setBidAmount(6000)
                .build();
        String url = BASE_URL + "/update/" + bid.getBidId();
        HttpEntity<Bid> request = new HttpEntity<>(updatedBid);
        ResponseEntity<Bid> response = restTemplate.exchange(url, HttpMethod.PUT, request, Bid.class);
        assertNotNull(response.getBody());
        assertEquals(6000, response.getBody().getBidAmount());
        bid = response.getBody();
        System.out.println("Updated Bid: " + bid);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + bid.getBidId();
        restTemplate.delete(url);
        ResponseEntity<Bid> response = restTemplate.getForEntity(BASE_URL + "/read/" + bid.getBidId(), Bid.class);
        assertNull(response.getBody());
        System.out.println("Deleted Bid: true");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Bid[]> response = restTemplate.getForEntity(url, Bid[].class);
        assertNotNull(response.getBody());
        System.out.println("All Bids:");
        for (Bid b : response.getBody()) {
            System.out.println(b);
        }
    }
}
