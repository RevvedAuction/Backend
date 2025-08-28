package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Car;

import java.awt.*;
import java.util.Optional;
@Repository
public interface ImageRepository extends JpaRepository<Car,String> {

    Optional<Car> findByCarVIN(String carVIN);

}
