
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Shipment_Search</title>
    </head>
    <body onload="startTime()">
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
            String existErr = (String) session.getAttribute("existErr");
            String IDErr = (String) session.getAttribute("IDErr");
            String dateErr = (String) session.getAttribute("dateErr");
            String deleted = (String) session.getAttribute("deleted");
        %>
        <h1>Shipment_Search<span><%=(existErr != null ? existErr : "")%><%=(deleted != null ? deleted : "")%></span></h1>
        <form action ="shipmentSearchServlet" method="post">
            <table>
                <tr>
                    <td>ShipmentID:</td>
                    <td><input type="text" placeholder="<%=(IDErr != null ? IDErr : "Enter shipmentID")%>" name="shipmentID" required></td>
                </tr>
                <tr><td>Date</td>
                    <td><input type="date" placeholder="<%=(dateErr != null ? dateErr : "Enter date (yyyy-dd-mm)")%>" name="shipmentDate" required> </td>
                </tr>
                <tr><td></td>
                     <td><a class="button"  href = "AllShipmentsServlet">Back </a><input class="button" type="submit" value="Search"></td>
                </tr>
               
            </table>   
        </form>
        </main>
    </body>
</html>
