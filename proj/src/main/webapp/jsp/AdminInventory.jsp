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
<script src="js/bookstore.js" type="text/javascript"></script>

</head>

<body>

	<div id = "centered">
		
		<div>
			<jsp:include page="AdminDashboard.jsp" flush="true"/>
		</div>
				
		<div>
		
		
			<div>
				<ul class="admin-dash" style="width:fit-content">
					<li class="admin-dash-list" style="padding:0;border:1px solid white"><a class="admin-dash-list-link" style="font-size:14px" href="adminLogin?action=addProduct">Add Product</a></li>
				</ul>
			</div>
	
			<br>
			<br>
			<br>
				
			<!-- Here we are setting up an inventory table -->
			<table class="inventory-table">
				<tr class="inventory-table-heading">
					<td class="inventory-table-heading-col">ID</td>
					<td class="inventory-table-heading-col">Name</td>
					<td class="inventory-table-heading-col">Brand</td>
					<td class="inventory-table-heading-col">Category</td>
					<td class="inventory-table-heading-col">Version</td>
					<td class="inventory-table-heading-col">Platform</td>
					<td class="inventory-table-heading-col">Rating</td>
					<td class="inventory-table-heading-col">Price</td>
					<td class="inventory-table-heading-col">Current Inventory</td>
					<td class="inventory-table-heading-col">Eco-Friendly</td>
					<td class="inventory-table-heading-col">Weight</td>
					<td class="inventory-table-heading-col"></td>
				</tr>
				
				<c:forEach var="prod" items="${inventory}">
					<tr class="inventory-table-data">
						<td class="inventory-table-data-col">${prod.itemId}</td>
						<td class="inventory-table-data-col">${prod.prodName}</td>
						<td class="inventory-table-data-col">${prod.brandName}</td>
						<td class="inventory-table-data-col">${prod.prodType}</td>
						<td class="inventory-table-data-col">${prod.prodVersion}</td>
						<td class="inventory-table-data-col">${prod.prodPlatform}</td>
						<td class="inventory-table-data-col">${prod.rating}</td>
						<td class="inventory-table-data-col">${prod.price}</td>
						<td class="inventory-table-data-col">${prod.quantityAvail}</td>
						<td class="inventory-table-data-col">${prod.ecoFriendly}</td>
						<td class="inventory-table-data-col">${prod.weight}</td>
						<td class="inventory-table-data-col"><a href="adminLogin?action=edit${prod.itemId}">edit item</a></td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	

</body>
</html>