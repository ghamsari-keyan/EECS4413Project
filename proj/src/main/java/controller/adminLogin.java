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
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Customer;
import model.Item;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdministratorDAO adminDAO;
	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;
       
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
    	customerDAO = new CustomerDAOImpl(getServletContext());
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
        	
        	case "home":
        		url = url;
        		break;
        	case "inventory":
        		getInventoryList(request, response);
        		url = base+"AdminInventory.jsp";
        		break;
        	case "customer":
        		getCustomerList(request, response);
        		url=base + "customerView.jsp";
        		break;
        	case "addProduct":
        		url=base+"addProduct.jsp";
//        		addProduct(request, response);
        		break;
        	case "submitNewProd":
        		System.out.println("Submit new Prod");
        		url = base +"addProduct.jsp";
        		addProduct(request,response);
        		break;
        	}
        	
    	}
        
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
	
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("adding prod");
		
		String id = request.getParameter("id");
		String name = request.getParameter("prodName");
		String brand = request.getParameter("prodMake");
		String cat = request.getParameter("cat");
		double version = Double.parseDouble(request.getParameter("prodVers"));
		String platform = request.getParameter("platform");
		String info = request.getParameter("info");
		double price = Double.parseDouble(request.getParameter("price"));
		double rating = Double.parseDouble(request.getParameter("rating"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		boolean eco = Boolean.parseBoolean(request.getParameter("eco"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		
		
		String addProdGood = "add-prod-good";
		String addProdBad = "add-prod-bad";

		
		boolean added = itemDAO.addProductToDatabase(id, name, cat, brand, info, qty, price, rating, eco, version, platform, weight);
		
		/*
		 * If an item doesn't exist with the same id, we are good to go
		 */
		if(added == true) {
			
			request.setAttribute("add-good", addProdGood);
			
		}
		
		else {
			
			request.setAttribute("addProdBad", addProdGood);
		}
		
		System.out.println("Adding = " + added);
	}
	
	
	private void getInventoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// Calling DAO method to retrieve a list of all books
			
			List<Item> inventory = itemDAO.productList();
			
			request.setAttribute("inventory", inventory);
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void getCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Customer> customers = customerDAO.getCustomerList();
			
			request.setAttribute("customerList", customers);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		

}