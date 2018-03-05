package request;

public class Criteria {
	// Static ----------------------------------------------------------------------------------------------------------
	
	public final static Criteria CULTURE = new Criteria("culture1","culture");
	public final static Criteria Economie = new Criteria("economie1", "chomage");
	
	public final static Criteria[] as = {CULTURE, Economie};
	// Dynamic ---------------------------------------------------------------------------------------------------------
	
	public final String ATTRIBUT_NAME;
	public final String TABLE_NAME;
	
	public Criteria(String attribut_name, String name){
		ATTRIBUT_NAME = attribut_name;
		TABLE_NAME = name;
	}
	
}
