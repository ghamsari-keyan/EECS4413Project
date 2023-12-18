<%@ page import="model.Cart" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
    <h2>Shopping Cart</h2>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
    %>
    <table>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Item item : cart.getItems()) {
            %>
                <tr>
                    <td><%= item.getItemId() %></td>
                    <td><%= item.getProdName() %></td>
                    <td><%= item.getOrderedQty() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getPrice() * item.getOrderedQty() %></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <p>Total Price: $<%= cart.calculateTotal() %></p>
</body>
</html>
