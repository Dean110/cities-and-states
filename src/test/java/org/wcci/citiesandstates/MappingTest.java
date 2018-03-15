package org.wcci.citiesandstates;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MappingTest {

	@Resource
	private StateRepository stateRepo;
	@Resource
	private EntityManager entityManager;
	@Resource
	private CityRepository cityRepo;

	State testState = new State("TS", "Test State", "A Test Motto", "Test Fish", "/cities_url");

	@Test
	public void shouldSaveAndLoadAStateToARepo() {

		stateRepo.save(testState);
		long stateId = testState.getId();
		entityManager.flush();
		entityManager.clear();
		testState = stateRepo.findOne(stateId);

		assertThat(testState.getName(), is("Test State"));

	}

	@Test
	public void shouldSaveAndLoadACityToTheCityRepo() {
		stateRepo.save(testState);
		City testCity1 = new City("Test Town", testState, 101);

		cityRepo.save(testCity1);
		long cityId = testCity1.getId();
		entityManager.flush();
		entityManager.clear();
		testCity1 = cityRepo.findOne(cityId);

		assertThat(testCity1.getName(), is("Test Town"));

	}

	@Test
	public void oneStateShouldHaveTwoCities() {
		// State testState = new State("TS", "Test State", "A Test Motto", "Test Fish",
		// "/cities_url");
		stateRepo.save(testState);
		// long testStateId = testState.getId();
		City testCity1 = new City("Test Town", testState, 101);
		cityRepo.save(testCity1);
		long testCity1Id = testCity1.getId();
		City testCity2 = new City("Mock Metropolis", testState, 10001);
		cityRepo.save(testCity2);
		long testCity2Id = testCity2.getId();
		City testCity3 = new City("Vapid Village", testState, 11);
		cityRepo.save(testCity3);
		long testCity3Id = testCity3.getId();

		entityManager.flush();
		entityManager.clear();

		assertThat(cityRepo.findOne(testCity1Id), is(testCity1));
		assertThat(cityRepo.findOne(testCity2Id), is(testCity2));
		assertThat(cityRepo.findOne(testCity3Id), is(testCity3));
		assertThat(cityRepo.findAll(), containsInAnyOrder(testCity1, testCity2, testCity3));

	}
}
