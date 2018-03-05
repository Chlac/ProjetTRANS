package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSetMetaData;

import core.Application;
import request.Criteria;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("OKOKOKOKOKOKOKOOK");
		this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("POST");
		//boolean chomage_checked = request.getParameter("culture1") != null;
		//System.out.println(chomage_checked);
		ArrayList<Criteria> criterias = new ArrayList<>();
		
		for (int i = 0; i < Criteria.as.length; i++) {
			System.out.println(Criteria.as[i].ATTRIBUT_NAME);
			if (request.getParameter(Criteria.as[i].ATTRIBUT_NAME) != null) criterias.add(Criteria.as[i]);
		}
		
		if (criterias.size() != 0 ) {
			ResultSet resultSet = Application.passRequest(criterias);
			try {
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				while (resultSet.next()) {
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.print(resultSet.getString(i)+ "\t");
					}
					System.out.println("");
				}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}

}