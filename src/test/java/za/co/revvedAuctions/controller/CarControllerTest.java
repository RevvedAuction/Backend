package za.co.revvedAuctions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.repository.CarRepository;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CarRepository carRepository;

    private Car sampleCar;

    @BeforeEach
    void setUp() {
        carRepository.deleteAll();

        sampleCar = new Car.Builder()
                .setCarVIN("VIN123")
                .setCarMake("Toyota")
                .setCarModel("Corolla")
                .setCarYear(2020)
                .setCarMileage(45000)
                .setCarStatus("Available")
                .setMedia("image.jpg")
                .setAuctionEndTime(LocalDateTime.now().plusDays(5))
                .build();

        carRepository.save(sampleCar);
    }

    @Test
    void testGetAllCars() throws Exception {
        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carVIN").value("VIN123"))
                .andExpect(jsonPath("$[0].carMake").value("Toyota"));
    }

    @Test
    void testGetCarByVIN() throws Exception {
        mockMvc.perform(get("/api/cars/VIN123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carModel").value("Corolla"));
    }

    @Test
    void testCreateCar() throws Exception {
        Car newCar = new Car.Builder()
                .setCarVIN("VIN456")
                .setCarMake("Honda")
                .setCarModel("Civic")
                .setCarYear(2022)
                .setCarMileage(12000)
                .setCarStatus("Available")
                .setMedia("honda.jpg")
                .setAuctionEndTime(LocalDateTime.now().plusDays(10))
                .build();

        mockMvc.perform(post("/api/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carVIN").value("VIN456"))
                .andExpect(jsonPath("$.carMake").value("Honda"));
    }

    @Test
    void testUpdateCar() throws Exception {
        Car updatedCar = new Car.Builder()
                .copy(sampleCar)
                .setCarMileage(50000)
                .build();

        mockMvc.perform(put("/api/cars/VIN123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carMileage").value(50000));
    }

    @Test
    void testDeleteCar() throws Exception {
        mockMvc.perform(delete("/api/cars/VIN123"))
                .andExpect(status().isNoContent());
    }
}
