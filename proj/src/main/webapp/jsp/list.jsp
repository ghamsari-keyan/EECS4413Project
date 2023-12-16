<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<String> imageUrls = new ArrayList<>();
imageUrls.add("images/laptop.png");
imageUrls.add("images/desktop.png");
imageUrls.add("images/monitor.png");
imageUrls.add("images/keyboard.png");
imageUrls.add("images/mouse2.png");
imageUrls.add("images/headphones.png");
imageUrls.add("images/speaker.png");
imageUrls.add("images/tablet.png");
imageUrls.add("images/router.png");
imageUrls.add("images/printer.png");
imageUrls.add("images/scanner.png");
imageUrls.add("images/webcam.png");
imageUrls.add("images/external_drive.png");
imageUrls.add("images/graphics_card.png");
imageUrls.add("images/ram.png");



request.setAttribute("imageUrls", imageUrls);
%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
    function alphabetical() {
        var items = $(".card");
        items.sort(function(a, b) {
            var nameA = $(a).find(".header-featured").text().toUpperCase();
            var nameB = $(b).find(".header-featured").text().toUpperCase();
            return (nameA < nameB) ? -1 : (nameA > nameB) ? 1 : 0;
        });
        $(".grid").html(items);
    }

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
    
    function submitSearchForm() {
        document.getElementById("searchForm").submit();
    }

</script>
</head>
<body>
    <div>
        <c:if test="${param.category != null}">
            <span class="label"> SHOP ALL</span>
        </c:if>
    </div>
    <br><br><br><br>
    <div style="float: centre; margin-right: 10px;">        
        <button onclick="alphabetical()">Sort Products Alphabetically</button>
        <button onclick="ascendingPrice()">Sort Products by Ascending Price</button>
        <button onclick="descendingPrice()">Sort Products by Descending Price</button>
    </div>

    <!-- Product display for all products in our inventory -->
    <div class="grid">
        <c:forEach var="item" items="${inventory}" varStatus="loop">
            <div class="card" data-price="${item.price}">
                <div class="prodIm">
                    <img src="${imageUrls[loop.index % imageUrls.size()]}" alt="Product Image ${loop.index + 1}" />
                </div>
                <p>
                    <span class="header-featured">${item.prodName}</span> 
                    <span class="info-featured"> ${item.prodInfo}</span> 
                    <span class="info-featured">Price: $${item.price}</span> 
                    <span class="info-featured">Quantity remaining: ${item.quantityAvail}</span>
                </p>
                <form action="${pageContext.request.contextPath}/addToCart" method="post">
                    <input type="hidden" name="itemId" value="${item.itemId}" />
                    <input class="featured-add-button" type="submit" value="ADD TO CART">
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
