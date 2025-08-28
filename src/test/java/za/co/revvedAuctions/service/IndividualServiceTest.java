package za.co.revvedAuctions.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Individual;
import za.co.revvedAuctions.factory.IndividualFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class IndividualServiceTest {

//    @Autowired
//    private IIndividualService service;
//
//    public static Individual individual = IndividualFactory.createIndividual(
//            12,
//           "Esihle",
//            "Mlinjana",
//            "mlinjana@gmail.com",
//            LocalDate.of(2002,10,30),
//            "0210301246083",
//            "+27755537078",
//            "4 Gillo"
//            );
//
//    @Test
//    void create() {
//        Individual newCustomer = service.create(individual);
//        assertNotNull(newCustomer);
//        System.out.println(newCustomer);
//    }
//
//    @Test
//    void read() {
//        Individual read = service.read(individual.getIdentityNumber());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void update() {
//        Individual updatedInd = new Individual.Builder()
//                .copy(individual)
//                .setFirstName("UpdatedName")
//                .build();
//        Individual updated = service.update(updatedInd);
//    }
//
//    @Test
//    void delete() {
//        assertTrue(service.delete(individual.getIdentityNumber()));
//        System.out.println("Individual has been successfully deleted!:)");
//    }
//
//    @Test
//    void getAll() {
//        System.out.println(service.getAll());
//    }
}
