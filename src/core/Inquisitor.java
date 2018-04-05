package core;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ResultSetMetaData;

import beans.City;
import db.dao.CommuneDAO;
import request.Criteria;
import sun.swing.text.CountingPrintable;

/**
 * Manage the creation of SQL request from the requested criteria
 *
 */
public class Inquisitor {
	// Static
	static int n = 0;

	// Dynamic

	private ArrayList<Criteria> request;

	public Inquisitor(ArrayList<Criteria> request) {
		this.request = request;
		// start();
	}

	JsonObject fuckSQL() {

		HashMap<String, ArrayList<Double>> merde = new HashMap<>();
		int size = request.size();
		for (int i = 0; i < size; i++) {
			String query = "SELECT codGeo, score FROM " + request.get(i).TABLE_NAME + " ORDER BY codGeo";
			ResultSet rs = Application.passQuery(query);
			try {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				if (i == 0) {
					while (rs.next()) {
						ArrayList<Double> t = new ArrayList<>(size);
						t.add(rs.getDouble(2));
						merde.put(rs.getString(1), t);
					}
				} else {
					while (rs.next()) {
						String s = rs.getString(1);
						merde.get(rs.getString(1)).add(rs.getDouble(2));
						// t.add(rs.getDouble(2));
						// merde.put(rs.getString(1),t);

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		ArrayList<Entry<String, ArrayList<Double>>> list = new ArrayList<>();
		for (Entry<String, ArrayList<Double>> entry : merde.entrySet()) {
			double temp = 0.0;
			for (Double d : entry.getValue()) {
				temp += d;
			}
			temp /= size;
			temp -= ecart_type(entry.getValue(), size);
			entry.getValue().add(0, temp);
			list.add(entry);
		}
		merde = null;
		list.sort(new Comparator<Entry<String, ArrayList<Double>>>() {
			@Override
			public int compare(Entry<String, ArrayList<Double>> o1, Entry<String, ArrayList<Double>> o2) {
				if (o1.getValue().get(0) > o2.getValue().get(0)) {
					return -1;
				} else if (o1.getValue().get(0) < o2.getValue().get(0)) {
					return 1;
				}
				return 0;
			}

		});
		ArrayList<String> res = new ArrayList<>();
		for (int j = 0; j < 10; j++) {
			// System.out.print(list.get(j).getKey()+"\t");
			// for (double d : list.get(j).getValue()) {
			// System.out.print(d+"\t");
			// }
			// System.out.println("");
			res.add(list.get(j).getKey());
		}
		return fuckSQLDetails(res);
	}

	ResultSet temp() {
		String req = "SELECT " + request.get(0).TABLE_NAME + ".CODGEO,";
		for (int i = 0; i < request.size(); i++) {
			req += " " + request.get(i).TABLE_NAME + ".score, ";
		}
		req += "((" + request.get(0).TABLE_NAME + ".score ";

		for (int i = 1; i < request.size(); i++) {
			req += "+ " + request.get(i).TABLE_NAME + ".score";
		}
		req += ")/" + request.size() + ") as average FROM " + request.get(0).TABLE_NAME;
		for (int i = 1; i < request.size(); i++) {
			req += " INNER JOIN " + request.get(i).TABLE_NAME + " ON (" + request.get(i - 1).TABLE_NAME + ".CODGEO = "
					+ request.get(i).TABLE_NAME + ".CODGEO )";
		}
		req += " ORDER BY average DESC LIMIT 10";
		System.out.println(req);
		return startQuery(req);
	}

	private double ecart_type(ArrayList<Double> l, int n) {
		double a = 0.0;
		double b = 0.0;
		for (Double d : l) {
			a += d * d;
			b += d;
		}
		return Math.sqrt(a / n - ((b / n) * (b / n)));
	}

	private ResultSet startQuery(String query) {
		synchronized (Application.monitor) {
			return Application.passQuery(query);
		}
	}

	private JsonObject fuckSQLDetails(ArrayList<String> villes){
		Gson gson = new Gson(); 
        JsonObject jsonObject = new JsonObject();
        int n = 1;
		for (String codGeo : villes) {
			
			ArrayList<Object> details = new ArrayList<>();
			for (Criteria criteria : request) {
				details.add(criteria.redirectToDAO(codGeo));
			}
			City city = CommuneDAO.f(codGeo, details);
			JsonElement cityObj = gson.toJsonTree(city);
	        if(city.getName() == null) jsonObject.addProperty("success", false);
	        else {
	        	jsonObject.addProperty("success", true);
	        	jsonObject.add(String.valueOf(n++), cityObj);
	        }
		}
		return jsonObject;
	}

	/*
	 * SELECT table1.id, ((table1.score + table2.score + table3.score)/3) as average
	 * FROM table1 INNER JOIN table2 ON (table1.id = table2.id) INNER JOIN table3 ON
	 * (table2.id = table3.id) ORDER BY average DESC LIMIT 10;
	 */

}
