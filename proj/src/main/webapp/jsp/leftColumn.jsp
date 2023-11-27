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
	<li class="main-menu-list-link"><a href="">SHOP CATEGORIES</a></li>
	<li class="main-menu-list-link">|</li>
	<li class="main-menu-list-link"><a href="${initParam.param1}?action=brands">SHOP BRANDS</a></li>
</ul>



<%-- <div class="leftbar">
    <ul id="menu">
        <li>
            <div>
                <a class="link1" href="${initParam.param1}">
                    <span class="label" style="margin-left: 5px;">Home</span>
                </a>
            </div>
        </li>
        <li>
            <div>
                <a class="link1" href="${initParam.param1}?action=allBooks">
                    <span style="margin-left: 5px;" class="label">All Products</span>
                </a>
            </div>
        </li>
        <li>
            <div>
                <span class="label" style="margin-left: 5px;">Categories</span>
            </div>
            <ul>
                <c:forEach items="${categoryList}" var="item">
                    <li>
                        <a class="label"
                            href="${initParam.param1}?action=category&categoryId=${item.id}&category=${item.categoryDescription}">
                            <span class="label" style="margin-left: 20px;">
                                ${item.categoryDescription}
                            </span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li>
            <div>
                <span class="label" style="margin-left: 5px;">Brands</span>
            </div>
            <ul>
                <!-- Add your brand options here -->
                <li>
                    <a class="label" href="#">
                        <span class="label" style="margin-left: 20px;">Brand 1</span>
                    </a>
                </li>
                <li>
                    <a class="label" href="#">
                        <span class="label" style="margin-left: 20px;">Brand 2</span>
                    </a>
                </li>
                <!-- Add more brands as needed -->
            </ul>
        </li>
    </ul>

    <form class="search">
        Search: <input type="hidden" name="action" value="search" /> <input id="text" type="text" name="keyWord" size="12" />
        <span class="tooltip_message">?</span>
        <p />
        <input id="submit" type="submit" value="Search" />
    </form>
</div> --%>
