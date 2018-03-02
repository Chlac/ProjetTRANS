package core;

import java.util.ArrayList;

import request.A;

/**
 * Manage the creation of SQL request from the requested criteria
 *
 */
public class Inquisitor {

	
	private ArrayList<A> request;
	
	public Inquisitor(ArrayList<A> request) {
		this.request = request;
		
	}


	
	private void temp() {
		String req = "SELECT "+ request.get(0).TABLE_NAME+".id, (("+request.get(0).TABLE_NAME+".score";
		for (int i = 1; i < request.size(); i++) {
			req+= "+ "+request.get(i).TABLE_NAME+".score";
		}
		req += ")/"+request.size()+") as average FROM " + request.get(0).TABLE_NAME;
		for (int i = 1; i < request.size(); i++) {
			req += " INNER JOIN" + request.get(i).TABLE_NAME
					+ " ON (" + request.get(i-1).TABLE_NAME+".id = "+ request.get(i).TABLE_NAME+".id )";
		}
		req += "ORDER BY averag DESC LIMIT 10";
	}
	
	/*
	 * SELECT table1.id, ((table1.score + table2.score + table3.score)/3) as average
	 * FROM table1 
	 * 	INNER JOIN table2 ON (table1.id = table2.id)
	 * 	INNER JOIN table3 ON (table2.id = table3.id)			 
	 * ORDER BY average DESC LIMIT 10;
	 */

}
