<%-- 
    Document   : main
    Created on : Apr 6, 2020, 6:02:11 PM
    Author     : jacks
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">

    </head>
    <body>

        <%
            User user = (User) session.getAttribute("user");
        %>
        <div class="container-fluid">
            <h1>Welcome to the IoTBay Web Store</h1>
            <p>You are currently logged in as ${user.FName} ${user.LName}, &lt${user.email}&gt</p>
            <a href="logout.jsp" class="btn btn-secondary">Logout</a>
        </div>
    </body>
</html>
