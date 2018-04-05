package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Agriculture;
import beans.Chomage;
import core.Application;

public class AgricultureDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		try {
			String query = "SELECT ETAZ10 FROM agriculture WHERE codGeo="+ codGeo+ " limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Agriculture agriculture = new Agriculture();
			agriculture.setNombre_entreprise_agriculture(rs.getInt(1));
			return agriculture;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
