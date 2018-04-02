package beans;

public class City {
	
	private String name;
	private String region;
	private String departement;
	private String distance_to;
	
	
	public City(String name) {
		this.name = name;
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
	public String getDistance_to() {
		return distance_to;
	}
	public void setDistance_to(String distance_to) {
		this.distance_to = distance_to;
	}
	
	
	

}
