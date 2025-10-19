package za.co.revvedAuctions.service.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.repository.CarRepository;
import za.co.revvedAuctions.service.implementation.CarService;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService; // now Spring injects it

    @Autowired
    private CarRepository carRepository;

    private Car sampleCar;
    private byte[] sampleImage;

    @BeforeEach
    void setUp() throws Exception {
        // Load sample image
        try (InputStream is = getClass().getResourceAsStream("/images/s.jpg")) {
            sampleImage = is != null ? is.readAllBytes() : null;
        }

        sampleCar = new Car.Builder()
                .setCarVIN("1HGCM82633A004352")
                .setCarMake("Toyota")
                .setCarModel("Corolla")
                .setCarYear(2018)
                .setCarMileage(45000)
                .setCarStatus("Available")
                .setAuctionEndTime(LocalDateTime.now().plusDays(7))
                .setMediaBase64(sampleImage)
                .build();
    }

    @Test
    void testSaveAndGetCar() {
        carService.saveCar(sampleCar);

        Car retrieved = carService.getCarByVIN("1HGCM82633A004352");
        assertNotNull(retrieved);
        assertEquals("Toyota", retrieved.getCarMake());
    }
}