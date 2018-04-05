package core;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import db.A;
import request.Criteria;
import request.Request;


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
	public static JsonObject passRequest(Request request) {
		return instance.passRequest2(request);
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
	private synchronized JsonObject passRequest2(Request criterias) {
		Inquisitor i = new Inquisitor(criterias);
		inquisitors.add(i);
		//return i.temp();
		return i.fuckSQL();
	}
	
	public ResultSet passQuery2(String request) {
		return db.executeQuery(request);
	}
	
}
