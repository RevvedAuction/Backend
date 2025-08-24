package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.AuctionHistory;
import za.co.revvedAuctions.repository.AuctionHistoryRepository;

import java.util.List;

@Service
public class AuctionHistoryService implements IAuctionHistoryService {

    @Autowired
    private AuctionHistoryRepository repository;

    @Override
    public AuctionHistory create(AuctionHistory auctionHistory) {
        return repository.save(auctionHistory);
    }

    @Override
    public AuctionHistory read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AuctionHistory update(AuctionHistory auctionHistory) {
        return repository.save(auctionHistory);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<AuctionHistory> getAll() {
        return repository.findAll();
    }

    @Override
    public List<AuctionHistory> getByAuctionSessionId(String auctionSessionId) {
        return repository.findByAuctionSessionId(auctionSessionId);
    }
}
