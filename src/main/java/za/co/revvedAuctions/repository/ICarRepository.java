package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Car;

import java.util.List;

public interface ICarRepository extends IRepository<Car,String>{



    List<Car> getAll();

}