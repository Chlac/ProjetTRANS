package request;

import java.lang.reflect.InvocationTargetException;

import beans.Chomage;

import db.*;
import db.dao.AgricultureDAO;
import db.dao.AnimationDAO;
import db.dao.ChomageDAO;
import db.dao.CommerceDAO;
import db.dao.DAO;
import db.dao.IndustrieDAO;
import db.dao.Jeunes;
import db.dao.Santee;
import db.dao.Senior;
import db.dao.TourismeDAO;
import db.dao.Ville;

public class Criteria {
	// Static
	// ----------------------------------------------------------------------------------------------------------

	public final static Criteria culture = new Criteria("animation", "animation", AnimationDAO.class); // 5 dernier
	public final static Criteria economie = new Criteria("chomage", "chomage", ChomageDAO.class); // taux de chomage
	public final static Criteria tourisme = new Criteria("tourisme", "tourisme", TourismeDAO.class); //
	public final static Criteria industrie = new Criteria("industrie", "industrie", IndustrieDAO.class); // nb entreprise , nb d'habitant
	public final static Criteria agriculture = new Criteria("agriculture", "agriculture", AgricultureDAO.class); // nb entreprise, nb d'habitant
	public final static Criteria commerce = new Criteria("commerce", "commerce", CommerceDAO.class); // nb entreprise, nb habitant
	public final static Criteria senior = new Criteria("senior", "senior", Senior.class); // % de tout
	public final static Criteria jeunes = new Criteria("jeunes", "jeunes", Jeunes.class); // %
	public final static Criteria santee = new Criteria("santee", "santee", Santee.class); // les docteur s et companie
	public final static Criteria ville2000 = new Criteria("ville2000", "ville2000", Ville.class); // nb habitant
	public final static Criteria ville2000_50000 = new Criteria("ville2000_50000", "ville2000_50000", Ville.class); // nb habitant
	public final static Criteria ville50000_200000 = new Criteria("ville50000_200000", "ville50000_200000", Ville.class); // nb																									// habitant
	public final static Criteria ville200000 = new Criteria("ville200000", "ville200000", Ville.class); // nb habitant 2000 - 2015 +
																							// 2025
	// distance ville de ref

	public final static Criteria[] as = { culture, economie, tourisme, industrie, agriculture, commerce, senior, jeunes,
			santee, ville2000, ville2000_50000, ville50000_200000, ville200000 };
	// Dynamic
	// ---------------------------------------------------------------------------------------------------------

	public final String ATTRIBUT_NAME;
	public final String TABLE_NAME;
	public final Class CLASS;

	public Criteria(String attribut_name, String name, Class machin) {
		ATTRIBUT_NAME = attribut_name;
		TABLE_NAME = name;
		CLASS = machin;
	}

	public Object redirectToDAO(String codGeo) {
		try {
			return ((DAO) CLASS.getConstructor(new Class[0]).newInstance(new Object[0])).f(codGeo);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}

}
