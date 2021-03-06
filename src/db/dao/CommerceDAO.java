package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import beans.Commerce;
import core.Application;

public class CommerceDAO extends DAO {

	@Override
	public Object f(String codGeo, double score) {
		try {
			String query = "SELECT nbEntreprisesSecteurCommerce, nbEntreprisesSecteurServ FROM commerce WHERE codGeo="+ codGeo+ " limit 1";
			ResultSet rs = Application.passQuery(query);
			rs.next();
			Commerce commerce = new Commerce();
			commerce.setNb_entreprise_commerce(rs.getInt(1));
			commerce.setNb_entreprise_service(rs.getInt(2));
			commerce.setScore(score);
			return commerce;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
