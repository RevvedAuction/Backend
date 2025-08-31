package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.User;

import java.util.List;

public interface IUserService extends IService<User, Long> {

    List<User> getAll();
}
