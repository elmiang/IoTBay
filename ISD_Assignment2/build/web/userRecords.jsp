<%-- 
    Document   : userRecords
    Created on : 06/06/2020, 7:28:42 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/IoTBay.css">
        <title>User Management</title>
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
            <a href="URServlet" style="float: right;">User Management</a>
        </div>
        <h1>User Management</h1>
         
           
           
        
    </body>
</html>
