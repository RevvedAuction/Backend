package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Car;
import za.co.revvedAuctions.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static IUserRepository repository = null;

    public List<User> userList;

    private UserRepository() {
        userList = new ArrayList<User>();

    }

    public static IUserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }


    @Override
    public User create(User user) {
        boolean success = userList.add(user);
        if (success) {
            return user;
        }
        return null;
    }

    @Override
    public User read(String UserId) {
        for (User user : userList) {
            if (user.getUserID().equals(UserId)) ;
            return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        String UserId = user.getUserID();
        User oldUser = read(UserId);
        if (oldUser != null) {

            return null;
        }
        boolean success = userList.remove(user);
        if (success) {
            if (userList.add(user))
                return user;
        }
        return null;
    }

    @Override
    public boolean delete(String UserId) {
        User deleteUser = read(UserId);
        if (deleteUser == null)
    return false;
            return userList.remove(deleteUser);
}

    @Override
    public List<User> getAll() {
        return userList;
    }
}


