package Factory;

import Domain.Seller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerFactoryTest {

    private static Seller sellerList1 = SellerFactory.createSeller(
            "SEID001",
            "Inidividual");

    private static Seller sellerList2 = SellerFactory.createSeller(
            "SEID002",
            "Company");

    private static Seller sellerList3 = SellerFactory.createSeller(
            "",
            "Inidividual");

    @Test
    public void testCreateBook() {
        assertNotNull(sellerList1);
        System.out.println(sellerList1.toString());

    }

    @Test
    public void testCreateBookWithAllAttributes() {
        assertNotNull(sellerList2);
        System.out.println(sellerList2.toString());
    }

    @Test
    public void testCreateBookThatFails(){
        assertNotNull(sellerList3);
        System.out.println(sellerList3.toString());
    }
}