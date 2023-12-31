package com.skilldistillery.fitnesstracker.services;

import java.util.List;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;

public interface FitnessService {
	
	List<FitnessTracker> getAllFitness();
	FitnessTracker retrieveFitness(int fitId);
	FitnessTracker create(FitnessTracker newFit);
	FitnessTracker update(int fitId, FitnessTracker editFit);
	boolean delete(int fitId);

}
