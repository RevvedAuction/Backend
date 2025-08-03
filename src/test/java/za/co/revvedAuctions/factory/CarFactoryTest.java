package za.co.revvedAuctions.factory;

import org.junit.jupiter.api.Test;
import za.co.revvedAuctions.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    private static Car c1 =CarFactory.createCar("","","",2,3,"","","");
    private static Car c2 =CarFactory.createCar("","","",2,3,"","","");
    private static Car c3 =CarFactory.createCar("","","",2,3,"","","");
    @Test
    public void testCreateCar() {
        assertNotNull(c1);
        System.out.println(c1.toString());

    }
    @Test
    public void testCreateCarVIN() {
assertNotNull(c2);
System.out.println(c2.toString());
    }

@Test
public void testCreateCarFails() {
        assertNull(c3);
        System.out.println(c3.toString());

        fail();
    }

}