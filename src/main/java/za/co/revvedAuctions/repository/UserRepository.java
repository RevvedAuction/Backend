package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}


