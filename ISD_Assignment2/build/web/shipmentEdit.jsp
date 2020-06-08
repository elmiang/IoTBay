<%-- 
    Document   : shipmentEdit
    Created on : 06/06/2020, 6:44:24 PM
    Author     : admin
--%>

<%@page import="ISD.Assignment.Model.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>ShipmentEdit Page</title>
    </head>
    <body onload = "startTime()">
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          <li style="float:right"><a href="CartServlet"><img class="logo" src="css/cart.png"/></a></li>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreServlet" style="float: left;">Kits</a>
            <a href="StoreServlet" style="float: left;">Parts</a>
            <a href="StoreServlet" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
        <%
            shipment shipment = (shipment) session.getAttribute("shipment");
            String updated = (String) session.getAttribute("updated");
        %>
        
        <a class ="button" href="shipmentSearchResult.jsp?id=<%=shipment.getShipmentID()%>&date='<%=shipment.getStartDate()%>'">Back</a>
        
        <h1>Edit Shipment Information</h1><%=(updated!=null?updated:"")%>
        <form method="post" action="shipmentUpdateServlet">
        <table>  
            <tr><td>ShipmentID</td><td><input type="text" name="shipmentID" value="${shipment.shipmentID}" readonly></td></tr>
            <tr><td>UserID</td><td><input type="text" name="userID" value="${shipment.userID}" readonly></td></tr>
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
                    <input class ="button" type="submit" value="Update">
                </td>
            </tr>
        </table>
       </form>
        </main>
    </body>
</html>
