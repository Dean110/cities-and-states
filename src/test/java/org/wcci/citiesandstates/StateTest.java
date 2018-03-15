package org.wcci.citiesandstates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StateTest {
	private static final String CITIES_URL = "/states/oh/cities";
	private static final String FISH = "Carp";
	private static final String MOTTO = "Birthplace of Aviation";
	private static final String NAME = "Ohio";
	private static final String ABBREVIATION = "OH";

	@Test
	public void statesShouldHaveAnAbbreviationNameMottoFishCitiesUrl() {
		State underTest = new State(ABBREVIATION, NAME, MOTTO, FISH, CITIES_URL);
		assertThat(underTest.getAbbreviation(), is(ABBREVIATION));
		assertThat(underTest.getName(), is(NAME));
		assertThat(underTest.getMotto(), is(MOTTO));
		assertThat(underTest.getFish(), is(FISH));
		assertThat(underTest.getCitiesUrl(), is(CITIES_URL));

	}

}