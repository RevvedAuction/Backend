package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.repository.UserRepository;
import za.co.revvedAuctions.service.IUserService;

import java.util.List;
@Service
public class UserService implements IUserService {

    private UserRepository repository ;

    @Autowired
    private UserService(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(String userId) {
        return repository.findById(userId).orElseThrow();
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }
}
