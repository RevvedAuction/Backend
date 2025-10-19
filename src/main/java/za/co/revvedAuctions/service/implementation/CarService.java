package za.co.revvedAuctions.service.implementation;

import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarByVIN(String vin) {
        return carRepository.findById(vin).orElse(null);
    }

    public void deleteCar(String vin) {
        carRepository.deleteById(vin);
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}

