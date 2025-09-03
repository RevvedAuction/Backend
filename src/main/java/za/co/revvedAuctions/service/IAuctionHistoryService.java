package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.AuctionHistory;
import java.util.List;

public interface IAuctionHistoryService extends IService<AuctionHistory, Integer> {

    List<AuctionHistory> getAll();


}
