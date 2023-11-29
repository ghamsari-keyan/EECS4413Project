package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorDAO;
import dao.AdministratorDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Item;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdministratorDAO adminDAO;
	private ItemDAO itemDAO;
       
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
    	itemDAO = new ItemDAOImpl(getServletContext());
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

        
        String action=request.getParameter("action");
        
        if (action!=null) {
        	
        	switch(action) {
        	
        	case "inventory":
        		getInventoryList(request, response);
        		url = base+"AdminInventory.jsp";
        		break;
        	}
    	}
        
        
        
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
//	private void validateAdminLogin(HttpServletRequest request, HttpServletResponse response, String username, String password)
//			throws ServletException, IOException {
//		
//		int loginVer = adminDAO.adminExists(username, password);
//		
//		if(loginVer == 1) {
//			
//			
//		}
//		else if(loginVer == 2) {
//			
//		}
//		else if(loginVer == 3) {
//			
//			
//		}
//		
//		
//	}
	
	
	private void getInventoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			System.out.println("got to getInv");
			
			// Calling DAO method to retrieve a list of all books
			
			List<Item> inventory = itemDAO.productList();
			
			request.setAttribute("inventory", inventory);
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
		

}