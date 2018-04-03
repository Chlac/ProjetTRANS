package request;

public class Criteria {
	// Static ----------------------------------------------------------------------------------------------------------
	
	public final static Criteria culture = new Criteria("animation","animation");
	public final static Criteria economie = new Criteria("chomage", "chomage");
	public final static Criteria tourisme = new Criteria("tourisme", "tourisme");
	public final static Criteria industrie = new Criteria("industrie", "industrie");
	public final static Criteria agriculture = new Criteria("agriculture", "agriculture");
	public final static Criteria commerce = new Criteria("commerce", "commerce");
	public final static Criteria senior = new Criteria("senior", "senior");
	public final static Criteria jeunes  = new Criteria("jeunes", "jeunes");
	public final static Criteria santee  = new Criteria("santee", "santee");
	public final static Criteria ville2000 = new Criteria("ville2000", "ville2000");
	public final static Criteria ville2000_50000  = new Criteria("ville2000_50000", "ville2000_50000");
	public final static Criteria ville50000_200000  = new Criteria("ville50000_200000", "ville50000_200000");
	public final static Criteria ville200000  = new Criteria("ville200000", "ville200000");
	
	
	
	
	public final static Criteria[] as = {culture, economie, tourisme, industrie, agriculture, commerce, senior,
			jeunes, santee, ville2000, ville2000_50000, ville50000_200000, ville200000};
	// Dynamic ---------------------------------------------------------------------------------------------------------
	
	public final String ATTRIBUT_NAME;
	public final String TABLE_NAME;
	
	public Criteria(String attribut_name, String name){
		ATTRIBUT_NAME = attribut_name;
		TABLE_NAME = name;
	}
	
}
