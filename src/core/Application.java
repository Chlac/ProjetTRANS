package core;

import java.sql.ResultSet;
import java.util.ArrayList;

import db.A;
import request.Criteria;


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
	public static ResultSet passRequest(ArrayList<Criteria> criterias) {
		return instance.passRequest2(criterias);
	}
	
	/**
	 * 
	 * @param request
	 * @return 
	 */
	public static ResultSet passQuery(String request) {
		return instance.passQuery2(request);
	}
	// Dynamic ---------------------------------------------------------------------------------------------------------
	
	
	
	private ArrayList<Inquisitor> inquisitors = new ArrayList<>();
	private A db = new A();
	
	// TODO RENAME + DOC
	private synchronized ResultSet passRequest2(ArrayList<Criteria> criterias) {
		Inquisitor i = new Inquisitor(criterias);
		inquisitors.add(i);
		return i.temp();
	}
	
	public ResultSet passQuery2(String request) {
		return db.executeQuery(request);
	}
	
}
