package com.skilldistillery.fitnesstracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;
import com.skilldistillery.fitnesstracker.repositories.FitnessRepository;

@Service
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
	public FitnessTracker create(FitnessTracker newFit) {
		if(newFit != null) {
			return fitRepo.saveAndFlush(newFit);
		}
		return null;
	}

	@Override
	public FitnessTracker update(int fitId, FitnessTracker editFit) {
		FitnessTracker existing = fitRepo.searchById(fitId);
		if(existing != null) {
			existing.setDate(editFit.getDate());
			existing.setActivity(editFit.getActivity());
			existing.setLocation(editFit.getLocation());
			existing.setDuration(editFit.getDuration());
			existing.setNotes(editFit.getNotes());
		}
		return null;
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
