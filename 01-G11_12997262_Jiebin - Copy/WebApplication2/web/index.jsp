<%-- 
    Document   : index
    Created on : 2020-4-26, 13:58:36
    Author     : AAKK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <h1>Welcome to IoTBay</h1>
        <div>
            <p class="navi">
                <a class="button"  href ="login.jsp">Login</a>
                <a class="button"  href = "register.jsp">Register </a>
                
            </p>
        </div>
        <jsp:include page = "/ConnServlet" flush = "true"/>
    </body>
</html>
