package request;

import java.lang.reflect.InvocationTargetException;

import beans.Chomage;

import db.*;
import db.dao.AgeDAO;
import db.dao.AgricultureDAO;
import db.dao.AnimationDAO;
import db.dao.ChomageDAO;
import db.dao.CommerceDAO;
import db.dao.DAO;
import db.dao.IndustrieDAO;
import db.dao.SanteeDAO;
import db.dao.TourismeDAO;
import db.dao.VilleDAO;

public class Criteria {
	// Static
	// ----------------------------------------------------------------------------------------------------------

	public final static Criteria animation = new Criteria("animation", "animation","culture", AnimationDAO.class); // 5 dernier
	public final static Criteria chomage = new Criteria("chomage", "chomage","economie", ChomageDAO.class); // taux de chomage
	public final static Criteria tourisme = new Criteria("tourisme", "tourisme","economie", TourismeDAO.class); //
	public final static Criteria industrie = new Criteria("industrie", "industrie","economie", IndustrieDAO.class); // nb entreprise , nb d'habitant
	public final static Criteria agriculture = new Criteria("agriculture", "agriculture","economie", AgricultureDAO.class); // nb entreprise, nb d'habitant
	public final static Criteria commerce = new Criteria("commerce", "commerce","economie", CommerceDAO.class); // nb entreprise, nb habitant
	public final static Criteria senior = new Criteria("senior", "senior","population", AgeDAO.class); // % de tout
	public final static Criteria jeunes = new Criteria("jeunes", "jeunes","population", AgeDAO.class); // %
	public final static Criteria santee = new Criteria("santee", "santee","service_publique", SanteeDAO.class); // les docteur s et companie
	public final static Criterib ville2000 = new Criterib("ville2000", "ville2000","population", VilleDAO.class); // nb habitant
	public final static Criterib ville2000_50000 = new Criterib("ville2000_50000","population", "ville2000_50000", VilleDAO.class); // nb habitant
	public final static Criterib ville50000_200000 = new Criterib("ville50000_200000","population", "ville50000_200000", VilleDAO.class); // nb																									// habitant
	public final static Criterib ville200000 = new Criterib("ville200000", "ville200000","population", VilleDAO.class); // nb habitant 2000 - 2015 +
																							// 2025
	// distance ville de ref

	public final static Criteria[] as = { animation, chomage, tourisme, industrie, agriculture, commerce, senior, jeunes,
			santee};
	
	//public final static Criteria[] culture = {animation};
	//public final static Criteria[] economie = {chomage, tourisme, industrie, agriculture, commerce};
	//public final static Criteria[] population = {senior, jeunes };
	//public final static Criteria[] service_publique = {santee};
	//public final static Criteria[] taille_et_location = {ville2000, ville2000_50000, ville50000_200000, ville200000};
	
	// Dynamic
	// ---------------------------------------------------------------------------------------------------------

	public final String ATTRIBUT_NAME;
	public final String TABLE_NAME;
	public final String TYPE;
	public final Class CLASS;

	public Criteria(String attribut_name, String name, String type, Class machin) {
		ATTRIBUT_NAME = attribut_name;
		TABLE_NAME = name;
		TYPE =type;
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
