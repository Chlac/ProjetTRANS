package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Agriculture;
import beans.Animation;
import beans.Evenement;
import core.Application;

public class AnimationDAO extends DAO {

	@Override
	public Object f(String codGeo) {
		try {
			String query = "SELECT jourDebut, moisDebut, anneeDebut, themes, libelleOrg from evenement where codGeo="+ codGeo+" ORDER BY anneeDebut DESC, moisDebut DESC, jourDebut DESC limit 5";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Animation animation = new Animation();
			ArrayList<Evenement> events = new ArrayList<>();
			while(rs.next()) {
				Evenement e = new Evenement();
				e.setDate(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
				e.setTheme(merde(rs.getString(4)));
				e.setNom_organisation(rs.getString(5));
				events.add(e);
			}
			return animation;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private String merde(String s) {
		s.replace("Tout l'agenda", "");
		s.replace("Tout l'agenda|", "");
		s.replace("|", "-");
		return s;
		
	}

}
