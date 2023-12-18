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
 * Servlet implementation class Category
 */
@WebServlet("/CategoryControl")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private ItemDAO itemDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryControl() {
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
		String url = base + "productsByCategory.jsp";
		String action = request.getParameter("chooseCategory");


		/*
		 * Here we will call the function to access the DAO method for finding all products by brand
		 */
		if (action != null) {

			findProductsByCategory(request, response, action);

			Map<String, String> catURL = url(request);
			request.setAttribute("url", catURL);
       
		}

		System.out.println(action);

		request.setAttribute("category", action);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	private void findProductsByCategory(HttpServletRequest request, HttpServletResponse response, String prodType) 
			throws ServletException, IOException {
		try {

			List<Item> prodsOfCat = itemDAO.getProductsByCategory(prodType);

			request.setAttribute("catProds", prodsOfCat);

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private Map<String, String> url(HttpServletRequest request) {
	    Map<String, String> url = new HashMap<>();
	    String contextPath = request.getContextPath();
	    url.put("Laptop", contextPath + "/images/Laptop.png");
        url.put("Desktop", contextPath + "/images/Desktop.png");
        url.put("Monitor", contextPath + "/images/Monitor.png");
        url.put("Keyboard", contextPath + "/images/Keyboard.png");
        url.put("Mouse", contextPath + "/images/Mouse2.png");
        url.put("Headphones", contextPath + "/images/Headphones.png");
        url.put("Speaker", contextPath + "/images/Speaker.png");
        url.put("Tablet", contextPath + "/images/Tablet.png");
        url.put("Router", contextPath + "/images/Router.png");
        url.put("Printer", contextPath + "/images/Printer.png");
        url.put("Scanner", contextPath + "/images/Scanner.png");
        url.put("Webcam", contextPath + "/images/Webcam.png");
        url.put("External Drive", contextPath + "/images/External Drive.png");
        url.put("Graphics Card", contextPath + "/images/Graphics Card.png");
        url.put("RAM", contextPath + "/images/RAM.png");

        return url;
    }
}
