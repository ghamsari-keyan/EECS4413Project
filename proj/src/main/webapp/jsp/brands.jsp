<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- <%@page import="java.util.List"%> --%>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="java.util.Iterator"%> --%>
<%-- <%@page import="model.Book"%> --%>
<%-- <%@page import="model.Author"%> --%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="js/jquery-1.9.1.js"></script>
<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js"></script>


</head>
<body>
	<div id="centered">
		<jsp:include page="header.jsp" flush="true" />
		<jsp:include page="leftColumn.jsp" flush="true" />
		
		<br>
		<br>
		<div>
			<span class="sub-heading">Search by Brands</span>
		</div>
		<br>
		
		<c:forEach var="category" items="${categories}">
			<button type="button" onclick="searchByCategory('${category}')">${category.prodType}</button>
        </c:forEach> 

		<jsp:include page="list.jsp" flush="true" />
		
 
	</div>
</body>
</html>