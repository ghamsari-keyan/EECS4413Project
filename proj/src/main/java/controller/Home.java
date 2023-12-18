package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;
import model.Category;
import model.Item;
import dao.ItemDAO;
import dao.ItemDAOImpl;

@SuppressWarnings("serial")
@WebServlet("/books")
public class Home extends HttpServlet {

	private ItemDAO itemDAO;

	public Home() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		
		
		itemDAO = new ItemDAOImpl(getServletContext()); //pass servlet context into DAO 

		// calling DAO method to retrieve category List from Database, for left column display
//		List<Category> categoryList = bookDAO.findAllCategories();
//		ServletContext context = getServletContext();
//		context.setAttribute("categoryList", categoryList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String keyWord = request.getParameter("keyWord");
		
		findFeaturedBooks(request, response);
		
		
		if (action != null) {
			switch (action) {
			case "allBooks":
				findAllBooks(request, response);
				url = base + "listOfBooks.jsp";
				break;
			case "category":
				findProductsByCategory(request, response);
				url = base + "category.jsp";
				break;
			case "brands":
				findProductsByBrand(request, response);
				url = base + "brands.jsp";
				break;
			case "search":
				searchProducts(request, response, keyWord);
				url = base + "searchResult.jsp";
				break;
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/*
	 * METHOD FOR DISPLAYING ALL THE BOOKS
	 */
	private void findAllBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Calling DAO method to retrieve a list of all books
			
			List<Item> inventory = itemDAO.productList();
			
			request.setAttribute("inventory", inventory);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findFeaturedBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Calling DAO method to retrieve a list of all books
			
			List<Item> inventory = itemDAO.productList();
			
			List<Item> featured = inventory.subList(0, 1);
			
			
			request.setAttribute("featured", featured);

		} catch (Exception e) {
			System.out.println(e);
		}
	}


	/*
	 * Get all products by brand
	 */
	private void findProductsByBrand(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			
			List<String> brandNames = itemDAO.getBrandNames();
					
			request.setAttribute("brandProds", brandNames);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	private void findProductsByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Calling DAO method to search books by category
			
			List<String> prodList = itemDAO.getCategoryNames();
			
			request.setAttribute("catProds", prodList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/**
	 * Method that calls on the site search feature
	 */
	private void searchProducts(HttpServletRequest request, HttpServletResponse response, String keyword) throws ServletException, IOException {
		
		
		try {
			List<Item> searchResp = itemDAO.searchProducts(keyword);
			request.setAttribute("searchResponse", searchResp);
			System.out.println(searchResp.toArray().toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
			
	}
	
}