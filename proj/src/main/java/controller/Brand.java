package controller;

import java.awt.List;
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
		
		
		
		System.out.println(action);
		
		request.setAttribute("brand", action);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
//		
		
	}
	
	

}
