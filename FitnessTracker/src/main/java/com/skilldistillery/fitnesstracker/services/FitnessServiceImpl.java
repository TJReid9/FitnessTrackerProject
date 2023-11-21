package com.skilldistillery.fitnesstracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;
import com.skilldistillery.fitnesstracker.repositories.FitnessRepository;

public class FitnessServiceImpl implements FitnessService {
	
	@Autowired
	private FitnessRepository fitRepo;

	@Override
	public List<FitnessTracker> getAllFitness() {
		return fitRepo.findAll();
	}

	@Override
	public FitnessTracker retrieveFitness(int fitId) {
		return fitRepo.searchById(fitId);
	}

	@Override
	public FitnessTracker create(FitnessTracker newFitness) {
		if(newFitness != null) {
			return fitRepo.saveAndFlush(newFitness);
		}
		return null;
	}

	@Override
	public FitnessTracker update(int fitId, FitnessTracker updatingFitness) {
		FitnessTracker existing = fitRepo.searchById(fitId);
		if(existing != null) {
			existing.setDate(updatingFitness.getDate());
			existing.setActivity(updatingFitness.getActivity());
			existing.setLocation(updatingFitness.getLocation());
			existing.setDuration(updatingFitness.getDuration());
			existing.setNotes(updatingFitness.getNotes());
			existing.setCreateDate(updatingFitness.getCreateDate());
			existing.setLastUpdate(updatingFitness.getLastUpdate());
			
		}
		return fitRepo.saveAndFlush(existing);
	}

	@Override
	public boolean delete(int fitId) {
		boolean deleted = false;
		if(fitRepo.existsById(fitId)) {
			fitRepo.deleteById(fitId);
			deleted = true;
		}
		return deleted;
	}

}
