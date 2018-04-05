package beans;

public class Chomage {
	private double taux_chomage;
	
	public Chomage() {
		
	}
	
	public Chomage(double taux_chomage) {
		super();
		this.taux_chomage = taux_chomage;
	}

	public double getTaux_chomage() {
		return taux_chomage;
	}

	public void setTaux_chomage(double taux_chomage) {
		this.taux_chomage = taux_chomage;
	} 
}
