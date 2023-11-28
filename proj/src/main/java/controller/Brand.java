package controller;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import dao.ItemDAO;
import dao.ItemDAOImpl;

/**
 * Servlet implementation class Brand
 */
@WebServlet("/Brand")
public class Brand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ItemDAO itemDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Brand() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
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
		String url = base + "productsByBrand.jsp";
		String action = request.getParameter("chooseBrand");
		
		
		/*
		 * Here we will call the function to access the DAO method for finding all products by brand
		 */
		if (action != null) {
			
			findProductsByBrand(request, response, action);
			
		}
		
		System.out.println(action);
		
		request.setAttribute("brand", action);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	
	private void findProductsByBrand(HttpServletRequest request, HttpServletResponse response, String brand) 
			throws ServletException, IOException {
		try {
			
			List<Item> prodsOfBrand = itemDAO.getProductsByBrand(brand);
					
			request.setAttribute("brandProds", prodsOfBrand);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
