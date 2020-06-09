<%-- 
    Document   : Order
    Created on : Jun 6, 2020, 7:03:17 PM
    Author     : SOMESH
--%>
<%@page import="ISD.Assignment.Model.Order"%>
<%@page import="ISD.Assignment.Model.OrderLineItem"%>
<%@page import="ISD.Assignment.Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Orders Page</title>
        <script type="text/javascript">
			function showMessage(){
				alert("Your Order has been deleted.");
			}
		</script>
    </head>
    <body>
        
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
        </ul>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">All Products</a>
            <a style="float: left;">Kits</a>
            <a style="float: left;">Parts</a>
            <a style="float: left;">Sensors</a>
            <a style="float: left;">Your Order</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        <a class="button" href="OrderServlet">Your Order History</a>
        
        <div>
            
            
        </div>
        
        <h1>Saved Orders</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Order No</th>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Date</th>                  
                    <th>Status</th>
                    <th>Actions</th>
                </tr>    
            </thead>
            
            <tbody>
                <c:forEach var="cart" items="${ShoppingCart.cart}">
                
                <tr>
                    <td><c:out value="${order.orderID}"/></td>
                    <td><c:out value="${cart.productName}" /></td>
                    <td><c:out value="${ShoppingCart.quantity}"/>"</td>
                    <td><c:out value="${cart.price}" /></td>
                    <td><c:out value="${order.orderDate}"/></td>
                    <td><c:out value="${order.orderStatus}"/></td>
                    <td><a href="CartAddServlet?productName=<c:out value = "${product.productName}"/>">Update Order</a>
                        <br><a href="OrderRemoveServlet" onclick="showMessage()">Delete Order</a></td>
                </tr>
                </c:forEach>
                
            </tbody>
            
            
        </table>
    </body>
    
</html>
