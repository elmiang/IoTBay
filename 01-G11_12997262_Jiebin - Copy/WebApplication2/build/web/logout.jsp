<%-- 
    Document   : logout
    Created on : 2020-4-30, 23:49:56
    Author     : AAKK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <h1>You have been logged out, click<a href="index.jsp"> here </a>to go back to home page.</h1>
        <% session.invalidate(); %>
    </body>
</html>
