<%-- 
    Document   : login
    Created on : 28/04/2020, 11:09:20 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Login</title>
    </head>
    <body>
        
        <div class="header-img">
            <ul>
                <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
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
        <form style="text-align: center;" method="post" action="welcome.jsp">
            <h1>Login</h1>
            <label for="email">Email address</label>
            <input id="email" name="email" type="email" placeholder="Email address"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password"/>
            <a class="button" href="index.jsp"> Cancel </a>
            <input class="button" type="submit" value="Login"/><br>
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        </form>
        </main>
    </body>
</html>
