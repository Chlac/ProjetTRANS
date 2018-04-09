package beans;

import java.util.ArrayList;

public class City {
	
	private String name;
	private String region;
	private String departement;
	private Double latitude;
	private Double longitude;
	private int population2014;
	
	private Culture culture;
	private Economie economie;
	private Population population;
	private ServicePublique servicePublique;
	
	public Culture getCulture() {
		return culture;
	}

	public void setCulture(Culture culture) {
		this.culture = culture;
	}

	public Economie getEconomie() {
		return economie;
	}

	public void setEconomie(Economie economie) {
		this.economie = economie;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public ServicePublique getServicePublique() {
		return servicePublique;
	}

	public void setServicePublique(ServicePublique servicePublique) {
		this.servicePublique = servicePublique;
	}
	
	
	public City() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getPopulation2014() {
		return population2014;
	}

	public void setPopulation2014(int population2014) {
		this.population2014 = population2014;
	}
	
	
}
