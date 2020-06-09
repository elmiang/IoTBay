<%-- 
    Document   : profileTable
    Created on : 06/06/2020, 7:30:17 PM
    Author     : marti
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Profile Table</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        <h1>User Dashboard</h1>
        <p class="p">You are logged in as ${user.email}</p><br>
            <table id="profile_table">
                <tr>
                <thead><th>Name</th><th>Email</th><th>Password</th><th>DOB</th><th>Gender</th><th>Address</th><th>Postcode</th><th>Phone Number</th></thead>
                </tr>
            <tr><td>${user.name}</td><td>${user.email}</td><td>${user.password}</td><td>${user.dob}</td><td>${user.gender}</td><td>${user.address}</td><td>${user.postcode}</td><td>${user.phoneNumber}</td></tr>
            </table>
        <div style="text-align: center;">
            <form method="post" action="EditServlet">
                <input type ="hidden" name="email" value="${user.email}"/>
                <input type ="hidden" name="password" value="${user.password}"/>
                <input class="button" type="submit" value="Edit"/>
            </form>
        </div>
    </body>
</html>
