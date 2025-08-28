package za.co.revvedAuctions.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.co.revvedAuctions.domain.AuctionHistory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class AuctionHistoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static AuctionHistory history;

    private static final String BASE_URL = "/auctionHistory";

    @BeforeAll
    public static void init() {
        history = new AuctionHistory.Builder()
                .setAuctionSessionId("SESSION_TEST")
                .setCarVIN("VIN_TEST")
                .setUserId("USER_TEST")
                .setSellerId("SELLER_TEST")
                .setBuyerId("BUYER_TEST")
                .setFinalPrice(9999)
                .setAuctionDate(LocalDate.now())
                .setStatus("COMPLETED")
                .build();
    }

    @Test
    void a_create() {
        ResponseEntity<AuctionHistory> response = restTemplate.postForEntity(BASE_URL + "/create", history, AuctionHistory.class);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getHistoryId());

        history = response.getBody(); // Update with persisted entity
        System.out.println("Created AuctionHistory: " + history);
    }

    @Test
    void b_read() {
        ResponseEntity<AuctionHistory> response = restTemplate.getForEntity(BASE_URL + "/read/" + history.getHistoryId(), AuctionHistory.class);
        assertNotNull(response.getBody());
        assertEquals(history.getHistoryId(), response.getBody().getHistoryId());
        System.out.println("Read AuctionHistory: " + response.getBody());
    }

    @Test
    void c_update() {
        AuctionHistory updatedHistory = new AuctionHistory.Builder()
                .copy(history)
                .setFinalPrice(12000)
                .build();

        HttpEntity<AuctionHistory> request = new HttpEntity<>(updatedHistory);
        ResponseEntity<AuctionHistory> response = restTemplate.exchange(BASE_URL + "/update/" + history.getHistoryId(), HttpMethod.PUT, request, AuctionHistory.class);

        assertNotNull(response.getBody());
        assertEquals(12000, response.getBody().getFinalPrice());

        history = response.getBody();
        System.out.println("Updated AuctionHistory: " + history);
    }

    @Test
    void d_getAll() {
        ResponseEntity<AuctionHistory[]> response = restTemplate.getForEntity(BASE_URL + "/getAll", AuctionHistory[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 1);
        System.out.println("All AuctionHistories: ");
        for (AuctionHistory h : response.getBody()) System.out.println(h);
    }

    @Test
    void e_getBySession() {
        ResponseEntity<AuctionHistory[]> response = restTemplate.getForEntity(BASE_URL + "/getBySession/SESSION_TEST", AuctionHistory[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length >= 1);
        System.out.println("AuctionHistories for SESSION_TEST: ");
        for (AuctionHistory h : response.getBody()) System.out.println(h);
    }

    @Test
    @Disabled
    void f_delete() {
        restTemplate.delete(BASE_URL + "/delete/" + history.getHistoryId());

        ResponseEntity<AuctionHistory> response = restTemplate.getForEntity(BASE_URL + "/read/" + history.getHistoryId(), AuctionHistory.class);
        assertNull(response.getBody());
        System.out.println("Deleted AuctionHistory with ID: " + history.getHistoryId());
    }
}
