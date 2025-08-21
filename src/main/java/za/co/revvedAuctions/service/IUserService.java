package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.repository.IRepository;

import java.util.List;

public interface IUserService extends IRepository<User, Integer> {
    List<User> getAll();
}
