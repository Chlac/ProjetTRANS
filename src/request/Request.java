package request;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Request {
	public ArrayList<Criteria> criterias = new ArrayList<>();
	public ArrayList<Criterib> criteribs = new ArrayList<>();
	
	public Request(HttpServletRequest request){
		for (int i = 0; i < Criteria.as.length; i++) {
			if (request.getParameter(Criteria.as[i].ATTRIBUT_NAME) != null) criterias.add(Criteria.as[i]);
		}
		for (int i = 0; i < Criterib.bs.length; i++) {
			if (request.getParameter(Criterib.bs[i].ATTRIBUT_NAME) != null) criteribs.add(Criterib.bs[i]);
		}
	}
	
	
}
