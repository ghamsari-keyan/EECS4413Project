<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/bookstore.css" type="text/css" />

<ul class="nav_ul">
	<li class="nav-companyName"><a>CPU4U</a></li>
	<li class="navLi"><a href="${pageContext.request.contextPath}/sign-in-admin.html"> Admin Login</a></li>
	<li class="navLi"><a href="${pageContext.request.contextPath}/sign-in.html">Sign In</a></li>
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