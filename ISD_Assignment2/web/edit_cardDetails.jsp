<%-- 
    Document   : edit_cardDetails
    Created on : 07/06/2020, 7:03:17 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.Payment"%>
<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Card Details</title>
    </head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Edit</title>
    </head>
    
    <body>
        
        <%
            Payment payment =(Payment)session.getAttribute("payment");
        %>
        
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
             <div class="greeting">
            <h1>Add Card Details</h1>
        </div>
        
        <form method="post" action="PaymentUpdateServlet">
            <h2 class="h2 instructions">Card Details</h2>
        
            <p class="p instructions">* marks required fields</p>
            
            <input type="hidden" id="paymentID" name="paymentID" value="${payment.paymentID}"/>
            <label for="chName">Card Holder Name</label>
            <input id="chName" name="chName" type="text" placeholder="Card Holder Name" value = "${payment.cardHolderName}"/>
            <label for="firstName">First Name*</label>
            <input id="firstName" name="firstName" type="text" placeholder="First Name" value = "${payment.firstName}"/>
            <label for="lastName">Last Name*</label>
            <input id="lastName" name="lastName" type="text" placeholder="LastName Name" value = "${payment.lastName}"/>
            <label for="cardNum">Card Number</label>
            <input id="cardNum" name="cardNum" type="text" placeholder="Card Number" value ="${payment.cardNumber}"/>
            <label for="expDate">Expiry Date</label>
            <input id="expDate" name="expDate" type="text" placeholder="Expiry Date" value="${payment.expDate}"/>
            
            <input class="button" type="submit" value="Save"/><br>
            <p class="p instructions">Return to <a class="p"href = "card_details.jsp">Card Details Page</a> </p>
        </form>
        
            <%
//            int paymentID = Integer.parseInt(request.getParameter("paymentID"));
//            String cardHolderName = request.getParameter("cardHolderName");
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
//            String expDate = request.getParameter("expDate");
//            String paidDate = request.getParameter("paidDate");
//            String paymentMethod = request.getParameter("paymentMethod");
//            double paidAmount = Double.parseDouble(request.getParameter("paidAmount"));
//            
//            payment = new Payment(paymentID, cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod, paidAmount);
//            session.setAttribute("payment",payment);
        %>
        
        </main>
        
    </body>
</html>
