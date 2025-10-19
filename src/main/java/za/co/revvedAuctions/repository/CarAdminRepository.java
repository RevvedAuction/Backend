package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.CarAdmin;

import java.util.UUID;

@Repository
public interface CarAdminRepository extends JpaRepository<CarAdmin, UUID> {

    // ✅ Example of a custom query method (optional)
    CarAdmin findByMakeAndModel(String make, String model);
}
