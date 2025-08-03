package za.co.revvedAuctions.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.factory.CarFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CarRepositoryTest {

    private static ICarRepository repository = CarRepository.getRepository();

    private Car car = CarFactory.createCar(
            "VIN123",       // carVIN
            "Toyota",       // make
            "Corolla",      // model
            2015,           // year
            4,              // doors
            "White",        // color
            "Available",    // status
            "Petrol"        // fuelType
    );


    @Test
    void a_create() {
        Car created = repository.create(car);
    assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void b_read() {
Car read = repository.read(car.getCarVIN());
assertNotNull(read);
System.out.println(read.toString());
    }

    @Test
    void c_update() {
        Car newCar = new Car.Builder().copy(car).setCarVIN("VIN123").build();
        Car updated = repository.update(newCar);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    @Disabled
    void d_delete() {
        assertTrue(repository.delete(car.getCarVIN()));
        System.out.println("success: employee deleted");
    }

    @Test
    void e_getAll() {
        List<Car> all = repository.getAll();
    }
}