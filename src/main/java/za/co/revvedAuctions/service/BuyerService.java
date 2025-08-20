package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Buyer;
import za.co.revvedAuctions.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuyerService implements IBuyerService {

    private static BuyerService service;

    @Autowired
    private BuyerRepository repository;

    public static IBuyerService getService() {
        if (service == null) {
            service = new BuyerService();
        }
        return service;
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
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }

    @Override
    public List<Buyer> getAll() {
        return this.repository.findAll();
    }
}