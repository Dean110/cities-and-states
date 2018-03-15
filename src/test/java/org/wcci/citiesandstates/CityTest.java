package org.wcci.citiesandstates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CityTest {

	private static final int POPULATION = 860090;
	private static final String NAME = "Columbus";

	@Test
	public void cityShouldHaveNameStateAndPopulation() {
		State dummyState = new State(null, null, null, null, null);
		City underTest = new City(NAME, dummyState, POPULATION);

		assertThat(underTest.getName(), is(NAME));
		assertThat(underTest.getState(), is(dummyState));
		assertThat(underTest.getPopulation(), is(POPULATION));
	}

}
