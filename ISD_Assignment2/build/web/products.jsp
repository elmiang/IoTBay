<%-- 
    Document   : products
    Created on : 24/05/2020, 8:29:15 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>All Products</title>
    </head>
    <body>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          <li style="float:right"><a href="cart.jsp"><img class="logo" src="css/cart.png"/></a></li>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreServlet" style="float: left;">Kits</a>
            <a href="StoreServlet" style="float: left;">Parts</a>
            <a href="StoreServlet" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
            <div>
                <form action="SearchServlet" method="get">
                    <input type="text" id="searchText" name="searchText" placeholder="Search.."/>
                </form>
            </div>
            <div>
                <form action="productAdd.jsp" method="post">
                    <input type="submit" class="button" name="addProduct" value="Add"/>
                </form>
            </div>
            <h1>All Products</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
                    <c:forEach var="product" items="${products}">
                    <tr>
                        <td><c:out value="${product.productID}" /></td>
                        <td><c:out value="${product.productName}" /></td>
                        <td><c:out value="${product.productType}" /></td>
                        <td><c:out value="${product.price}" /></td>
                        <td><c:out value="${product.quantity}" /></td>
                        <td>
                            <c:if test="${sessionScope.staff != null}">
                            <a href="StoreEditServlet?oName=<c:out value ="${product.productName}"/>">Edit</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="StoreRemoveServlet?productName=<c:out value ="${product.productName}"/>">Delete</a>
                            &nbsp;&nbsp;&nbsp;
                            </c:if>
                            
                            <c:if test="${sessionScope.staff == null}">
                            <a>Add to Cart</a>
                            </c:if>
                        </td>
                    </tr>
                    </c:forEach>
            </table>
            
        </main>
    </body>
</html>
