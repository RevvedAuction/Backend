//package za.co.revvedAuctions.service.implementation;
//
//import za.co.revvedAuctions.domain.Seller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.co.revvedAuctions.repository.SellerRepository;
//import za.co.revvedAuctions.service.ISellerService;
//
//import java.util.List;
//
//@Service
//public class SellerService implements ISellerService {
//
//    private SellerRepository repository;
//    @Autowired
//    public SellerService(SellerRepository repository){
//        this.repository = repository;
//    }
//
//    @Override
//    public Seller create (Seller seller) {
//        return this.repository.save(seller);}
//
//    @Override
//    public Seller read(String string) {
//        return this.repository.findById(string).orElse(null);
//    }
//
//    @Override
//    public Seller update(Seller seller) {
//        return this.repository.save(seller);
//    }
//
//    @Override
//    public List<Seller> getAll() {
//        return this.repository.findAll();
//    }
//}
