package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorDAO;
import dao.AdministratorDAOImpl;
import dao.ItemDAOImpl;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdministratorDAO adminDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	adminDAO = new AdministratorDAOImpl(getServletContext());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String base="/jsp/";
		String url = base + "AdminDashboard.jsp";
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        
        System.out.println(username);
        System.out.println(password);        
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
        
	}
	
	/*
	 * System robustness: check if a user exists
	 */
	private void validateAdminLogin(HttpServletRequest request, HttpServletResponse response, String username, String password)
			throws ServletException, IOException {
		
		int loginVer = adminDAO.adminExists(username, password);
		
		if(loginVer == 1) {
			
			
		}
		else if(loginVer == 2) {
			
		}
		else if(loginVer == 3) {
			
			
		}
		
		
	}

}