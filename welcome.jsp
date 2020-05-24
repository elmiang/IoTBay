<%-- 
    Document   : welcome
    Created on : 28/04/2020, 11:09:42 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Welcome</title>
    </head>
    <body>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
        </ul>
        </div>
        
        <div class="topnav">
            <a style="float: left;">All Products</a>
            <a style="float: left;">Kits</a>
            <a style="float: left;">Parts</a>
            <a style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
        <%
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String postcode = request.getParameter("postcode");
            String phoneNumber = request.getParameter("phoneNumber");
        %>
        
        
        
        <h1>Welcome, <%= name %> </h1>
        <p class="p instructions">Click <a href = "main.jsp">here</a> to proceed to main page </p> <br>
        
        <% 
            User user = new User(userID, email, password, name, dob, gender, address, postcode, phoneNumber);
            session.setAttribute("user",user);
        %>
        </main>
    </body>
</html>
