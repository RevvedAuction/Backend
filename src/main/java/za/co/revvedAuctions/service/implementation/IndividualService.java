package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.Individual;
import za.co.revvedAuctions.repository.IndividualRepository;
import za.co.revvedAuctions.service.IIndividualService;

import java.util.List;

@Service
public class IndividualService implements IIndividualService {

    private final IndividualRepository repository;
    @Autowired
    public IndividualService(IndividualRepository repository) {
        this.repository = repository;
    }

    @Override
    public Individual create(Individual individual) {
        return this.repository.save(individual);
    }

    @Override
    public Individual read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Individual update(Individual individual) {
        return this.repository.save(individual);
    }

    @Override
    public List<Individual> getAll() {
        return this.repository.findAll();
    }
}
