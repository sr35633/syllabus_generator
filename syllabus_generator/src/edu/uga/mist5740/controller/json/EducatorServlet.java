package edu.uga.mist5740.controller.json;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.uga.mist5740.model.Educator;
import edu.uga.mist5740.model.EducatorManager;

/**
 * Servlet implementation class EducatorServlet
 */
@WebServlet(description = "Returns information about the educator who is signed in", urlPatterns = { "/EducatorServlet", "/Educator" })
public class EducatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducatorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{
	        ArrayList<Educator> educators = EducatorManager.getEducators();
	        
	        ObjectMapper om = new ObjectMapper();
	        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
	        
	        String json = ow.writeValueAsString(educators);
	        
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
	        response.getWriter().write(json);
	    }catch(Exception e){
	        response.sendError(400);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
