package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.CarAdmin;
import za.co.revvedAuctions.repository.CarAdminRepository;
import za.co.revvedAuctions.service.ICarAdminService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarAdminService implements ICarAdminService {

    private final CarAdminRepository repository;

    @Autowired
    public CarAdminService(CarAdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarAdmin create(CarAdmin carAdmin) {
        return repository.save(carAdmin);
    }

    @Override
    public Optional<CarAdmin> read(UUID carId) {
        return repository.findById(carId);
    }

    @Override
    public CarAdmin update(CarAdmin carAdmin) {
        if (repository.existsById(carAdmin.getCarId())) {
            return repository.save(carAdmin);
        }
        return null;
    }

    @Override
    public boolean delete(UUID carId) {
        if (repository.existsById(carId)) {
            repository.deleteById(carId);
            return true;
        }
        return false;
    }

    @Override
    public List<CarAdmin> getAll() {
        return repository.findAll();
    }
}