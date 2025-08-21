package za.co.revvedAuctions.repository;

import za.co.revvedAuctions.domain.Individual;

import java.util.List;

public interface IIndividualRepository extends IRepository<Individual, Integer> {
    List<Individual> getAll();
}

