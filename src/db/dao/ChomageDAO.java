package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Chomage;
import core.Application;

public class ChomageDAO extends DAO {

	public Object f(String codGeo) {
		try {
			String query = "SELECT chomage FROM chomage WHERE codGeo="+ codGeo+ " limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Chomage chomage = new Chomage();
			chomage.setTaux_chomage(rs.getDouble(1));
			return chomage;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	};

}
