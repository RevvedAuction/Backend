package za.co.revvedAuctions.service.implementation;

import za.co.revvedAuctions.domain.Buyer;
import za.co.revvedAuctions.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.service.IBuyerService;

import java.util.List;

@Service
public class BuyerService implements IBuyerService {

    private BuyerRepository repository;

    @Autowired
    public BuyerService(BuyerRepository repository){
        this.repository = repository;
    }

    @Override
    public Buyer create(Buyer buyer) {
        return this.repository.save(buyer);
    }

    @Override
    public Buyer read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public Buyer update(Buyer buyer) {
        return this.repository.save(buyer);
    }


    @Override
    public List<Buyer> getAll() {
        return this.repository.findAll();
    }
}