package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Individual;
import za.co.revvedAuctions.repository.IndividualRepository;

import java.util.List;

@Service
public class IndividualService implements iIndividualService{

    private static IndividualService service;

    @Autowired
    private IndividualRepository repository;

    public static iIndividualService getService() {
        if (service == null) {
            service = new IndividualService();
        }
        return service;
    }

    @Override
    public Individual create(Individual individual) {
        return this.repository.save(individual);
    }

    @Override
    public Individual read(String string) {
        return this.repository.findById(string).orElse(null);
    }

    @Override
    public Individual update(Individual individual) {
        return this.repository.save(individual);
    }

    @Override
    public boolean delete(String string) {
        this.repository.deleteById(string);
        return true;
    }
    @Override
    public List<Individual> getAll() {
        return this.repository.findAll();
    }
}
