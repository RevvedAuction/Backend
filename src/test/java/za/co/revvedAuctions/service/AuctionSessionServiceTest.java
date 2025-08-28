package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.AuctionSession;
import za.co.revvedAuctions.factory.AuctionSessionFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AuctionSessionServiceTest {

//    @Autowired
//    private IAuctionSessionService service;
//
//    public static AuctionSession auctionSession = AuctionSessionFactory.createAuctionSession(
//            "SID1",
//            LocalTime.of(9, 0),
//            LocalTime.of(10, 30),
//            LocalDate.of(2025, 4, 28),
//            true,
//            "1HGCM82633A004352");
//
//    @Test
//    void create() {
//        AuctionSession newCustomer = service.create(auctionSession);
//        assertNotNull(newCustomer);
//        System.out.println(newCustomer);
//    }
//
//    @Test
//    void read() {
//        AuctionSession read = service.read(auctionSession.getSessionID());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void update() {
//        AuctionSession updateBook = new AuctionSession.Builder().copy(auctionSession).setSessionStatus(false).build();
//        AuctionSession updated = service.update(updateBook);
//        assertNotNull(updated);
//        System.out.println(updated);
//    }
//
//    @Test
//    void delete() {
//        assertTrue(service.delete(auctionSession.getSessionID()));
//        System.out.println("Book has been successfully deleted!:)");
//    }
//
//    @Test
//    void getAll() {
//        System.out.println(service.getAll());
//    }

}