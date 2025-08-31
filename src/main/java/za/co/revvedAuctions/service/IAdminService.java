package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Admin;
import java.util.List;
import java.util.UUID;

public interface IAdminService extends IService<Admin, UUID> {
    Admin delete (int adminNumber);
    List<Admin> getAll();
}