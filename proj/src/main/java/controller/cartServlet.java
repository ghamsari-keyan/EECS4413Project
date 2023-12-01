package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


import model.*;
import dao.*;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ItemDAO dao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        dao = new ItemDAOImpl(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "addToCart":
                    addToCart(request, cart);
                    break;
                case "updateCart":
                    updateCart(request, cart);
                    break;
                case "removeFromCart":
                    removeFromCart(request, cart);
                    break;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cart.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void addToCart(HttpServletRequest request, Cart cart) {
    	System.out.println("addToCart method invoked");
	    String itemIdStr = request.getParameter("itemId");
	    String qtyOrderedStr = "1";
	    System.out.println("itemIdStr: " + itemIdStr + ", qtyOrderedStr: " + qtyOrderedStr);
        // Check if itemIdStr and qtyOrderedStr are not null or empty
	    //Item is null for some reason.
        if (itemIdStr != null && !itemIdStr.isEmpty() && qtyOrderedStr != null && !qtyOrderedStr.isEmpty()) {
            try {
                int qtyOrdered = Integer.parseInt(qtyOrderedStr);

                Item item = dao.getProductById(itemIdStr);

                if (item != null && qtyOrdered > 0 /*&& qtyOrdered <= item.getQuantityAvail()*/) {
                    System.out.println(item.getItemId() + item.getProdType() + item.getProdName() + item.getProdInfo()+
                            item.getBrandName() + item.getQuantityAvail() + item.getPrice() + item.getRating() +
                            item.isEcoFriendly() + item.getProdVersion() + item.getProdPlatform() + item.getWeight() +
                            qtyOrdered);
                	cart.add(item.getItemId(), item.getProdType(), item.getProdName(), item.getProdInfo(),
                            item.getBrandName(), item.getQuantityAvail(), item.getPrice(), item.getRating(),
                            item.isEcoFriendly(), item.getProdVersion(), item.getProdPlatform(), item.getWeight(),
                            qtyOrdered);
                }
            } catch (NumberFormatException e) {
                // Handle the case where itemIdStr or qtyOrderedStr is not a valid integer
                // Log the error or provide feedback to the user
                e.printStackTrace(); // This prints the exception details to the console
            }
        }
    }



    private void updateCart(HttpServletRequest request, Cart cart) {
        String itemId = request.getParameter("itemId");
        int newQty = Integer.parseInt(request.getParameter("newQty"));

        Item item = dao.getProductById(itemId);

        if (item != null && newQty > 0 && newQty <= item.getQuantityAvail()) {
            cart.update(itemId, newQty);
        }
    }

    private void removeFromCart(HttpServletRequest request, Cart cart) {
        String itemId = request.getParameter("itemId");
        cart.remove(itemId);
    }
}
