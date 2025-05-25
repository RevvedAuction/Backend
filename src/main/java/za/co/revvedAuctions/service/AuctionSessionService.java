package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.AuctionSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.repository.AuctionSessionRepository;

import java.util.List;

@Service
public class AuctionSessionService implements IAuctionSessionService {

    private static AuctionSessionService service;

    @Autowired
    private AuctionSessionRepository repository;

    public static IAuctionSessionService getService() {
        if (service == null) {
            service = new AuctionSessionService();
        }
        return service;
    }

    @Override
    public AuctionSession create (AuctionSession auctionSession){
        return this.repository.save(auctionSession);}

    @Override
    public AuctionSession read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public AuctionSession update(AuctionSession auctionSession) {
        return this.repository.save(auctionSession);
    }

    @Override
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }

    @Override
    public List<AuctionSession> getAll() {
        return this.repository.findAll();
    }
}
