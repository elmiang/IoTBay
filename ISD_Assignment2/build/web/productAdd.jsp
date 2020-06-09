<%-- 
    Document   : productAdd
    Created on : May 31, 2020, 2:45:14 PM
    Author     : jacks
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
          <c:if test="${user == null}">
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          </c:if>
          <c:if test="${user != null}">
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="main.jsp"> Account </a></li>
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="LogoutServlet"> Logout </a></li>
          </c:if>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreCategoryServlet?type=motor" style="float: left;">Motors</a>
            <a href="StoreCategoryServlet?type=display" style="float: left;">Displays</a>
            <a href="StoreCategoryServlet?type=sensor" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
        <c:if test="${oName != null}">
            <h1>Edit Product</h1>
            <form action="StoreUpdateServlet?oName=<c:out value="${oName}"/>" method="post">
        </c:if>
        
        <c:if test="${oName == null}">
            <h1>Add Product</h1>
            <form action="StoreAddServlet" method="post">
        </c:if>
            <table>
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="productName" placeholder="Insert product name..."/>
                    </td>
                </tr>
                <tr>
                    <th>Type</th>
                    <td>
                        <input type="text" name="productType" placeholder="Insert product type..."/>
                    </td>
                </tr>
                <tr>
                    <th>Quantity</th>
                    <td>
                        <input type="text" name="productQuantity" placeholder="Insert product quantity..."/>
                        <span>${quantityErr}</span>
                    </td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td>
                        <input type="text" name="productPrice" placeholder="Insert product price..."/>
                        <span>${priceErr}</span>
                    </td>
                </tr>
                
                <tr>
                    <th></th>
                    <td>
                        <a href="StoreServlet" class="button">Back</a>
                        <input type="submit" value="Save" class="button"/>
                    </td>
                </tr>
            </table>
            </form>
        </main>
    </body>
</html>
