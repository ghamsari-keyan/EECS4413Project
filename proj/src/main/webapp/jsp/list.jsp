<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
List<String> imageUrls = new ArrayList<>();
/* imageUrls.add("images/Laptop.png"); */
/* imageUrls.add("images/Desktop.png"); */
/* imageUrls.add("images/Monitor.png"); */
/* imageUrls.add("images/Keyboard.png"); */
/* imageUrls.add("images/Mouse2.png"); */
/* imageUrls.add("images/Headphones.png"); */
/* imageUrls.add("images/Speaker.png"); */
/* imageUrls.add("images/Tablet.png"); */
/* imageUrls.add("images/Router.png"); */
/* imageUrls.add("images/Printer.png"); */
/* imageUrls.add("images/Scanner.png"); */
/* imageUrls.add("images/Webcam.png"); */
/* imageUrls.add("images/External Drive.png"); */
imageUrls.add("images/Graphics Card.png");
imageUrls.add("images/RAM.png");



request.setAttribute("imageUrls", imageUrls);
%> --%>

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
    
    function addToCart(event, itemId) {
        event.preventDefault(); // Prevent the default form submission

        var quantity = $(event.target).find("input[name='quantity']").val();

        $.ajax({
            url: "<%= request.getContextPath() %>/cartServlet",
            type: "POST",
            data: {
                action: "addToCart",
                itemId: itemId,
                quantity: quantity
            },
            success: function(response) {
                alert("Item added to cart successfully!");
                // Update the cart display or quantity here
            },
            error: function() {
                alert("Error adding item to cart.");
            }
        });
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
                    <img src="${item.getImUrl()}" alt="Product Image ${loop.index}" />
                </div>
                <p>
                    <span class="header-featured">${item.prodName}</span> 
                    <span class="info-featured"> ${item.prodInfo}</span> 
                    <span class="info-featured">Price: $${item.price}</span> 
                    <span class="info-featured">Quantity remaining: ${item.quantityAvail}</span>
                </p>
                <form onsubmit="addToCart(event, '${item.itemId}')">
                        <input type="hidden" name="itemId" value="${item.itemId}">
                        <input type="number" name="quantity" value="1" min="1" max="10">
                        <input type="submit" value="ADD TO CART" class="featured-add-button">
               	</form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
