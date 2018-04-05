package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Age;
import beans.Commerce;
import core.Application;

public class AgeDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		try {
			String query = "SELECT enfants, jeunes, adultes, senior, (enfants+jeunes+adultes+sernior) as total FROM ages WHERE codGeo="+ codGeo+ " and annee =2014 limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Age a = new Age();
			a.setEnfants((double)rs.getInt(1)/rs.getInt(rs.getInt(5)));
			a.setJeunes((double)rs.getInt(2)/rs.getInt(rs.getInt(5)));
			a.setAdultes((double)rs.getInt(3)/rs.getInt(rs.getInt(5)));
			a.setSenior((double)rs.getInt(4)/rs.getInt(rs.getInt(5)));
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
