package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository{

    private static ICarRepository repository = null;

    public List<Car> carList;

    private CarRepository(){
        carList = new ArrayList<Car>();
    }
public static ICarRepository getRepository(){
        if(repository == null){
            repository = new CarRepository();
        }
    return repository;
}
    @Override
    public Car create(Car car) {
        boolean success = carList.add(car);
        if(success){
            return car;
        }
        return null;
    }

    @Override
    public Car read(String carVIN) {
        for (Car car : carList) {
            if (car.getCarVIN().equals(carVIN))
                return car;
        }
        return null;
    }

    @Override
    public Car update(Car car) {
       String carVIN = car.getCarVIN();
       Car carRead = read(carVIN);
       if(carRead == null) {
           return null;
       }
           boolean success = delete(carVIN);
           if (success) {
               if(carList.add(car))
               return car;
           }
           return null;
       }


    @Override
    public boolean delete(String carVIN) {
    Car carToDelete = read(carVIN);
    if (carToDelete == null)
        return false;
    return (carList.remove(carToDelete));
    }
    @Override
    public List<Car> getAll() {
        return carList;
    }
}
