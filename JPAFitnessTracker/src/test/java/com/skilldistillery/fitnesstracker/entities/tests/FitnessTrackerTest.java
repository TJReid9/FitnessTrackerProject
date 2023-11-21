package com.skilldistillery.fitnesstracker.entities.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.fitnesstracker.entities.FitnessTracker;

class FitnessTrackerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private FitnessTracker ft;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFitnessTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		ft = em.find(FitnessTracker.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ft = null;
	}

	@Test
	void test() {
		assertNotNull(ft);
		assertEquals("Workout", ft.getActivity());
	}
	
	@Test
	void test_retrieveFitnessTracker() {
		assertNotNull(ft);
		assertEquals("Colorado Athletic Club", ft.getLocation());
		assertTrue(ft.getId() > 0);
	}

}
