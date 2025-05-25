package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.repository.SellerRepository;

import java.util.List;

@Service
public class SellerService implements ISellerService{

    private static SellerService service;

    @Autowired
    private SellerRepository repository;

    public static ISellerService getService() {
        if (service == null) {
            service = new SellerService();
        }
        return service;
    }

    @Override
    public Seller create (Seller seller) {
        return this.repository.save(seller);}

    @Override
    public Seller read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public Seller update(Seller seller) {
        return this.repository.save(seller);
    }

    @Override
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }

    @Override
    public List<Seller> getAll() {
        return this.repository.findAll();
    }
}
