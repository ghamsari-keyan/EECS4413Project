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
		
		
		<form method="post" action="adminLogin?action=submitNewProd">
		
			<p style="color:white">Model: <input type="text" name="prodName" class="input-field"></p>
			<p style="color:white">Make: <input type="text" name="prodMake" class="input-field"></p>
			<p style="color:white">Category: <input type="text" name="cat" class="input-field"></p>
			<p style="color:white">Version: <input type="text" name="prodVers" class="input-field"></p>
			<p style="color:white">Platform Compatibility <input type="text" name="platform" class="input-field"></p>
			<p style="color:white">Info: <input type="text" name="info" class="input-field"></p>
			<p style="color:white">Price: ($CAD) <input type="text" name="price" class="input-field"></p>
			<p style="color:white">Rating (add default feature here): <input type="text" name="rating" class="input-field"></p>
			<p style="color:white">Quantity To Add: <input type="text" name="qty" class="input-field"></p>
			<p style="color:white">Eco-Friendly? <input type="text" name="eco" class="input-field"></p>
			<p style="color:white">Weight: <input type="text" name="weight" class="input-field"></p>	
			<p style="color:white">Database ID: <input type="text" name="id" class="input-field"></p>
			
			<input type="submit" value="submitNewProd">
			
		</form>
		
		
		
	</div>

</body>
</html>