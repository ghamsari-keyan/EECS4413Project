package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import model.Cart;
import model.Item;
import dao.ItemDAOImpl;

@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
    private ItemDAOImpl itemDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        itemDao = new ItemDAOImpl(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if (action != null) {
            String itemId = request.getParameter("itemId");
            switch (action) {
                case "addToCart":
                    try {
                    	System.out.println("add to cart");
                        int quantity = Integer.parseInt(request.getParameter("quantity"));
                        Item item = itemDao.getProductById(itemId);
                        System.out.println(itemId);
                        if (item == null) {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");
                            response.getWriter().write("{\"status\":\"error\", \"message\":\"Item not found\"}");
                            return;
                        }
                        cart.addItem(item, quantity);
                        
                    } catch (NumberFormatException e) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid quantity format");
                        return;
                    } catch (IllegalArgumentException e) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid item");
                        return;
                    }
                    break;
                case "remove":
                    cart.removeItem(itemId);
                    break;
                case "update":
                    try {
                        int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
                        cart.updateItem(itemId, newQuantity);
                    } catch (NumberFormatException e) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid quantity format");
                        return;
                    }
                    break;
            }
        }

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String jsonResponse = "{\"status\":\"success\", \"totalPrice\":" + cart.calculateTotal() + "}";
            response.getWriter().write(jsonResponse);
        } else {
            String nextJSP = "/jsp/cart.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request, response);
        }
    }
    
   
}
