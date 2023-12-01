package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

import model.Book;
import dao.*;
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BookBAOImpl bao = new BookBAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		ArrayList<Book> output = new ArrayList<>();


    	String[] authorsSelected = request.getParameterValues("author");
    	
    	output = bao.search(authorsSelected);

    	// Set the list of books as a request attribute
    	request.setAttribute("bookList", output);
	
    	// Use RequestDispatcher to forward to 'bookResultView.jsp'
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/bookResultView.jsp");
    	dispatcher.forward(request, response);
    
    }

}
