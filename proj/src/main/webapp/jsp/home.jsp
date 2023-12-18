<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

request.setAttribute("imageUrls", imageUrls);
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/bookstore.css" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script>
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
    <div id="centered">
        <!-- Header and Left Column Includes -->
        <div><jsp:include page="header.jsp" flush="true" /></div>
        <div><jsp:include page="leftColumn.jsp" flush="true" /></div>

        <br><br>
        <span class="big-par">Featured Products, on-sale Limited Offers!</span><br><br>

        <!-- Featured Products -->
        <div class="grid">
        <c:forEach var="item" items="${featured}" varStatus="loop">
            <div class="card" data-price="${item.price}">
                <div class="prodIm">
                    <img src="${imageUrls[loop.index]}" alt="Product Image ${loop.index}" />
                </div>
                <p>
                    <span class="header-featured">${item.prodName}</span> 
                    <span class="info-featured"> ${item.prodInfo}</span> 
                    <span class="info-featured">Price: $${item.price}</span> 
                    <span class="info-featured">Quantity remaining: ${item.quantityAvail}</span>
                </p>
                <form onsubmit="addToCart(event, '${item.itemId}')">
                        <input type="hidden" name="itemId" value="${item.itemId}">
                        <input type="number" name="quantity" value="1" min="1" max="${item.quantityAvail}">
                        <input type="submit" value="ADD TO CART" class="featured-add-button">
               	</form>
            </div>
        </c:forEach>
    	</div>

        <br><br><br>
        <!-- Footer Include -->
        <div><jsp:include page="footer.jsp" flush="true" /></div>
    </div>
</body>
</html>
