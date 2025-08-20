package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:8080") // Adjust for your Vue.js frontend port
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Add a new car
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return ResponseEntity.ok(savedCar);
    }

    // Get a single car by VIN
    @GetMapping("/{vin}")
    public ResponseEntity<Car> getCarByVIN(@PathVariable("vin") String vin) {
        Car car = carService.getCarByVIN(vin);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //  Get all active auctions
    @GetMapping("/active")
    public ResponseEntity<List<Car>> getActiveAuctions() {
        return ResponseEntity.ok(carService.getActiveAuctions());
    }

    // Update car details
    @PutMapping("/{vin}")
    public ResponseEntity<Car> updateCar(@PathVariable("vin") String vin, @RequestBody Car updatedCar) {
        Car existingCar = carService.getCarByVIN(vin);

        if (existingCar != null) {
            // Use Builder.copy since Car is immutable (no setters)
            Car carToUpdate = new Car.Builder()
                    .copy(existingCar)
                    .setCarMake(updatedCar.getCarMake())
                    .setCarModel(updatedCar.getCarModel())
                    .setCarYear(updatedCar.getCarYear())
                    .setCarMileage(updatedCar.getCarMileage())
                    .setCarStatus(updatedCar.getCarStatus())
                    .setMedia(updatedCar.getMedia())
                    .setAuctionEndTime(updatedCar.getAuctionEndTime())
                    .build();

            Car savedCar = carService.saveCar(carToUpdate);
            return ResponseEntity.ok(savedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete car
    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> deleteCar(@PathVariable("vin") String vin) {
        carService.deleteCar(vin);
        return ResponseEntity.noContent().build();
    }

    // Get all cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}
