<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div id="centered">

		<div>
			<jsp:include page="UserDashboard.jsp" flush="true" />
		</div>
		<br> <br>
		
		<div>
			<table class="inventory-table">
				<tr class="inventory-table-heading">
					<td class="inventory-table-heading-col">CUST. ID</td>
					<td class="inventory-table-heading-col">FIRST NAME</td>
					<td class="inventory-table-heading-col">LAST NAME</td>
					<td class="inventory-table-heading-col-addr">STREET</td>
					<td class="inventory-table-heading-col-addr">PROVINCE</td>
					<td class="inventory-table-heading-col-addr">COUNTRY</td>
					<td class="inventory-table-heading-col-addr">POSTAL CODE</td>
					<td class="inventory-table-heading-col-addr">TEL.</td>
					<td></td>
				</tr>
				<c:forEach var="cust" items="${customers}">

					<tr class="inventory-table-data">
						<td class="inventory-table-data-col">${cust.id}</td>
						<td class="inventory-table-data-col">${cust.firstName}</td>
						<td class="inventory-table-data-col">${cust.lastName}</td>
						<td class="inventory-table-data-col">${cust.street}</td>
						<td class="inventory-table-data-col">${cust.province}</td>
						<td class="inventory-table-data-col">${cust.country}</td>
						<td class="inventory-table-data-col">${cust.postal}</td>
						<td class="inventory-table-data-col">${cust.phone}</td>
						<td class="inventory-table-data-col">MORE</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="footer.jsp" flush="true" />
	</div>

</body>
</html>