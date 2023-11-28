<%@page language="java" contentType="text/html" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/bookstore.css" type="text/css" />
<script src="js/bookstore.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>


<ul class="main-menu-list">
	<li class="main-menu-list-link"><a href="${initParam.param1}">HOME</a></li>
	<li class="main-menu-list-link">|</li>
	<li class="main-menu-list-link"><a href="${initParam.param1}?action=allBooks">SHOP ALL</a></li>
	<li class="main-menu-list-link">|</li>
	<li class="main-menu-list-link"><a href="${initParam.param1}?action=category">SHOP CATEGORIES</a></li>
	<li class="main-menu-list-link">|</li>
	<li class="main-menu-list-link"><a href="${initParam.param1}?action=brands">SHOP BRANDS</a></li>
</ul>

