package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Buyer;
import java.util.List;

public interface IBuyerService extends IService <Buyer, String> {

    List<Buyer> getAll();
}
