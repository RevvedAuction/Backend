package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.AuctionSession;
import java.util.List;

public interface IAuctionSessionService extends IService <AuctionSession, String> {

    List<AuctionSession> getAll();
}
