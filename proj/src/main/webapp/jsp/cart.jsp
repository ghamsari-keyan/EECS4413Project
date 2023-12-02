<%@ page import="model.Cart" %>
<%@ page import="model.Item" %>
<%@ page import="dao.ItemDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="itemsList" value="${itemsDao.productList()}" />

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="css/bookstore.css" type="text/css" />
    <script src="js/bookstore.js"></script>
    <title>Shopping Cart</title>
    <style>
        body {
            background-color: black;
            color: white; /* Set the default text color to white */
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1em;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .cart-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .cart-actions form {
            display: flex;
            align-items: center;
        }

        .cart-actions form input {
            margin-right: 10px;
        }

        .total {
            margin-top: 20px;
            text-align: right;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <header>
        <h1>Shopping Cart</h1>
    </header>

    <div class="container">
        <jsp:useBean id="cart" class="model.Cart" scope="session" />

        
        
        <c:choose>
            <c:when test="${cart.size() == 0}">
                <p>Shopping cart is empty</p>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${itemsList}">
                            <tr>
                                <td>${item.prodName}</td>
                                <td>${item.orderedQty}</td>
                                <td>${item.price}</td>
                                <td>${item.total}</td>
                                <td>
                                    <div class="cart-actions">
                                        <form action="cartServlet" method="post">
                                            <input type="hidden" name="action" value="updateCart">
                                            <input type="hidden" name="itemId" value="${item.itemId}">
                                            <input type="number" name="newQty" value="${item.orderedQty}" min="1" max="${item.quantityAvail}">
                                            <input type="submit" value="Update">
                                        </form>
                                        <form action="cartServlet" method="post">
                                            <input type="hidden" name="action" value="removeFromCart">
                                            <input type="hidden" name="itemId" value="${item.itemId}">
                                            <input type="submit" value="Remove">
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="total">
                    Total: $<c:out value="${cart.calculateTotal()}"/>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
