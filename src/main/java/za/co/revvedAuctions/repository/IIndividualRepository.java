package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.revvedAuctions.domain.Individual;

import java.util.List;

public interface IIndividualRepository extends JpaRepository<Individual, Integer> {
    List<Individual> findByIndividualId(String auctionSessionId);
}

