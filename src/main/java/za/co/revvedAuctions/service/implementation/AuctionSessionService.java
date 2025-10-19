package za.co.revvedAuctions.service.implementation;

import za.co.revvedAuctions.domain.AuctionSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.repository.AuctionSessionRepository;
import za.co.revvedAuctions.service.IAuctionSessionService;

import java.util.List;

@Service
public class AuctionSessionService implements IAuctionSessionService {

    private AuctionSessionRepository repository;

    @Autowired
    public AuctionSessionService(AuctionSessionRepository repository){
        this.repository = repository;
    }

    @Override
    public AuctionSession create(AuctionSession auctionSession) {
        return repository.save(auctionSession);
    }

    @Override
    public AuctionSession read(String string) {
        return repository.findById(string).orElseThrow();
    }

    @Override
    public AuctionSession update(AuctionSession auctionSession) {
        return repository.save(auctionSession);
    }

    @Override
    public AuctionSession delete(String string) {
        repository.deleteById(string);
        return null;
    }

    @Override
    public List<AuctionSession> getAll() {
        return this.repository.findAll();
    }
}
