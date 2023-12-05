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
		
		<a href="adminLogin?action=inventory">back</a>
		
		<div style="text-align:left">
		
			<form method="post" action="adminLogin?action=submitNewProd" class="add-product">
				
				
				<p style="color:white">MODEL <input id="model" type="text" name="prodName" class="input-field"></p>
				<p style="color:white"> MAKE<input id="make" type="text" name="prodMake" class="input-field"></p>
				<p style="color:white">CATEGORY <input type="text" name="cat" class="input-field"></p>
				<p style="color:white">VERSION <input type="text" name="prodVers" class="input-field"></p>
				<p style="color:white">PLATFORM COMPATIBILITY <input type="text" name="platform" class="input-field"></p>
				<p style="color:white">DESCRIPTION<input type="text" name="info" class="input-field"></p>
				<p style="color:white">PRICE ($CAD) <input type="text" name="price" class="input-field"></p>
				<p style="color:white">RATING (*/5) <input type="text" name="rating" class="input-field"></p>
				<p style="color:white">QUANTITY TO ADD <input type="text" name="qty" class="input-field"></p>
				<p style="color:white">ECO-FRIENDLY? <input type="text" name="eco" class="input-field"></p>
				<p style="color:white">WEIGHT <input type="text" name="weight" class="input-field"></p>	
				<p style="color:white">ID <input type="text" name="id" class="input-field"></p>
				
				<input type="submit" value="submitNewProd">
				
			</form>
		
		</div>
		
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div>
		<jsp:include page="footer.jsp" flush="true"/>
	</div>

</body>
</html>