package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.repository.AdminRepository;
import za.co.revvedAuctions.service.IAdminService;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService implements IAdminService {

    private AdminRepository repository;
    @Autowired
    public AdminService(AdminRepository repository){
        this.repository = repository;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin read(UUID adminId) {
        return repository.findById(adminId).orElseThrow();
    }

    @Override
    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    public Admin findAdmin(int adminNumber) {
        return repository.findAdminByAdminNumber(adminNumber);
    }

    @Override
    public Admin delete(int adminNumber) {
        Admin toDelete = findAdmin(adminNumber);
        repository.delete(toDelete);
        return toDelete;
    }

    @Override
    public List<Admin> getAll() {
        return this.repository.findAll();
    }
}