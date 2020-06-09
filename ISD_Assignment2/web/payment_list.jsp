<%-- 
    Document   : card_details
    Created on : 01/06/2020, 5:52:47 AM
    Author     : CristinaFidelino
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ISD.Assignment.Model.Payment"%>
<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Payment History</title>
    </head>
    <body>
        <%
        ArrayList<Payment> payments = (ArrayList<Payment>) session.getAttribute("payments");
        String existErr = (String) session.getAttribute("existErr");
        String deleted = (String) session.getAttribute("deleted");
         %>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
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
        <h1>Payment History</h1><br>
        
        <div class="sidenav">
            <a href="main.jsp">Account Summary</a>
            <a href="order_history.jsp">Order History</a>
            <a href="address_book.jsp">Address Book</a>
            <a href="card_details.jsp">Card Details</a>
            <a href="#">Payment History</a>
            <a href="AccessLogServlet">Access Log</a>
            <a href="accDelete.jsp">Delete Account</a>
        </div>
        
        <table border="1" cellpadding="5">
            
            <caption><h2>Your Payments</h2></caption>
            <tr>
                <th>Payment ID</th>
                <th>Card Holder Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Card Number</th>
                <th>Expiry Date</th>
                <th>Paid Date</th>
                <th>Payment Method</th>
                <th>Paid Amount</th>
                <th>Test</th>
            </tr>
            <c:forEach var="payment" items="${payments}">
                <tr>
                    <td><c:out value="${payment.paymentID}" /></td>
                    <td><c:out value="${payment.cardHolderName}" /></td>
                    <td><c:out value="${payment.firstName}" /></td>
                    <td><c:out value="${payment.lastName}" /></td>
                    <td><c:out value="${payment.cardNumber}" /></td>
                    <td><c:out value="${payment.expDate}" /></td>
                    <td><c:out value="${payment.paidDate}" /></td>
                    <td><c:out value="${payment.paymentMethod}" /></td>
                    <td><c:out value="${payment.paidAmount}" /></td>
                     <td>    
                         <a href="PaymentEditServlet?id=<c:out value ="${payment.paymentID}"/>">Edit Payment</a>
                           <a href="PaymentRemoveServlet?id=<c:out value ="${payment.paymentID}"/>">Delete</a>      
                    </td>
                </tr>
            </c:forEach>
        </table>
            <div style="text-align: center;">
                <a class="button" href="PaymentServlet?id=<c:out value ="${payment.paymentID}"/>"> Add New Payment </a>
                
            </div>
        </main>
            
    </body>
  </html>
