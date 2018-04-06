package beans;

public class Animation {
	private Evenement[] evenements = new Evenement[5];
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public Evenement[] getEvenements() {
		return evenements;
	}

	public void setEvenements(Evenement[] evenements) {
		this.evenements = evenements;
	}
}
