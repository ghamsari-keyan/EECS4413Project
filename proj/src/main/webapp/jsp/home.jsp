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


request.setAttribute("imageUrls", imageUrls);
%>
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
			<jsp:include page="header.jsp" flush="true" />
		</div>

		<div>
			<jsp:include page="leftColumn.jsp" flush="true" />
		</div>
		<br> <br> <span class="big-par">Featured Products,
			on-sale Limited Offers!</span> <br> <br>

		<!-- now we can display some featured products. We can order them according to some 
		specification -->

		<div class="grid">
			<c:forEach var="imageUrl" items="${imageUrls}" varStatus="loop">
				<div class="card">
					<div class="prodIm">
						<img src="${imageUrl}" alt="Product Image ${loop.index + 1}" />
					</div>
					<p>
						<span class="header-featured">PRODUCT ${loop.index + 1}</span> <span
							class="info-featured"> This is a little information about
							the product $500.00 CAD</span>
					</p>
					<form action="<%= request.getContextPath() %>/cartServlet"
						method="post">
						<input type="hidden" name="action" value="addToCart"> <input
							type="hidden" name="itemId" value="${loop.index + 1}"> <input
							type="submit" value="ADD TO CART" class="featured-add-button">
					</form>
				</div>
			</c:forEach>


		</div>

		<br> <br> <br>
		<div>
			<jsp:include page="footer.jsp" flush="true" />
		</div>


		<%-- <table>
			<tr>
				<td><span class="tooltip_img1"><img
						src="${initParam.imageURL}/A9781430248064-small_3.png" /></span></td>
				<td><img src="${initParam.imageURL}/A9781430239963-small_1.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430247647-small_3.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430231684-small_8.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430249474-small_1.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430248187-small_1.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430243779-small_2.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430247401-small_1.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430246596-small_1.png" /></td>
				<td><img src="${initParam.imageURL}/A9781430257349-small_1.png" /></td>
			</tr>
		</table> --%>
	</div>
</body>
</html>