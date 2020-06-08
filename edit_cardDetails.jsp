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
            <h1>Edit Card Details</h1>
        </div>
        
            
        <form method="post" action="PaymentEditServlet">
            <p class="p instructions" style="color: red">* marks required fields</p>
            
             <table>
                <tr>
                    <th>Card Holder Name*</th>
                    <td>
                        <input type="text" name="chName" placeholder="Card Holder Name"  value = "${payment.cardHolderName}"/>
                    </td>
                </tr>
                <tr>
                    <th>First Name*</th>
                    <td>
                        <input type="text" name="firstName" placeholder="First Name" value = "${payment.firstName}"/>
                    </td>
                </tr>
                <tr>
                    <th>Last Name*</th>
                    <td>
                        <input type="text" name="lastName" placeholder="Last Name" value = "${payment.lastName}"/>
                    </td>
                </tr>
                <tr>
                    <th>Card Number*</th>
                    <td>
                        <input type="text" name="cardNumber" placeholder="Card Number" value ="${payment.cardNumber}"/>
                    </td>
                </tr>
                <tr>
                    <th>Card Expiry Date*</th>
                    <td>
                        <div class="cardExpiration">
                <label for="cardMonth">Month</label>
                <select name="cardMonth" id="cardMonth" value = "${payment.expDate}" required>
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
                <select name="cardYear" id="cardYear"   value = "${payment.expDate}" required>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                    <option value="2024">2024</option>
                    <option value="2025">2025</option>
                    <option value="2026">2026</option>    
                </select>
            </div>
            
            <div class="payment-section">
                    </td>
                </tr>
                
                <tr>
                    <th></th>
                    <td>
                        <a href="card_details.jsp" class="button">Back</a>
                        <input type="submit" value="Save Card Details" class="button"/>
                    </td>
                </tr>
            </table>
        </form>
        
            <%
           // int paymentID = Integer.parseInt(request.getParameter("paymentID"));
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
