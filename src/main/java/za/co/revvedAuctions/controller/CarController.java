package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.service.implementation.CarService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:8081")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // DTO to send Car with Base64 image
    public static class CarDTO {
        public String carVIN;
        public String carMake;
        public String carModel;
        public int carYear;
        public int carMileage;
        public String carStatus;
        public String mediaBase64;
        public LocalDateTime auctionEndTime;
    }

    private CarDTO mapToDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.carVIN = car.getCarVIN();
        dto.carMake = car.getCarMake();
        dto.carModel = car.getCarModel();
        dto.carYear = car.getCarYear();
        dto.carMileage = car.getCarMileage();
        dto.carStatus = car.getCarStatus();
        dto.auctionEndTime = car.getAuctionEndTime();
        if (car.getMedia() != null) {
            dto.mediaBase64 = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(car.getMedia());
        }
        return dto;
    }

    @PostMapping("/add")
    public ResponseEntity<CarDTO> createCar(
            @RequestParam("carVIN") String carVIN,
            @RequestParam("carMake") String carMake,
            @RequestParam("carModel") String carModel,
            @RequestParam("carYear") int carYear,
            @RequestParam("carMileage") int carMileage,
            @RequestParam("carStatus") String carStatus,
            @RequestParam("auctionEndTime") String auctionEndTime,
            @RequestParam(value = "media", required = false) MultipartFile mediaFile
    ) throws IOException {

        byte[] mediaBytes = null;
        if (mediaFile != null && !mediaFile.isEmpty()) {
            mediaBytes = mediaFile.getBytes();
        }

        Car car = new Car.Builder()
                .setCarVIN(carVIN)
                .setCarMake(carMake)
                .setCarModel(carModel)
                .setCarYear(carYear)
                .setCarMileage(carMileage)
                .setCarStatus(carStatus)
                .setAuctionEndTime(LocalDateTime.parse(auctionEndTime))
                .setMediaBase64(mediaBytes)
                .build();

        Car savedCar = carService.saveCar(car);
        return new ResponseEntity<>(mapToDTO(savedCar), HttpStatus.CREATED);
    }

    @GetMapping("/{vin}")
    public ResponseEntity<CarDTO> getCarByVIN(@PathVariable("vin") String vin) {
        Car car = carService.getCarByVIN(vin);
        if (car != null) {
            return ResponseEntity.ok(mapToDTO(car));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{vin}")
    public ResponseEntity<CarDTO> updateCar(
            @PathVariable("vin") String vin,
            @RequestBody Car updatedCar) {

        Car existingCar = carService.getCarByVIN(vin);
        if (existingCar == null) {
            return ResponseEntity.notFound().build();
        }
        byte[] mediaBytes;

        if (updatedCar.getMediaBase64() != null && updatedCar.getMediaBase64().startsWith("data:image")) {
            String base64Data = updatedCar.getMediaBase64().substring(updatedCar.getMediaBase64().indexOf(",") + 1);
            mediaBytes = java.util.Base64.getDecoder().decode(base64Data);
        } else if (existingCar.getMediaBase64() != null) {
            String existingBase64 = existingCar.getMediaBase64();
            if (existingBase64.startsWith("data:image")) {
                existingBase64 = existingBase64.substring(existingBase64.indexOf(",") + 1);
            }
            mediaBytes = java.util.Base64.getDecoder().decode(existingBase64);
        } else {
            mediaBytes = null; // no image
        }

        Car carToUpdate = new Car.Builder()
                .copy(existingCar)
                .setCarMake(updatedCar.getCarMake())
                .setCarModel(updatedCar.getCarModel())
                .setCarYear(updatedCar.getCarYear())
                .setCarMileage(updatedCar.getCarMileage())
                .setCarStatus(updatedCar.getCarStatus())
                .setAuctionEndTime(updatedCar.getAuctionEndTime())
                .setMediaBase64(mediaBytes) // store as bytes
                .build();

        Car savedCar = carService.saveCar(carToUpdate);
        return ResponseEntity.ok(mapToDTO(savedCar));
    }

    @DeleteMapping("/delete/{vin}")
    public ResponseEntity<?> deleteCar(@PathVariable("vin") String vin) {
        Car car = carService.getCarByVIN(vin);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        carService.deleteCar(vin);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> carDTOs = carService.getAllCars()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(carDTOs);
    }
}
