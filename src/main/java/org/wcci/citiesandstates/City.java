package org.wcci.citiesandstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int population;

	@ManyToOne
	private State state;

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public City(String name, State state, int population) {
		this.name = name;
		this.state = state;
		this.population = population;

	}

	@SuppressWarnings("unused")
	private City() {
	}

	public long getId() {

		return id;
	}

	public Object getState() {

		return state;
	}

	@Override
	public String toString() {
		return "" + name + ", " + state.getName();
	}

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

		return id == ((City) obj).id;
	}
}
