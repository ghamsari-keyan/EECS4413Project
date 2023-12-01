<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
        function ascendingPrice() {
            var items = $(".card");
            items.sort(function(a, b) {
                var priceA = $(a).data("price");
                var priceB = $(b).data("price");
                return priceA - priceB;
            });
            $(".grid").html(items);
        }

        function descendingPrice() {
            var items = $(".card");
            items.sort(function(a, b) {
                var priceA = $(a).data("price");
                var priceB = $(b).data("price");
                return priceB - priceA;
            });
            $(".grid").html(items);
        }

        function alphabetical() {
            var items = $(".card");
            items.sort(function(a, b) {
                var nameA = $(a).find(".header-featured").text().toUpperCase();
                var nameB = $(b).find(".header-featured").text().toUpperCase();
                return (nameA < nameB) ? -1 : (nameA > nameB) ? 1 : 0;
            });
            $(".grid").html(items);
        }
    </script>
</head>
<body>


	<div>
		<c:if test="${param.category != null}">
			<span class="label"> SHOP ALL</span>
		</c:if>
	</div>
	<br>

	<div>
		<button onclick="alphabetical()">Sort Products Alphabetically</button>
		<button onclick="ascendingPrice()">Sort Products by Ascending
			Price</button>
		<button onclick="descendingPrice()">Sort Products by
			Descending Price</button>
	</div>

	<!-- Product display for all products in our inventory -->
	<div class="grid">
		<c:forEach var="item" items="${inventory}">
			<div class="card" data-price="${item.price}">
				<div class="prodIm"></div>
				<p>
					<span class="header-featured">${item.prodName}</span> <span
						class="info-featured"> ${item.prodInfo}</span> <span
						class="info-featured">$${item.price}</span>
				</p>
				<input class="featured-add-button" type="submit" value="ADD TO CART">
			</div>
		</c:forEach>
	</div>

</body>
</html>