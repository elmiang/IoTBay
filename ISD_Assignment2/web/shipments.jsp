<%@page import="java.util.ArrayList"%>
<%@page import="ISD.Assignment.Model.shipment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <script type="text/javascript" src="js/script.js"></script>
    <title>Shipment</title>
</head>
<body>
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
            <a href="OrderServlet" style="float: left;">Your Order</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
    <%
        ArrayList<shipment> shipments = (ArrayList<shipment>) session.getAttribute("shipments");
        String existErr = (String) session.getAttribute("existErr");
        String deleted = (String) session.getAttribute("deleted");
    %>
    <h1>Shipments</h1><center><%=(existErr != null ? existErr : "")%><%=(deleted != null ? deleted : "")%></center>

  <table>
      <h1>
                <a class="button"  href ="shipmentSearch.jsp">shipmentSearch</a>
                <a class="button"  href = "AllShipmentsServlet">All shipments </a>
      </h1>
                <tr>
                    <td>shipmentID </td>
                    
                    <td> preferName</td>
                    <td> email</td>
               <%--   <td> userID</td>  
                    <td> phone_number</td>
                    <td> address</td>
                    <td>city</td>
                    <td> territory</td>     --%>
                    <td> post_code</td>
                    <td>  startDate</td>
                    <td> shipmentMethod</td>
                    <td> currentStatus</td>
                    <td> Action</td>
                </tr>
                
        <c:forEach var="shipment" items="${shipments}">
                    <tr>
                        <td><c:out value="${shipment.shipmentID}"/></td>
                        <td><c:out value="${shipment.preferName}"/></td>
                        <td><c:out value="${shipment.email}"/></td>
                <%--                                   <td><c:out value="${shipment.userID}"/></td>
                        <td><c:out value="${shipment.phone_number}"/></td>
                        <td><c:out value="${shipment.address}"/></td>
                        <td><c:out value="${shipment.city}"/></td>
                        <td><c:out value="${shipment.territory}"/></td>     --%>
                        <td><c:out value="${shipment.post_code}"/></td>
                        <td><c:out value="${shipment.startDate}"/></td>
                        <td><c:out value="${shipment.shipmentMethod}"/></td>
                        <td><c:out value="${shipment.currentStatus}"/></td>
                  <td>    <a href="ShipmentEditServlet?id=<c:out value ="${shipment.shipmentID}"/>&date=<c:out value="${shipment.startDate}"/>">Detail</a>
                            <a href="ShipmentDeleteServlet?id=<c:out value ="${shipment.shipmentID}"/>">Delete</a>            
                    </td>
                    </tr>
                </c:forEach>
        </table>
    
        </main>
</body>
</html>