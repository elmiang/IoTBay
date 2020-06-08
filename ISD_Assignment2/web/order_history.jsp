<%-- 
    Document   : order_history
    Created on : Jun 8, 2020, 5:57:01 PM
    Author     : SOMESH
--%>

<%@page import="ISD.Assignment.Model.Order"%>
<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Address Book</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
            Order order =(Order)session.getAttribute("order");
        %>
        
        <% if (user != null) { %>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
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
        <h1>Order History</h1><br>
        
        <div class="sidenav">
            <a href="main.jsp">Account Summary</a>
            <a href="#">Order History</a>
            <a href="address_book.jsp">Address Book</a>
            <a href="card_details.jsp">Card Details</a>
        </div>
        
        <p class="p instructions"> You have no Order History</p>
            <div style="text-align: center;">
                <a class="button" href="products.jsp"> Go Shopping </a>
            </div>
        </main>
        
        
        
        <div> 
            
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