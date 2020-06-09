<%-- 
    Document   : payment
    Created on : 24/05/2020, 9:18:56 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Payment</title>
    </head>
     <body>
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
            <form method="post" action="PaymentAddServlet" style="text-align: center;">
            <h1>Payment Information</h1>
            <h2 class="h2 instructions" style="color:red">* marks required fields</h2>
            
            <label for="paymentMethod">Payment Method</label>
           
            <div>
                    <label for="visa">Visa</label>
                    <input type="radio" id="visa" name="paymentMethod" value="Visa" required = "true"/>
                    <label for="masterCard">MasterCard</label>
                    <input  type="radio" id="masterCard" name="paymentMethod" value="MasterCard" required = "true"/>
                    <label for="payPal">PayPal</label>
                    <input type="radio" id="payPal" name="paymentMethod"  value = "PayPal" required = "true"/>
            </div>
            
            <label for="cardHolderName">CardHolder Name*</label>
            <input id="cardHolderName" name="cardHolderName" type="text" required = "true" placeholder="CardHolder Name"/>
            <label for="firstName">First Name*</label>
            <input id="firstName" name="firstName" type="text" required = "true" placeholder="First Name"/>
            <label for="lastName">Last Name*</label>
            <input id="lastName" name="lastName" type="text" required = "true" placeholder="Last Name"/>   
            <label for="name">Card Number*</label>
            <input id="cardNum" name="cardNum" type="text" placeholder="Card Number" required = "true"/>
            <label for="name">CVC*</label>
            <input id="cvc" name="cvc" type="text" placeholder="CVC" required = "true"/>
            <label for="name">Expiry Date*</label>
            <input id="expDate" name="expDate" type="text" placeholder="Expiry Date" required = "true"/>
            
            <h2 class="h2">Billing Address</h2>
            <h2 class="h2 instructions" style="color:red">* marks required fields</h2>
            
            <label for="name">First Name*</label>
            <input id="name" name="name" type="text" placeholder="First Name" required = "true"/>
            <label for="name">Last Name*</label>
            <input id="name" name="name" type="text" placeholder="Last Name" required = "true"/>
            <label for="email">Email address</label>
            <input id="email" name="email" type="email" placeholder="Email address" required = "true"/>
            <label for="phoneNumber">Phone Number*</label>
            <input id="phoneNumber" name="phoneNumber" type="tel"  pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}" placeholder="1234-567-890" required = "true"/>
            <label for="address">Address*</label>
            <input id="address" name="address" type="text" placeholder="Address" required ="true"/>
            <label for="addressTwo">Address 2 </label>
            <input id="addressTwo" name="addressTwo" type="text" placeholder="E.g. Apartment, Suite or Space Number" />
            <label for="city">City/Town*</label>
            <input id="city" name="city" type="text" placeholder="City/Town" />
            
            <label for="State/Territory">State/Territory*</label>
            <select name="stateTer" id="stateTer"  required>
                    <option value="New South Wales">New South Wales</option>
                    <option value="Victoria">Victoria</option>
                    <option value="Queensland">Queensland</option>
                    <option value="Western Australia">Western Australia</option>
                    <option value="South Australia">South Australia</option>
                    <option value="Tasmania">Tasmania</option>
                    <option value="Northern Territory">Northern Territory</option>
                    <option value="Australian Capital Territory">Australian Capital Territory</option>    
                </select>
            
            <label for="postcode">Postcode*</label>
            <input id="postcode" name="postcode" type="text" placeholder="Postcode"/>
            
            <div class="tos-section">
            <label for="saveToAB">Save details to Address Book</label>
            <input type="checkbox" name="saveToAB" id="savetoAB"/>
            </div>
            
            <input type="submit" value="Place Order" class="button"/>
        </form>
        </main>
    </body>
</html>
