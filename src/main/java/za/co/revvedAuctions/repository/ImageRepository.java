package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.revvedAuctions.domain.Car;

import java.awt.*;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Car,String> {

    Optional<Car> findByCarVIN(String carVIN);

}
