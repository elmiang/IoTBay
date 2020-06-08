<%-- 
    Document   : index
    Created on : 28/04/2020, 11:09:03 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Index</title>
    </head>
    <body>
        <%-- 
            These are used to test staff and customer roles:
            <c:set var="customer" value="customer" scope="session"/> 
            <c:set var="staff" value="staff" scope="session"/>
        --%>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <c:if test="${user == null}">
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          </c:if>
          <c:if test="${user != null}">
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="logout.jsp"> Logout </a></li>
            <c:out value="${user}"/>
          </c:if>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreCategoryServlet?type=motor" style="float: left;">Kits (Motors)</a>
            <a href="StoreCategoryServlet?type=display" style="float: left;">Parts (Displays)</a>
            <a href="StoreCategoryServlet?type=sensor" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
            <a href="URServlet" style="float: right;">User Management</a>
        </div>
        
        <main class="main-content">
            <p class="p instructions">Lorem ipsum dolor sit amet.</p>
        </main>
        <jsp:include page="/ConnServlet" flush="true"/>
    </body>
</html>
