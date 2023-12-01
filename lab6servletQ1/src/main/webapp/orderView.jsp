<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order View</title>
</head>
<body>

    <h3>Thank you for ordering. </h3>

    <table border='1' cellpadding='6'>
        <tr>
            <th>Book ID</th>
            <th>AUTHOR</th>
            <th>TITLE</th>
            <th>PRICE</th>
            <th>QTY</th>
        </tr>

        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.author}</td>
                <td>${item.title}</td>
                <td>${item.price}</td>
                <td>${item.orderedQty}</td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan='5'>Total Price: $${sessionScope.totalPrice}</td>
        </tr>
    </table>

    <ul>
        <li>Customer Name: ${param.cust_name}</li>
        <li>Customer Phone Number: ${param.cust_phone}</li>
        <li>Customer City: ${param.cust_city}</li>
    </ul>

    <p><a href='index.html'>Back to Select Menu</a></p>

</body>
</html>
