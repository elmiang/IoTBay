<%-- 
    Document   : cart
    Created on : 24/05/2020, 8:46:44 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Cart</title>
        <script type="text/javascript">
			function showMessage(){
				alert("Your Order has been saved.");
			}
		</script>
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
        
        <%
            String name = request.getParameter("name");
            
        %>
        
        
        <main class="main-content">
            <h2>${user.name}'s Cart </h2>
            <table class="table">
              <thead class="thead-dark">
                <tr>
                  <th scope="col"></th>
                  <th scope="col">Product Name</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Price</th>
                  <th scope="col">Actions</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="cart" items="${ShoppingCart.cart}">
                <tr>
                  <th scope="row"></th>
                  <td><c:out value="${cart.productName}" /></td>
                  <td><input type="text" name="quantity" value="<c:out value="${ShoppingCart.quantity}"/>"</td>
                  <td><fmt:formatNumber type="currency" value="${cart.price}" /></td>
                  <td><a href="CartRemoveServlet?productName=<c:out value = "${cart.productName}"/>">Remove</a></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            
            <table class="table">
            <thead class="thead-dark">
                <tr>
                  <th scope="col"></th>
                  <th scope="col">Order Summary</th>
                </tr>
            </thead>
            
            <tbody>
                <tr>
                  <th scope="row"></th>
                  <td>Number of Items: (Amount of Items)</td>
                </tr>
                <tr>
                  <th scope="row"></th>
                  <td>Total: (Cost of Items)</td>
                </tr>
                <tr>
                  <th scope="row"></th>
                  <td>Shipping: (Cost of Shipping)</td>
                </tr>
                
                <tr>
                  <th scope="row"></th>
                  <td>Grand Total: (Grand Total)</td>
                </tr>
            </tbody>
            </table>
            <a class="button" href="OrderAddServlet?productName=<c:out value = "${product.productName}"/>" onclick="showMessage()">Save Order</a>
            <a class="button" href="checkout.jsp">Continue </a>
            
            
        </main>
    </body>
</html>
