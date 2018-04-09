package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Culture {
	private double score;
	private HashMap<String,Object> details;
	public HashMap<String,Object> getDetails() {
		return details;
	}

	public void setDetails(HashMap<String, Object> details) {
		this.details = details;
	}
	

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
