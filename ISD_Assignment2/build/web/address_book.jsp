<%-- 
    Document   : address_book
    Created on : 01/06/2020, 5:30:08 AM
    Author     : CristinaFidelino
--%>

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
        <h1>Address Book</h1><br>
        
        <div class="sidenav">
            <a href="main.jsp">Account Summary</a>
            <a href="order_history.jsp">Order History</a>
            <a href="#">Address Book</a>
            <a href="card_details.jsp">Card Details</a>
        </div>
        
        <p class="p instructions"> You have no Addresses Saved</p>
            <div style="text-align: center;">
                <a class="button" href="edit.jsp"> Add New Address </a>
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