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



}
