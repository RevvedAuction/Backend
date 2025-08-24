package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.revvedAuctions.domain.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    List<Car> findByAuctionEndTimeAfter(LocalDateTime now);
}

import za.co.revvedAuctions.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

}
