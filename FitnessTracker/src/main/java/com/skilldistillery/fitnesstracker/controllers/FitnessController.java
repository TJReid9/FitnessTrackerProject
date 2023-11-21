package com.skilldistillery.fitnesstracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;
import com.skilldistillery.fitnesstracker.services.FitnessService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class FitnessController {
	
	@Autowired
	private FitnessService fitService;
	
	@GetMapping("fitness")
	public List<FitnessTracker> getAllFitness(HttpServletResponse resp) {
		return fitService.getAllFitness();
	}
	
	@GetMapping("jams/{jamId}")
	public FitnessTracker retrieveFitness(@PathVariable int fitId, HttpServletResponse resp) {
		FitnessTracker fitness = fitService.retrieveFitness(fitId);
		if (fitness == null ) {
			resp.setStatus(404);			
		}
		return fitness;
	}
	
	@PostMapping("fitness")
	public FitnessTracker create(@RequestBody FitnessTracker newFitness, HttpServletResponse res, HttpServletRequest req) {
		FitnessTracker createdFitness = null;
		try {
			createdFitness = fitService.create(newFitness);
			res.setStatus(201);
			res.setHeader("Location", "http://localhost:8085/api/fitness" + createdFitness.getId());
			StringBuffer url = req.getRequestURL();
			url.append("/").append(createdFitness.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return createdFitness;
	}
	
	@PutMapping("fitness/{fitId}")
	public FitnessTracker update(@PathVariable Integer fitId, @RequestBody FitnessTracker updatingFitness, HttpServletResponse res) {
		FitnessTracker updatedFitness = null;
		try {
			updatedFitness = fitService.update(fitId, updatingFitness);
			if (updatedFitness == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
			e.printStackTrace();
		}
		return updatedFitness;
	}
	
	@DeleteMapping("fitness/{fitId}")
	public void delete(@PathVariable Integer fitId, HttpServletResponse res) {
		try {
			fitService.delete(fitId);
				res.setStatus(204);
				if(fitId == null) {
					res.setStatus(404);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
	}

}
