<%-- 
    Document   : edit_cardDetails
    Created on : 07/06/2020, 7:03:17 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.Payment"%>
<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
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
             <div class="greeting">
            <h1>Add Card Details</h1>
        </div>
        
        <form method="post" action="card_details.jsp">
            <h2 class="h2 instructions">Card Details</h2>
        
            <p class="p instructions">* marks required fields</p>
            
            <label for="chName">Card Holder Name</label>
            <input id="chName" name="chName" type="text" placeholder="Card Holder Name" value = "${payment.cardHolderName}"/>
            <label for="firstName">First Name*</label>
            <input id="firstName" name="firstName" type="text" placeholder="First Name" value = "${payment.firstName}"/>
            <label for="lastName">Last Name*</label>
            <input id="lastName" name="lastName" type="text" placeholder="LastName Name" value = "${payment.lastName}"/>
            <label for="cardNum">Card Number</label>
            <input id="cardNum" name="cardNum" type="text" placeholder="Card Number" value ="${payment.cardNumber}"/>
            <p class="cardExpiration">Card Expiry</p>
            <div class="cardExpiration">
                <label for="cardMonth">Month</label>
                <select name="cardMonth" id="cardMonth" value = "${payment.expDate}"required>
                    <option value="January">01</option>
                    <option value="February">02</option>
                    <option value="March">03</option>
                    <option value="April">04</option>
                    <option value="May">05</option>
                    <option value="June">06</option>
                    <option value="July">07</option>
                    <option value="August">08</option>
                    <option value="September">09</option>
                    <option value="October">10</option>
                    <option value="November">11</option>
                    <option value="December">12</option>
                </select>
                <label for="cardYear">Year</label>
                <select name="cardYear" id="cardYear" value = "${payment.expDate}" required>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                    <option value="2024">2024</option>
                    <option value="2025">2025</option>
                    <option value="2026">2026</option>    
                </select>
            </div>
            
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
