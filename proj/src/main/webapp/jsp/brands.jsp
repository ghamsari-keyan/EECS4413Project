<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<span class="big-par">Search by Brands</span>
		</div>
		<br>
		
		<div class="grid">
			<c:forEach var="brand" items="${brandProds}">
				<div class="brandCard">
					<a href="Brand?chooseBrand=${brand}"><span class="header-featured"> ${brand}</span></a>
				
				</div>
			
				
	        </c:forEach> 
	
			
		</div>
		
 
	</div>
</body>
</html>
