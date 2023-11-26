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
			<span class="label" style="margin-left: 15px;"> Inventory - For Management ONLY 
			</span>
		</c:if>
	</div>


	<table id="grid">
		<thead>
			<tr>
				<th id="th-type">ID</th>
				<th id="th-name">Name</th>
				<th id="th-category">Category</th>
				<th id="th-brand">Brand</th>
				<th id="th-quantity"></th>
				<th id="th-price">Price ($)</th>
				<th id="th-rating">Rating</th>
				<th id="th-weight">Weight</th>
			</tr>
		</thead>


		<tbody>


			<c:forEach var="item" items="${inventory}">
				<tr>
					<td>${item.itemId}</td>
					<td>${item.prodName}</td>
					
				</tr>
			</c:forEach>



		</tbody>

	</table>
</body>
</html>

