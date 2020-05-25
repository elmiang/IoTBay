<%-- 
    Document   : confirmed
    Created on : 24/05/2020, 9:30:44 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Index</title>
    </head>
    <body>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
          <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart.png"/></a></li>
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
            <img src="css/checkmark.png"  width="100" height="100" />
            <p class="p instructions">Thank you for your Order!</p>
            <p class="p instructions">You will receive an email shortly at ${user.email}</p>
            <p class="p instructions">Your Order Number is: (Put Order ID Here)</p>
            <p class="p instructions"><a href = "index.jsp">Click here to view your Order History</a></p>
            <p class="p instructions"><a href = "index.jsp">Click here to return to the Main Page</a></p>
            
            
        </main>
    </body>
</html>
