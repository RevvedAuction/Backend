package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Individual;

import java.util.ArrayList;
import java.util.List;

public class IndividualRepository implements IIndividualRepository{

    private static IIndividualRepository repository = null;
    private List<Individual> individualList;

    public IndividualRepository(){
        individualList = new ArrayList<Individual>();
    }

    public static IRepository getRepository(){
        if(repository == null){
            repository = new IndividualRepository();

        }
        return repository;
    }


    @Override
    public Individual create(Individual individual) {
      boolean success = individualList.add(individual);
      if(success){
          return individual;
      }
      return null;
    }


    @Override
    public Individual read(Integer individualId) {
        for (Individual individual : individualList) {
            if (individual.getIndividualId() == individualId) {
                return individual;
            }
        }
        return null;
    }

    @Override
    public Individual update(Individual individual) {
       Integer individualId = individual.getIndividualId();
       Individual updatedIndividual = read(individualId);
       if(updatedIndividual == null)
        return null;

       boolean success = delete(individualId);
        if(success){
            if(individualList.add(individual))
                return individual;
        }
        return null;

}
    @Override
    public boolean delete(Integer integer) {
        Individual deletedIndividual = read(integer);
        if (deletedIndividual == null)
            return false;
        return (individualList.remove(deletedIndividual));
    }

    @Override
    public List<Individual> getAll() {
        return individualList;
    }

}
