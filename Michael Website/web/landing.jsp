<%-- 
    Document   : landing
    Created on : Apr 6, 2020, 6:00:41 PM
    Author     : jacks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
    <div class="container">
        <div align="center">
            <h1>Welcome to the IoTBay Online Store</h1>
            <h3>Please select an option to continue</h3>
        </div>
        
        <div align="center">
            <form class="btn btn-lg" action="login.jsp" method="get">
                <input type="submit" value="Login" name="login">
            </form>
        
            <form class="btn btn-lg" action="register.jsp" method="get">
                <input type="submit" value="Register" name="register">
            </form>
        </div>
        
    </div>
</body>
</html>
