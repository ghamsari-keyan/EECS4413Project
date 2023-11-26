<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div>
		<c:if test="${param.category != null}">
			<span class="label"> Inventory Management</span>
		</c:if>
	</div>
	<br>

	<div class="inventory_table_div">
		<table class="inv_table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Brand</th>
					<th>Category</th>
					<th>Version</th>
					<th>Platform</th>
					<th>Quantity</th>
					<th>Price ($)</th>
					<th>Rating</th>
					<th>Eco-Friendly</th>
					<th>Weight</th>
				</tr>
			</thead>
	
	
			<tbody>
	
	
				<c:forEach var="item" items="${inventory}">
					<tr>
						<td>${item.itemId}</td>
						<td>${item.prodName}</td>
						<td>${item.brandName}</td>
						<td>${item.prodType}</td>
						<td>${item.prodVersion}</td>
						<td>${item.prodPlatform}</td>
						<td>${item.quantityAvail}</td>
						<td>${item.price}</td>
						<td>${item.rating}</td>
						<td>${item.ecoFriendly}</td>
						<td>${item.weight}</td>
						
						
					</tr>
				</c:forEach>
	
	
	
			</tbody>
	
		</table>
	</div>
</body>
</html>

