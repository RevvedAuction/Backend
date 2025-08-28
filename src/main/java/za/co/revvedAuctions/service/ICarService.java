package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Car;

import java.util.List;

public interface ICarService extends IService<Car, String> {

    List<Car> getAll();
}