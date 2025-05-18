package Factory;

import Domain.Bid;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BidFactoryTest {

    public static Bid bid1  = BidFactory.createBid(
            "AS123",
            "VIN123",
            "User123",
            1000.00,
            LocalDate.of(2023, 10, 1),
            "Pending");
    public static Bid bid2  = BidFactory.createBid("",
                                               "",
                                             "User123", 1000.00, LocalDate.of(2023,
                                        10, 1), "Pending");

    @Test
    public void createBid() {
        assertNotNull(bid1);
        System.out.println(bid1.toString());
    }

    @Test
    public void createBidWithNullValues() {
        assertNotNull(bid2);
        System.out.println(bid2.toString());

    }
    @Test
    @Disabled
    @Order(4)
    public void testNotImplementedYet(){


    }


}