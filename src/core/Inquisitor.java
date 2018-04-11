package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ResultSetMetaData;

import beans.*;
import db.dao.CommuneDAO;
import javafx.collections.transformation.SortedList;
import request.Criteria;
import request.Request;
import sun.swing.text.CountingPrintable;

/**
 * Manage the creation of SQL request from the requested criteria
 *
 */
public class Inquisitor {
	// Static
	static int n = 0;

	// Dynamic

	private Request request;

	public Inquisitor(Request request) {
		this.request = request;
		// start();
	}

	JsonObject fuckSQL() {

		HashMap<String, ArrayList<Double>> merde = new HashMap<>();
		int size = request.criterias.size();
		ArrayList<String> l = new ArrayList<>();
		{
		String query = "SELECT codGeo FROM commune ORDER BY codGeo";
		ResultSet rs = Application.passQuery(query);
		try {
			while(rs.next()) {
				merde.put(rs.getString(1), new ArrayList<>());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		for (int i = 0; i < request.criteribs.size(); i++) {
			String query = "SELECT codGeo FROM"+ request.criteribs.get(i).TABLE_NAME + "ORDER BY codGeo";
			ResultSet rs = Application.passQuery(query);
			ArrayList<String> temp = new ArrayList<>();
			try {
				while(rs.next()) {
					temp.add(rs.getString(1));
				}
				if (i != 0) {					
					ArrayList<String> tempA = (ArrayList<String>) l.clone();
					tempA.removeAll(temp);
					l.removeAll(tempA);
				}
				else {
					l.addAll(temp);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		for (int i = 0; i < size; i++) {
			String query = "SELECT codGeo, score FROM " + request.criterias.get(i).TABLE_NAME + " ORDER BY codGeo";
			ResultSet rs = Application.passQuery(query);
			try {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				
					while (rs.next()) {
						String s = rs.getString(1);
						System.out.println(merde.get(rs.getString(1)));
						if (merde.get(rs.getString(1)) != null )merde.get(rs.getString(1)).add(rs.getDouble(2));
						
						// t.add(rs.getDouble(2));
						// merde.put(rs.getString(1),t);

					}
				}
			 catch (Exception e) {
				System.out.println(e);
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
		//merde = null;
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
		ArrayList<String> villes = new ArrayList<>();
		for (int j = 0; j < 10; j++) {
			// System.out.print(list.get(j).getKey()+"\t");
			// for (double d : list.get(j).getValue()) {
			// System.out.print(d+"\t");
			// }
			// System.out.println("");
			villes.add(list.get(j).getKey());
		}
		//return fuckSQLDetails(res);
		Gson gson = new Gson(); 
        JsonObject jsonObject = new JsonObject();
        int n = 1;
		for (String codGeo : villes) {
			double s_culture = 0.0,s_economie = 0.0, s_population = 0.0, s_service_publique = 0.0;
			int n_culture = 1, n_economie = 1, n_population = 1, n_service_publique = 1;
			HashMap<String, Object> culture = new HashMap<>(), economie = new HashMap<>(), population = new HashMap<>(),
					service_publique = new HashMap<>();
			//ArrayList<Object> details = new ArrayList<>();
			for (int i = 0; i < merde.get(codGeo).size(); i++) {
				//details.add(request.criterias.get(i).redirectToDAO(codGeo, merde.get(codGeo).get(i+1)));
				switch (request.criterias.get(i).TYPE) {
				case "culture":
					s_culture+=merde.get(codGeo).get(i+1);
					culture.put(request.criterias.get(i).ATTRIBUT_NAME,request.criterias.get(i).redirectToDAO(codGeo, merde.get(codGeo).get(i+1)));
					break;
				case "economie":
					s_economie+=merde.get(codGeo).get(i+1);
					economie.put(request.criterias.get(i).ATTRIBUT_NAME,request.criterias.get(i).redirectToDAO(codGeo, merde.get(codGeo).get(i+1)));
					break;
				case "population":
					s_population+=merde.get(codGeo).get(i+1);
					population.put(request.criterias.get(i).ATTRIBUT_NAME,request.criterias.get(i).redirectToDAO(codGeo, merde.get(codGeo).get(i+1)));
					break;
				case "service_publique":
					s_service_publique+=merde.get(codGeo).get(i+1);
					service_publique.put(request.criterias.get(i).ATTRIBUT_NAME,request.criterias.get(i).redirectToDAO(codGeo, merde.get(codGeo).get(i+1)));
					break;
				default:
					break;
				}
			}
				
				Culture c = null;
				Economie e = null;
				Population p = null;
				ServicePublique s = null;
				if (culture.size() != 0) {
				c = new Culture();
				c.setScore(s_culture/n_culture);
				c.setDetails(culture);
				}
				if (economie.size() != 0) {
				e = new Economie();
				e.setScore(s_economie/n_economie);
				e.setDetails(economie);
				}
				if (population.size() != 0) {
				p = new Population();
				p.setScore(s_population/n_population);
				p.setDetails(population);
				}
				if (service_publique.size() != 0) {
				s = new ServicePublique();
				s.setScore(s_service_publique/n_service_publique);
				s.setDetails(service_publique);
				}
			
			
			City city = CommuneDAO.f(codGeo, c, e, p, s);
			JsonElement cityObj = gson.toJsonTree(city);
	        if(city.getName() == null) jsonObject.addProperty("success", false);
	        else {
	        	jsonObject.addProperty("success", true);
	        	jsonObject.add(String.valueOf(n++), cityObj);
	        }
		}
		return jsonObject;
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
/*
	private JsonObject fuckSQLDetails(ArrayList<String> villes){
		Gson gson = new Gson(); 
        JsonObject jsonObject = new JsonObject();
        int n = 1;
		for (String codGeo : villes) {
			
			ArrayList<Object> details = new ArrayList<>();
			for (Criteria criteria : request.criterias) {
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
	}*/

	/*
	 * SELECT table1.id, ((table1.score + table2.score + table3.score)/3) as average
	 * FROM table1 INNER JOIN table2 ON (table1.id = table2.id) INNER JOIN table3 ON
	 * (table2.id = table3.id) ORDER BY average DESC LIMIT 10;
	 */

}
