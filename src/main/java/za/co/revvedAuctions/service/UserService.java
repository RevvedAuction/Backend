package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.repository.IUserRepository;
import za.co.revvedAuctions.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {

    private IUserService userService;
    private  IUserRepository repository ;

    private UserService(){
        repository =  UserRepository.getRepository();

    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User read(Integer integer) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
    @Override
    public List<User> getAll() {
        return List.of();
    }

}
