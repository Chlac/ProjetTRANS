package beans;

public class Evenement {
	private String date;
	private String theme;
	private String nom_organisation;
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getNome_organisation() {
		return nom_organisation;
	}
	public void setNom_organisation(String name_organisation) {
		this.nom_organisation = name_organisation;
	}
}
