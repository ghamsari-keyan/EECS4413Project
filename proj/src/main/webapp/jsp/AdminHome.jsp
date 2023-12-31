<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div id = "centered">
		
		<div>
			<jsp:include page="AdminDashboard.jsp" flush="true"/>
		</div>
		
		<h1 class="admin-dash-p">LATEST UPDATES</h1>
		<div class="the-latest">
		
			
			<div class="left-side-admin">		
				
				<div class="latest-div">
				
					<span class="latest-header">Inventory Changes</span>
					<div class="latest-prods">
						<p class="latest-p">New Additions</p>
						<div class="latest-prod-additions">
							<p class="latest-prod-additions-info"><span style="text-transform:uppercase"><b>${inventory[0].prodName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: black"><b>${inventory[0].brandName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)"><i>Qty Added: </i>${inventory[0].quantityAvail}</span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)">*Date Added*</span></p>
						</div>				
						<br>
						<div class="latest-prod-additions">
							<p class="latest-prod-additions-info"><span style="text-transform:uppercase"><b>${inventory[1].prodName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: black"><b>${inventory[1].brandName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)"><i>Qty Added: </i>${inventory[1].quantityAvail}</span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)">*Date Added*</span></p>
						</div>
						<br>
						<div class="latest-prod-additions">
							<p class="latest-prod-additions-info"><span style="text-transform:uppercase"><b>${inventory[2].prodName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: black"><b>${inventory[2].brandName}</b></span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)"><i>Qty Added: </i>${inventory[2].quantityAvail}</span></p>
							<p class="latest-prod-additions-info"><span style="color: rgb(48, 25, 52)">*Date Added*</span></p>
						</div>						
					</div>
				</div>
				
				<div class="latest-div">
					<span class="latest-header">New Customers</span>
					<div class="latest-prods">
						<p class="latest-p">New Additions</p>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><b>${customers[0].lastName}, ${customers[0].firstName}</b></p>
							<p class="latest-prod-additions-info"><span style="color:grey">tel. ${customers[0].phone}</span></p>
						</div>				
						<br>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><b>${customers[1].lastName}, ${customers[1].firstName}</b></p>
							<p class="latest-prod-additions-info"><span style="color:grey">tel. ${customers[1].phone}</span></p>
						</div>
					</div>
				
				</div>
			</div>
			
			<div class="right-side-admin">
			
				<div>
					<span class="latest-header">Recent Orders</span>
					
					<div class="latest-prods">
						<p class="latest-p">New Additions</p>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><span style="font-size: 24px"><b>ORDER ID: ${purchases[0].purchaseId}</b></span></p>
							<p class="latest-prod-additions-info">CONTENT: ${orderItms[0]}</p>
							<p class="latest-prod-additions-info"><span style="color:grey">SIZE: ${purchases[0].orderSize}</span></p>
							
							<p class="latest-prod-additions-info"><span style="color:grey"><i>cust</i> ${purchases[0].customerId}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey">${purchases[0].date}</span></p>
						</div>				
						<br>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><span style="font-size: 24px"><b>ORDER ID: ${purchases[1].purchaseId}</b></span></p>
							<p class="latest-prod-additions-info">CONTENT: ${orderItms[1]}</p>
							<p class="latest-prod-additions-info"><span style="color:grey">SIZE: ${purchases[1].orderSize}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey"><i>cust</i> ${purchases[1].customerId}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey">${purchases[1].date}</span></p>
						</div>
						<br>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><span style="font-size: 24px"><b>ORDER ID: ${purchases[2].purchaseId}</b></span></p>
							<p class="latest-prod-additions-info">CONTENT: ${orderItms[2]}</p>
							<p class="latest-prod-additions-info"><span style="color:grey">SIZE: ${purchases[2].orderSize}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey"><i>cust</i> ${purchases[2].customerId}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey">${purchases[2].date}</span></p>
						</div>
						<br>
						<div class="latest-prod-additions" style="background:none;border-width:3px">
							<p class="latest-prod-additions-info"><span style="font-size: 24px"><b>ORDER ID: ${purchases[3].purchaseId}</b></span></p>
							<p class="latest-prod-additions-info">CONTENT: ${orderItms[3]}</p>
							<p class="latest-prod-additions-info"><span style="color:grey">SIZE: ${purchases[3].orderSize}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey"><i>cust</i> ${purchases[3].customerId}</span></p>
							<p class="latest-prod-additions-info"><span style="color:grey">${purchases[3].date}</span></p>
						</div>
					</div>
				
				</div>
			</div>
		
		</div>
		<div>
			<br>
			<br>
			<jsp:include page="footer.jsp" flush="true"/>
		</div>
		
	</div>
</body>
</html>