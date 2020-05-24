<%-- 
    Document   : main
    Created on : 28/04/2020, 11:09:52 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Account Summary</h1><br>
        
        <div class="dropdown">
                <button class="dropbtn">My Account</button>
                <div class="dropdown-content">
                    <a href="#">Order History</a>
                    <a href="#">Address Book</a>
                    <a href="#">Card Details</a>
                </div>
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
            
           
  </div>
</div>
            
        <% }  else { %>
            <p class="p">You are not logged in</p>
            <a class="p" href="login.jsp"> Login </a>
            <a class="p" href="register.jsp"> Register </a>
        <% } %>
        </main>
    </body>
</html>
