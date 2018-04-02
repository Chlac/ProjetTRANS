package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ResultSetMetaData;

import beans.City;
import core.Application;
import request.Criteria;

/**
 * Servlet implementation class UpdateResultsServlet
 */
@WebServlet("/UpdateResultsServlet")
public class UpdateResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
		
		PrintWriter out = response.getWriter();

        Gson gson = new Gson(); 
        JsonObject jsonObject = new JsonObject();

        City city = new City("Paris");
        City city1 = new City("Orléans");
        
        JsonElement cityObj = gson.toJsonTree(city);
        if(city.getName() == null) jsonObject.addProperty("success", false);
        else jsonObject.addProperty("success", true);

        JsonElement cityObj1 = gson.toJsonTree(city1);
        if(city1.getName() == null) jsonObject.addProperty("success", false);
        else jsonObject.addProperty("success", true);
        
        jsonObject.add("1", cityObj);
        jsonObject.add("2", cityObj1);
        
        //jsonObject.addProperty("test", "TEST");
        
        
        System.out.println("POST");
		//boolean chomage_checked = request.getParameter("culture1") != null;
		//System.out.println(chomage_checked);
		/*
        ArrayList<Criteria> criterias = new ArrayList<>();
		
		for (int i = 0; i < Criteria.as.length; i++) {
			System.out.println(Criteria.as[i].ATTRIBUT_NAME);
			if (request.getParameter(Criteria.as[i].ATTRIBUT_NAME) != null) criterias.add(Criteria.as[i]);
		}
		
		String r = "";
		if (criterias.size() != 0 ) {
			ResultSet resultSet = Application.passRequest(criterias);
			try {
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				while (resultSet.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						r += (resultSet.getString(i)+ "\t");
					}
					r += ("");
				}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}*/
		
		//jsonObject.addProperty("result", r);
		
		out.println(jsonObject.toString());
		out.close();
		
	}

}
