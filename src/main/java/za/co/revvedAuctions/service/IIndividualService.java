package za.co.revvedAuctions.service;

import za.co.revvedAuctions.domain.Individual;

import java.util.List;

public interface IIndividualService extends IService <Individual, Integer>{
    List<Individual> getAll();
}
