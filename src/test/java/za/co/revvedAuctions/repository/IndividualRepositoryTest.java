//package za.co.revvedAuctions.repository;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.co.revvedAuctions.domain.Individual;
//import za.co.revvedAuctions.factory.IndividualFactory;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class IndividualRepositoryTest {
//
//    private static IIndividualRepository repository = (IIndividualRepository) IndividualRepository.getRepository();
//
//    private Individual individual = IndividualFactory.createIndividual(244452,"Saskia","Jacobs", "JacobsSaskia23@gmail.com",  LocalDate.of(2003, 3, 25),"0507052302003","0848833394","66 DiamondDrive");
//
//    @Test
//    void a_create() {
//        Individual created = repository.create(individual);
//        assertNotNull(created);
//        System.out.println(created.toString());
//    }
//
//    @Test
//    void b_read() {
//        Individual read = repository.read(individual.getIndividualId());
//        assertNotNull(read);
//        System.out.println(read.toString());
//    }
//
//    @Test
//    void c_update() {
//        Individual updated = new Individual.Builder().copy(individual)
//                .setFirstName("Saskia").setLastName("Matthews").build();
//        Individual updated2 = repository.update(updated);
//        assertNotNull(updated2);
//        System.out.println(updated2.toString());
//    }
//
//    @Test
//    @Disabled
//    void d_delete() {
//    assertTrue(repository.delete(individual.getIndividualId()));
//        System.out.println("Deleted individual " + individual.getIndividualId());
//
//    }
//
//    @Test
//    void e_getAll() {
//        System.out.println(repository.getAll());
//    }
//}