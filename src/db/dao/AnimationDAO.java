package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Agriculture;
import core.Application;

public class AnimationDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		try {
			String query = "SELECT jourDebut, moisDebut, anneeDebut, themes, libelleOrg from evenement where codGeo=41018 ORDER BY anneeDebut DESC, moisDebut DESC, jourDebut DESC limit 5";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Animation animation = new Animation();
			agriculture.setNombre_entreprise_agriculture(rs.getInt(1));
			return agriculture;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
