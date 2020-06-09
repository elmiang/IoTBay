<%-- 
    Document   : main
    Created on : 28/04/2020, 11:09:52 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Main</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        <% if (user != null) { %>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="LogoutServlet"> Logout </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
        </ul>
        </div>
        
        <div class="topnav">
             <a href="index.jsp"style="float: left;">Home</a>
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreServlet" style="float: left;">Kits</a>
            <a href="StoreServlet" style="float: left;">Parts</a>
            <a href="StoreServlet" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
        <h1>Account Summary</h1><br>
        
        <div class="sidenav">
            <a href="#">Account Summary</a>
            <a href="order_history.jsp">Order History</a>
            <a href="address_book.jsp">Address Book</a>
            <a href="card_details.jsp">Card Details</a>
            <a href="PaymentServlet">Payment History</a>
            <a href="AccessLogServlet">Access Log</a>
            <a href="AllShipmentsServlet">Shipment</a>
            <c:if test="${user.role == 'admin'}">
                <a href="URServlet">User Management</a>
            </c:if>
            <a href="accDelete.jsp">Delete Account</a>
        </div>
        
        <p class="p">You are logged in as ${user.email}</p><br>
            <table id="profile_table">
                <tr>
                <thead><th>Name</th><th>Email</th><th>Password</th><th>DOB</th><th>Gender</th><th>Address</th><th>Postcode</th><th>Phone Number</th></thead>
                </tr>
            <tr><td>${user.name}</td><td>${user.email}</td><td>${user.password}</td><td>${user.dob}</td><td>${user.gender}</td><td>${user.address}</td><td>${user.postcode}</td><td>${user.phoneNumber}</td></tr>
            </table>
            
            <div style="text-align: center;">
                <a class="button" href="edit.jsp"> Edit </a>
            </div>
        </main>
            
        <% }  else { %>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
        </ul>
        </div>
        
        <div class="topnav">
             <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">All Products</a>
            <a style="float: left;">Kits</a>
            <a style="float: left;">Parts</a>
            <a style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
            <p class="p instructions">You must be logged in to do that</p>
            
            <div style="text-align: center;">
                <a class="button center" href="login.jsp"> Login </a>
            </div>
            
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        <% } %>
        
    </body>
</html>
