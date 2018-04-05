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

import beans.Chomage;
import beans.City;
import core.Application;
import request.Criteria;
import request.Request;

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
		
		Chomage c = new Chomage(1.3);
		ArrayList<Object> details = new ArrayList<>();
		details.add(c);
		
				
		City city = new City("Paris", "Troudufion", "LoliDep", 1.0, 2.0, 1000, details);
        

        JsonElement cityObj = gson.toJsonTree(city);
        if(city.getName() == null) jsonObject.addProperty("success", false);
        else jsonObject.addProperty("success", true);
        
        jsonObject.add("1", cityObj);
        
        City city2 = new City("Orléans", "Tamere", "LoliPute", 1.0, 2.0, 1000, details);
        

        JsonElement cityObj2 = gson.toJsonTree(city2);
        if(city2.getName() == null) jsonObject.addProperty("success", false);
        else jsonObject.addProperty("success", true);
        
        jsonObject.add("2", cityObj2);
        
        /*
		//boolean chomage_checked = request.getParameter("culture1") != null;
		//System.out.println(chomage_checked);
		
		
        Request r = new Request(request);
		
		
		
		
		JsonObject jO = Application.passRequest(r);
		out.println(jO.toString());
			//out.println("test");
		
		//System.out.println(r);
		//jsonObject.addProperty("result", r);
		
		*/
        
        out.println(jsonObject.toString());
		out.close();
		
	}

}
