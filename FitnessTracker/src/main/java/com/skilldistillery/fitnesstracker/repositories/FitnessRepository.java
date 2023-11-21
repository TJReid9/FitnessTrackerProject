package com.skilldistillery.fitnesstracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;

public interface FitnessRepository extends JpaRepository<FitnessTracker, Integer> {
	FitnessTracker searchById(int fitId);
	boolean existsById(int fitId);

}
