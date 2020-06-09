<%-- 
    Document   : accDelete
    Created on : 09/06/2020, 2:22:16 PM
    Author     : Martin
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Account delete</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
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
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        <h1>Delete Account</h1>
        
        <form method="post" action="AccDelServlet">
                <input type ="hidden" name="email" value="${user.email}"/>
                <input type ="hidden" name="password" value="${user.password}"/>
                <input class="button" type="submit" value="Delete"/>
        </form>
    </body>
</html>
