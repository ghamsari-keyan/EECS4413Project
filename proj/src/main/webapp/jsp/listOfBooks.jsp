<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

 
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
	<div id="centered">

		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumn.jsp" flush="true" />
		
		<br>
		<br>
		<div>
			<span class="sub-heading" style="margin-left: 15px;">Inventory Management</span>
		</div>

		<jsp:include page="list.jsp" flush="true" />
		
		<br>
		<br>
		
		<p class="info-par">This is a comprehensive display of all the products in our database. Functionality for changing the database will be added soon.</p>


	</div>


</body>
</html>

