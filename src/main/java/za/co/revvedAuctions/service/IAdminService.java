package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Admin;
import java.util.List;

public interface IAdminService extends IService<Admin, Long> {
    Admin delete (long id);
    List<Admin> getAll();
}