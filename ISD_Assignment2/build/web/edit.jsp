<%-- 
    Document   : edit
    Created on : 30/04/2020, 6:48:21 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Edit</title>
    </head>
    
    <body>
        
        <%
            String updated = (String) session.getAttribute("updated");
            String existErr = (String) session.getAttribute("existErr");
        %>
        
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
             <div class="greeting">
                 <h1>Edit Account Information</h1> <span><%=(updated != null ? updated : "")%></span>
        </div>
        
        <form method="post" action="UpdateServlet"/>
            <h2 class="h2 instructions">Account Settings</h2>
        
            <p class="p instructions">Personal Information</p><span><%=(existErr != null ? existErr : "")%></span>
            
            <label for="name">Name</label>
            <input id="name" name="name" type="text" placeholder="Full Name" value = "${user.name}"/>
            <label for="email">Email address</label>
            <input id="email" name="email" placeholder="Email address" value ="${user.email}"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" value = "${user.password}"/>
            
            <h4 class="gender">Gender:</h4>
            <div class="gender-labels">
                <label for="male">Male</label>
                <input type="radio" id="male" name="gender" value="m"/>
                <label for="female">Female</label>
                <input type="radio" id="female" name="gender" value="f"/>
            </div>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" name="dob" id="dob" value = "${user.dob}">
            <label for="address">Address</label>
            <input id="address" name="address" type="text" placeholder="Address" value = "${user.address}"/>
            <label for="postcode">Postcode</label>
            <input id="postcode" name="postCode" type="text" placeholder="Postcode" value ="${user.postcode}"/>
            <label for="phoneNumber">Phone Number</label>
            <input id="phoneNumber" name="phoneNumber" type="tel"  placeholder="1234-567-890" value = "${user.phoneNumber}"/>
            
            <input class="button" type="submit" value="Update"/><br>
            <p class="p instructions">Return to the <a class="p"href = "main.jsp">main page</a> </p>
            <input type ="hidden" name="update" value="Updated">

        </form>
        </main>
        
    </body>
</html>
