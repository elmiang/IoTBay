<%-- 
    Document   : register
    Created on : 28/04/2020, 11:09:29 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Register</title>
    </head>
    <body>
        
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
        <form method="post" action="welcome.jsp" style="text-align: center;">
            <h1>Create An Account</h1>
            
            <label for="name">Name</label>
            <input id="name" name="name" type="text" placeholder="Full Name" required = "true"/>
            <label for="email">Email address</label>
            <input id="email" name="email" type="email" placeholder="Email address" required = "true"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" required = "true"/>
            
            
            <h4 class="gender">Gender:</h4>
            <div class="gender-labels">
                <label for="male">Male</label>
                <input type="radio" id="male" name="gender" value="male"/>
                <label for="male">Female</label>
                <input type="radio" id="female" name="gender"value="female"/>
            </div>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" name="dob" id="dob" required = "true">
            
            <div class="tos-section">
            <label for="tos">I Agree to the Terms of Service</label>
            <input type="checkbox" name="tos" id="tos" required/>
            </div>
            
            <a class="button" href="index.jsp"> Cancel </a>
            <input class="button" type="submit" value="Register"/><br>
        </form>
        </main>
    </body>
</html>
