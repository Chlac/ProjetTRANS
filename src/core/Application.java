package core;

import java.util.ArrayList;

import request.A;


/**
 * This is the root of the database and logic side.
 *	Only one instance of this class can be created at a time
 */
public class Application {

	// Static ----------------------------------------------------------------------------------------------------------
	
	/**
	 * This is the only instance of Application #singleton
	 */
	private static Application instance;
	
	/**
	 * 
	 */
	public static Object monitor = new Object();
	
	/**
	 * Creates an instance of Application the first time it is called.
	 * calling this instance more than once is useless.
	 * This methods is called at the server startup
	 */
	public static void init() {
		if (instance == null) instance = new Application();
	}
	
	/**
	 * Gets called by a servlet to pass the {@link RequestedCriterias} to {@link Inquisitor} 
	 * 
	 */
	public static void passRequest(ArrayList<A> criterias) {
		instance.inquisitors.add(new Inquisitor(criterias));
	}
	
	// Dynamic ---------------------------------------------------------------------------------------------------------
	
	
	
	private ArrayList<Inquisitor> inquisitors = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		Application.passRequest(new ArrayList<A>());
	}
	
}
