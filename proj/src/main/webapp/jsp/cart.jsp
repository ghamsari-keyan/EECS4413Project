<%@ page import="model.Cart" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="path/to/your/css/style.css">
</head>
<body>
    <h1>Shopping Cart</h1>

    <%
        Cart cart = (Cart) session.getAttribute("cart");
        List<Item> cartItems = cart.getItems();
    %>

    <% if (cart.isEmpty()) { %>
        <p>Shopping cart is empty</p>
    <% } else { %>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (Item item : cartItems) { %>
                    <tr>
                        <td><%= item.getProdName() %></td>
                        <td>
                            <form action="cartServlet" method="post">
                                <input type="hidden" name="action" value="updateCart">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="number" name="newQty" value="<%= item.getOrderedQty() %>" min="1" max="<%= item.getQuantityAvail() %>">
                                <input type="submit" value="Update">
                            </form>
                        </td>
                        <td><%= item.getPrice() %></td>
                        <td>
                            <form action="cartServlet" method="post">
                                <input type="hidden" name="action" value="removeFromCart">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="submit" value="Remove">
                            </form>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>
</body>
</html>