<%-- 
    Document   : login
    Created on : Apr 6, 2020, 6:01:41 PM
    Author     : jacks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
    <div class="container">
            <h1>Login</h1>
        <form action="welcome.jsp" method="post">
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" name="email" placeholder="Enter email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" name="password" placeholder="Enter password" required>
            </div>
                 <input type="submit" value="Login" class="btn btn-primary" name="login">         
        </form>
        
            <a href="landing.jsp">Back</a>
            
        </div>
    </body>
</html>
