package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Bid;
import za.co.revvedAuctions.repository.BidRepository;

import java.util.List;

@Service
public class BidService implements IBidService {

    private final BidRepository repository;

    @Autowired
    public BidService(BidRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bid create(Bid bid) {
        return repository.save(bid);
    }

    @Override
    public Bid read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Bid update(Bid bid) {
        return repository.save(bid);
    }

    @Override
    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Bid> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Bid> getByAuctionSessionId(String auctionSessionId) {
        return repository.findByAuctionSessionId(auctionSessionId);
    }

}
