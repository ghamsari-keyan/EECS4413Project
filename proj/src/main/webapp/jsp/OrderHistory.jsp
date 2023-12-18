<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.getProtocol();%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script src="js/bookstore.js"></script>
</head>
<body>
	<div id = "centered">
		
		<div>
			<jsp:include page="AdminDashboard.jsp" flush="true"/>
		</div>
		<br>
	
		<c:forEach var="order" items="${purchases}">
		
			<div class="latest-prod-additions" style="background:none;border-width:3px">
				<p class="latest-prod-additions-info"><span style="font-size: 24px"><b>ORDER ID: ${order.purchaseId}</b></span></p>
				<p class="latest-prod-additions-info">CONTENT: ${orderItms[0]}</p>
				<p class="latest-prod-additions-info"><span style="color:grey">SIZE: ${order.orderSize}</span></p>
				
				<p class="latest-prod-additions-info"><span style="color:grey"><i>cust</i> ${order.customerId}</span></p>
				<p class="latest-prod-additions-info"><span style="color:grey">${order.date}</span></p>
			</div>				
			<br>
		
		
		</c:forEach>
	
	
	
	
	
	
	
	</div>

</body>
</html>