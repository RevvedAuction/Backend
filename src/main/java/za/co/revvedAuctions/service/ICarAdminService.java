package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.CarAdmin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICarAdminService {

    CarAdmin create(CarAdmin carAdmin);

    Optional<CarAdmin> read(UUID carId);

    CarAdmin update(CarAdmin carAdmin);

    boolean delete(UUID carId);

    List<CarAdmin> getAll();
}
