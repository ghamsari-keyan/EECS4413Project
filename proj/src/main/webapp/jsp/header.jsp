<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/bookstore.css" type="text/css" />

<ul class="nav_ul">
	<li class="nav-companyName"><a><b>CPU4U.com</b></a></li>
	<li class="search-bar">
        <form class="search" action="${pageContext.request.contextPath}/jsp/searchResult.jsp" method="get">
			<input type="hidden" name="action" value="search"/> 
			<input id="text" type="text" name="keyWord" size="12" placeholder="Search Store by Product ID, name, category, brand, etc" />
       		<input id="submit" type="submit" value="Search" />
   		</form>
	</li>
	
	<li class="navLi"><a href="${pageContext.request.contextPath}/sign-in-admin.html">ADMIN</a></li>
	<li class="navLi"> | </li>
	<li class="navLi"><a href="${pageContext.request.contextPath}/sign-in.html">SIGN IN</a></li>
</ul>

<ul class="nav_ul">
    <li class="main-menu-list-link"><a href="${pageContext.request.contextPath}/jsp/cart.jsp?action=cart">SHOPPING CART</a></li>
</ul>

<%-- <div style="width:100%;display:table;border:1px solid white;">
	<div style="dislpay:table-row;"> 
		<div style="width:80%; display:table-cell; border:1px solid white;">
		    <h1>
		        <span class="label_title">CPU4U</span>
		    </h1>
		</div>
		<div style="display:table-cell;border:1px solid white;">
            <a href="${pageContext.request.contextPath}/sign-in.html">Customer Login |</a>             
            <a href="${pageContext.request.contextPath}/sign-in-admin.html">Admin Login</a> 
		</div>
	</div>
</div>
 --%>