package db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import beans.City;
import core.Application;

public class CommuneDAO {
	
	
	public static City f(String codGeo, ArrayList<Object> details) {
		try {
			String query  = "SELECT libGeo, codGeoDep, longDeg, latDeg FROM commune WHERE codGeo ="+ codGeo+" limit 1";
			ResultSet rs = Application.passQuery(query);
			City c = new City();
			rs.next(); // LOL C'EST TELLEMENT RIGOLO MYSQL JDBC
			c.setName(rs.getString(1));
			String codGeoDep = rs.getString(2);
			c.setLongitude(rs.getDouble(3));
			c.setLatitude(rs.getDouble(4));
			query = "SELECT population FROM commune2014 WHERE codGeo = "+ codGeo +" limit 1";
			rs = Application.passQuery(query);
			rs.next();
			c.setPopulation2014(rs.getInt(1));
			query = "SELECT libGeo, codGeoReg FROM departement_general WHERE codGeo ="+ codGeoDep+" limit 1";
			rs = Application.passQuery(query);
			rs.next(); // ON SE MARRE ! AU CANARD !
			c.setDepartement(rs.getString(1));
			String codGeoReg = rs.getString(2);
			query = "SELECT libGeo FROM region_general WHERE codGeo ="+ codGeoReg+" limit 1";
			rs = Application.passQuery(query);
			rs.next(); // CANARD T'AS COMRPRIS ?!
			c.setRegion(rs.getString(1));
			c.setDetails(details);
			return c;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
