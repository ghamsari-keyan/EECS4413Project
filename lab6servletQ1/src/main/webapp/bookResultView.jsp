<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book Result View</title>
</head>
<body>

    <h2>Query Results</h2>

    <form method='get' action='CartServlet'>
        <table border='1' cellpadding='6'>
            <tr>
                <th>&nbsp;</th>
                <th>Book ID</th>
                <th>AUTHOR</th>
                <th>TITLE</th>
                <th>PRICE</th>
                <th>QTY</th>
            </tr>

            <c:forEach items="${requestScope.bookList}" var="e">
                <tr>
                    <td><input type='checkbox' name='id' value="${e.id}" /></td>
                    <td>${e.id}</td>
                    <td>${e.author}</td>
                    <td>${e.title}</td>
                    <td>${e.price}</td>
                    <td><input type='text' size='5' value='1' name="qty${e.id}" /></td>
                </tr>
            </c:forEach>
        </table>

        <input type='hidden' name='todo' value='add' />

        <!-- Submit and reset buttons -->
        <input type='submit' value='Add to my SHOPPING CART'>
        <input type='reset' value='CLEAR'>
    </form>

    <!-- Hyperlink to go back to search menu -->
    <p><a href='index.html'>Back to Select Menu</a></p>

</body>
</html>
