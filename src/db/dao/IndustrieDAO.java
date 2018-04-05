package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Agriculture;
import beans.Industrie;
import core.Application;

public class IndustrieDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		try {
			String query = "SELECT nbEntreprisesSecteurIndustrie  FROM industrie WHERE codGeo="+ codGeo+ " limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Industrie industrie = new Industrie();
			industrie.setNombre_entreprises_industrie(rs.getInt(1));
			return industrie;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
