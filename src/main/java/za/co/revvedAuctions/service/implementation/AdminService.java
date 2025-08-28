package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.repository.AdminRepository;
import za.co.revvedAuctions.service.IAdminService;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private AdminRepository repository;

    public AdminService(AdminRepository repository){
        this.repository = repository;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin read(Long aLong) {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Admin delete(long id) {
        Admin toDelete = read(id);
        repository.delete(toDelete);
        return toDelete;
    }

    @Override
    public List<Admin> getAll() {
        return this.repository.findAll();
    }
}