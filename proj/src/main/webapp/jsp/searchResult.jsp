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
	
		<c:choose>
		
			<c:when test="${empty searchResponse}">
				<div>
					<p class="big-par"> Your search for ${keyWord} returned no results. Try Again</p>			
				</div>
			
			</c:when>
			
			<c:otherwise>
				<span class="big-par">Search Results</span>
				
				<div class="grid">
					<c:forEach var="item" items="${searchResponse}" varStatus="loop">
						<div class="card" id="product-${loop.index}">
							<div class="prodIm">
								<img class="category-image" src="${url[item.prodType]}" alt="Product Image" data-category="${item.prodType}">
			
							</div>
							<p>
								<span class="header-featured">${item.prodName}</span> <span
									class="info-featured">${item.prodInfo}</span> <span
									class="info-featured">$${item.price}</span> <span
									class="info-featured">Quantity remaining:
									${item.quantityAvail}</span>
							</p>
							<input class="featured-add-button" type="submit" value="ADD TO CART">
						</div>
					</c:forEach>
				</div>
			</c:otherwise>
			
		</c:choose>

	</div>

</body>
</html>

