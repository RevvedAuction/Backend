package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.repository.AdminRepository;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private static AdminService service;

    @Autowired
    private AdminRepository repository;

    public static IAdminService getService() {
        if (service == null) {
            service = new AdminService();
        }
        return service;
    }

    @Override
    public Admin create(Admin admin) {
        return this.repository.save(admin);
    }

    @Override
    public Admin read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        return this.repository.save(admin);
    }

    @Override
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }

    @Override
    public List<Admin> getAll() {
        return this.repository.findAll();
    }
}