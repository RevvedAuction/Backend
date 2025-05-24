package Factory;

import Domain.AuctionHistory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuctionHistoryFactoryTest {

    public static AuctionHistory auctionHistory1 = AuctionHistoryFactory.createAuctionHistory(
            (short) 1,
            "AS123",
            "VIN123456",
            "USER123",
            "SELLER123",
            "BUYER123",
            10000.0,
            LocalDate.of(2023, 10, 1),
            "Completed");

    public static AuctionHistory auctionHistory2 = AuctionHistoryFactory.createAuctionHistory(
            (short) 2,
            "AS456",
            "",
            "",
            "",
            "BUYER123",
            10000.0,
            LocalDate.of(2023, 10, 1),
            "Completed");

    @Test
    public void testCreateAuctionHistory() {
        assertNotNull(auctionHistory1);
        System.out.println(auctionHistory1.toString());

    }
    @Test
    public void testThatFails() {
        assertNotNull(auctionHistory2);
        System.out.println(auctionHistory2.toString());
    }

}