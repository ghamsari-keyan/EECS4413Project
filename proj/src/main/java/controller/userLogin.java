package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdministratorDAO;
import dao.AdministratorDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Customer;

/**
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdministratorDAO adminDAO;
	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userLogin() {
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

		HttpSession sesh = request.getSession();
		String base="/jsp/";

		String action=request.getParameter("action");
		String url = "";
		if (action!=null) {

			switch(action) {
			case "login":
        		getCustomerList(request, response);
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				sesh.setAttribute("name", username);
				url = base + "UserHome.jsp";
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void getCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Customer> customers = customerDAO.getCustomerList();

			request.setAttribute("customers", customers);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
