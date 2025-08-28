package za.co.revvedAuctions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Individual;
import za.co.revvedAuctions.repository.IIndividualRepository;

import java.util.List;

@Service
public class IndividualService implements iIndividualService{

    private static IndividualService service;

    @Autowired
    private IIndividualRepository repository;

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
    public Individual read(Integer integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Individual update(Individual individual) {
        return this.repository.save(individual);
    }

    @Override
    public boolean delete(Integer integer) {
        this.repository.deleteById(integer);
        return true;
    }
    @Override
    public List<Individual> getAll() {
        return this.repository.findAll();
    }
}
