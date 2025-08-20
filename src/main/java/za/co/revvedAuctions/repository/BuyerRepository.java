package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {
}
