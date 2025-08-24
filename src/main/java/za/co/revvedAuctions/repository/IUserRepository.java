package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.User;

import java.util.List;

public interface IUserRepository extends IRepository<User,String>
{
    List<User> getAll();
}
