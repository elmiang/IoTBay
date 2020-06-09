<%-- 
    Document   : shipmentNew
    Created on : 08/06/2020, 10:24:58 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <script type="text/javascript" src="js/script.js"></script>
        <title>New Shipment</title>
    </head>
    <body onload ="startTime()">
                <div class="header-img">
            <ul>
                <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
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
        
        <main class="main-content">
        <%
            String existErr = (String) session.getAttribute("existErr"); 
            String  intErr  = (String) session.getAttribute("intErr"); //need more validation
        %>
        <h1>New Shipment</h1>
        <form method = "post" action="NewShipmentServlet">
            
            <label for="name">PreferName</label><input type="text" name="name" placeholder="Enter name">
            <label for="name">Email</label><input type="email" name="email" placeholder="Enter email">    
            <label for="name">Phone_number</label><input type="text" name="phone" placeholder="<%= (intErr != null ? intErr :"Enter phone")%>">  
           <label for="name">Address</label><input type="text" name="address" placeholder="Enter address"> 
            <label for="name">City</label><input type="text" name="city" placeholder="Enter city">  
            <label for="name">Territory</label><input type="text" name="territory" placeholder="Enter territory">
            <label for="name">Post_code</label><input type="text" name="post_code" placeholder="">
           <label for="name">Wished Delivery Date</label><input type="date" name="startDate" placeholder="Enter date (yyyy-mm-dd) ">
            <label for="name">ShipmentMethod</label><input type="text" name="shipmentMethod" placeholder="">
            <input class="button" type ="submit" value="submit">
                
        
            </form>
        </main>
    </body>
</html>
