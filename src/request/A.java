package request;

public class A {
	// Static ----------------------------------------------------------------------------------------------------------
	
	public final static A CULTURE = new A("table");
	
	// Dynamic ---------------------------------------------------------------------------------------------------------
	
	
	public final String TABLE_NAME;
	
	public A(String name){
		TABLE_NAME = name;
	}
}
