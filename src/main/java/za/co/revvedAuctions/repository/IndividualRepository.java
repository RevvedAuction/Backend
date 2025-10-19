package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.domain.Individual;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface IndividualRepository extends JpaRepository<Individual, String> {
}
