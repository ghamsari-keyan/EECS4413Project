<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.getProtocol();%>

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


		<br>
		<div>
			<span class="admin-dash-p"><b>USER DASHBOARD</b></span>
		</div>
		<div>
			<br>
		</div>

		<div>
			<span class="big-par">Welcome, ${sessionScope.name} </span> <br>
			<br>
		</div>
		<br> <br> <br>

	</div>
</body>
</html>