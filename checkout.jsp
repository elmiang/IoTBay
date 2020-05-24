<%-- 
    Document   : checkout
    Created on : 24/05/2020, 9:06:36 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Checkout</title>
    </head>
    <body>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
        </ul>
        </div>
        <div class="topnav">
            <a href="products.jsp" style="float: left;">All Products</a>
            <a style="float: left;">Kits</a>
            <a style="float: left;">Parts</a>
            <a style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        <main class="main-content">
            <form method="post" action="welcome.jsp" style="text-align: center;">
            <h1>Shipping Information</h1>
            
            <label for="name">First Name</label>
            <input id="name" name="name" type="text" placeholder="First Name" required = "true"/>
            <label for="name">Last Name</label>
            <input id="name" name="name" type="text" placeholder="Last Name" required = "true"/>
            
            <label for="email">Email address</label>
            <input id="email" name="email" type="email" placeholder="Email address" required = "true"/>
            <label for="phoneNumber">Phone Number</label>
            <input id="phoneNumber" name="phoneNumber" type="tel"  pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}" placeholder="1234-567-890" required = "true"/>
            
            <label for="address">Address</label>
            <input id="address" name="address" type="text" placeholder="Address" required ="true"/>
            <label for="addressTwo">Address 2 </label>
            <input id="addressTwo" name="addressTwo" type="text" placeholder="E.g. Apartment, Suite or Space Number" />
            <label for="city">City/Town</label>
            <input id="city" name="city" type="text" placeholder="City/Town" />
            <label for="State/Territory">State/Territory</label>
            <input id="state" name="state" type="text" placeholder="State/Territory" />
            
            <label for="postcode">Postcode</label>
            <input id="postcode" name="postcode" type="text" placeholder="Postcode"/>
            
            <div class="tos-section">
            <label for="saveToAB">Save details to Address Book</label>
            <input type="checkbox" name="saveToAB" id="savetoAB"/>
            </div>
            
            <a class="button" href="payment.jsp"> Proceed </a>
        </form>
        </main>
    </body>
</html>

