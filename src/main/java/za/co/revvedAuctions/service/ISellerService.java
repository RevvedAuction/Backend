package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Seller;
import java.util.List;

public interface ISellerService extends IService <Seller, String> {

    List<Seller> getAll();
}
