package za.co.revvedAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.revvedAuctions.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmailAndUserPassword(String email, String password);
    public boolean existsByUserEmail(String email);



}


