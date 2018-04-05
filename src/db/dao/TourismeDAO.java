package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Agriculture;
import beans.Tourisme;
import core.Application;

public class TourismeDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		//String query = "SELECT ETAZ10 FROM agriculture WHERE codGeo="+ codGeo+ " limit 1";
		//ResultSet rs = Application.passQuery(query);
		//rs.next();
		Tourisme tourisme = new Tourisme();
		//agriculture.setNombre_entreprise_agriculture(rs.getInt(1));
		return tourisme;
	}

}
