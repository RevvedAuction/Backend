package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.AuctionSession;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AuctionSessionFactoryTest {

    private static AuctionSession auctionSessionList1 = AuctionSessionFactory.createAuctionSession(
            "SID1",
            LocalTime.of(9, 0),
            LocalTime.of(10, 30),
            LocalDate.of(2025, 4, 28),
            true,
            "1HGCM82633A004352"
    );

    private static AuctionSession auctionSessionList2 = AuctionSessionFactory.createAuctionSession(
            "",
            LocalTime.of(10, 0),
            LocalTime.of(13, 30),
            LocalDate.of(2025, 4, 28),
            true,
            "1HGCM835733A004352"
    );

    @Test
    public void testCreateBook() {
        assertNotNull(auctionSessionList1);
        System.out.println(auctionSessionList1.toString());

    }


    @Test
    public void testCreateBookThatFails(){
        assertNotNull(auctionSessionList2);
        System.out.println(auctionSessionList2.toString());
    }

}