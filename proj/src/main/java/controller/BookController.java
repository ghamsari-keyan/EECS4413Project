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

@SuppressWarnings("serial")
@WebServlet("/books")
public class BookController extends HttpServlet {

	private BookDAO bookDAO;

	public BookController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		bookDAO = new BookDAOImpl(getServletContext()); //pass servlet context into DAO 

		// calling DAO method to retrieve category List from Database, for left column display
		List<Category> categoryList = bookDAO.findAllCategories();
		ServletContext context = getServletContext();
		context.setAttribute("categoryList", categoryList);
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

		if (action != null) {
			switch (action) {
			case "allBooks":
				findAllBooks(request, response);
				url = base + "listOfBooks.jsp";
				break;
			case "category":
				findBooksByCategory(request, response, category);
				url = base + "category.jsp?category=" + category;
				break;
			case "search":
				searchBooks(request, response, keyWord);
				url = base + "searchResult.jsp";
				break;
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	private void findAllBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Calling DAO method to retrieve a list of all books
			
			List<Book> bookList = bookDAO.findAllBooks();
			
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//search books by keyword
	private void searchBooks(HttpServletRequest request, HttpServletResponse response, String keyWord)
			throws ServletException, IOException {
		try {
			// Calling DAO method to search books by keyword
			
			List<Book> bookList = bookDAO.searchBooksByKeyword(keyWord);
			
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void findBooksByCategory(HttpServletRequest request, HttpServletResponse response, String category)
			throws ServletException, IOException {
		try {
			// Calling DAO method to search books by category
			
			List<Book> bookList = bookDAO.findBooksByCategory(category);
			
			request.setAttribute("bookList", bookList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}