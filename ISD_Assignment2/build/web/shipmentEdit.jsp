<%-- 
    Document   : shipmentEdit
    Created on : 06/06/2020, 6:44:24 PM
    Author     : admin
--%>

<%@page import="ISD.Assignment.Model.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Shipment Information Page</title>
    </head>
    <body onload = "startTime()">
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
        <%
            shipment shipment = (shipment) session.getAttribute("shipment");
            String updated = (String) session.getAttribute("updated");
        %>
        
        
        <h1>Shipment Information</h1>
        <center><%=(updated!=null?updated:"")%></center>
        <form method="post" action="shipmentUpdateServlet">
        <table>  
            <tr><td>ShipmentID</td><td><input type="text" name="shipmentID" value="${shipment.shipmentID}" readonly></td></tr>
            <tr><td><input type="hidden"></td><td><input type="hidden" name="userID" value="${shipment.userID}" readonly></td></tr>
            <tr><td>PreferName</td><td><input type="text" name="name" value="${shipment.preferName}"></td></tr>
            <tr><td>Email</td><td><input type="email" name="email" value="${shipment.email}"></td></tr>
            <tr><td>Phone_number</td><td><input type="text" name="phone" value="${shipment.phone_number}"></td></tr>
            <tr><td>Address</td><td><input type="text" name="address" value="${shipment.address}"></td></tr>
            <tr><td>City</td><td><input type="text" name="city" value="${shipment.city}"></td></tr>
            <tr><td>Territory</td><td><input type="text" name="territory" value="${shipment.territory}"></td></tr>
            <tr><td>Post_code</td><td><input type="text" name="post_code" value="${shipment.post_code}"></td></tr>
            <tr><td>StartDate</td><td><input type="date" name="startDate" value="${shipment.startDate}"></td></tr>
            <tr><td>ShipmentMethod</td><td><input type="text" name="shipmentMethod" value="${shipment.shipmentMethod}"></td></tr>
            <tr><td>CurrentStatus</td><td><input type="text" name="currentStatus" value="${shipment.currentStatus}" readonly></td></tr>
            <tr>
            <td>
            <a class ="button" href="shipments.jsp?id=<%=shipment.getShipmentID()%>&date='<%=shipment.getStartDate()%>'">Back</a></td>
            <td><input class ="button" type="submit" value="Update"></td>
            </tr>
        </table>
       </form>
        </main>
    </body>
</html>
