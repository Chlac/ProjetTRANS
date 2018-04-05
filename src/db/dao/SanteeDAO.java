package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Chomage;
import beans.Santee;
import core.Application;

public class SanteeDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		
		try {
			String query = "select nbOmnipaticiensBV, nbDentistesLiberrauxBV from commune2014 where codGeo="+codGeo+" limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Santee santee = new Santee();
			santee.setMedecin_generaliste(rs.getInt(1));
			santee.setMedecin_generaliste(rs.getInt(2));
			return santee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
