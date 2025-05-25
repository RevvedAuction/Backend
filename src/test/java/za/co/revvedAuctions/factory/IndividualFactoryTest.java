package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Individual;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
public class IndividualFactoryTest {

    private static Individual individual1 = IndividualFactory.createIndividual(123, "John", "Doe", "mlinjanae@gmail.com", "123456");

    private static Individual individual2 = IndividualFactory.createIndividual(123, "John", "Doe", "inathi@gmail.com", LocalDate.of(1990, 5, 8), 123456789, "123456789", "123 za.co.revvedAuctions.Main St");

    @Test
    public void createIndividual() {
        assertNotNull(individual1);
        System.out.println(individual1.toString());
    }

    @Test
    public void createIndividualWithDateOfBirth() {
        assertNotNull(individual2);
        System.out.println(individual2.toString());
    }
}