package org.wcci.citiesandstates;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id
	@GeneratedValue
	private long id;
	private String abbreviation;
	private String name;
	private String motto;
	private String fish;
	private String citiesUrl;

	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((State) obj).id;
	}

	public State(String abbreviation, String name, String motto, String fish, String citiesUrl) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.motto = motto;
		this.fish = fish;
		this.citiesUrl = citiesUrl;

	}

	@SuppressWarnings("unused")
	private State() {
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public String getFish() {
		return fish;
	}

	public String getCitiesUrl() {
		return citiesUrl;
	}

	public long getId() {

		return id;
	}

	public Collection<City> getCities() {

		return cities;
	}

}
