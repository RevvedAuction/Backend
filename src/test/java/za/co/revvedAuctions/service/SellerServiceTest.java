package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Seller;
import za.co.revvedAuctions.factory.SellerFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class SellerServiceTest {

//    @Autowired
//    private ISellerService service;
//
//    private static Seller sellerList = SellerFactory.createSeller(
//            "SEID001",
//            "Inidividual");
//
//
//    @Test
//    void create() {
//        Seller newCustomer = service.create(sellerList);
//        assertNotNull(newCustomer);
//        System.out.println(newCustomer);
//    }
//
//    @Test
//    void read() {
//        Seller read = service.read(sellerList.getSellerId());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void update() {
//        Seller updateBook = new Seller.Builder().copy(sellerList).setBusinessType("Company").build();
//        Seller updated = service.update(updateBook);
//        assertNotNull(updated);
//        System.out.println(updated);
//    }
//
//    @Test
//    void delete() {
//        assertTrue(service.delete(sellerList.getSellerId()));
//        System.out.println("Book has been successfully deleted!:)");
//    }
//
//    @Test
//    void getAll() {
//        System.out.println(service.getAll());
//    }
}