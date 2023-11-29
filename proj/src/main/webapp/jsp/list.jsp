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
			<span class="label"> SHOP ALL</span>
		</c:if>
	</div>
	<br>

	<!-- Product display for all products in our inventory -->
	<div class="grid">
		<c:forEach var="item" items="${inventory}">	
			<div class="card">
					<div class="prodIm"></div>
						<p><span class="header-featured">${item.prodName}</span>				
						<span class="info-featured"> ${item.prodInfo}</span>
						<span class="info-featured">${item.price}</span>
					</p>
					
					<input class="featured-add-button" type="submit" value="ADD TO CART">
				</div>
		</c:forEach>
	</div>
	
</body>
</html>

