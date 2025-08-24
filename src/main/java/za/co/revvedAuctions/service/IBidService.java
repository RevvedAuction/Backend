package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Bid;

import java.util.List;

public interface IBidService extends IService <Bid, Integer>{

    List<Bid> getAll();
    List<Bid> getByAuctionSessionId(String auctionSessionId);
}
