<%-- 
    Document   : register
    Created on : Apr 6, 2020, 6:01:48 PM
    Author     : jacks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        
        <div class="container">
            <h1>Register</h1>
        <form action="welcome.jsp" method="post">
            
            <div class="row form-group">
                <label class="col-sm-2 col-form-label" for="fname">First Name:</label>
                <div class="col-sm-10">
                <input class="form-control" type="text" name="fname" required>
                </div>
            </div>
            
            <div class="row form-group">
                <label class="col-sm-2 col-form-label"for="lname">Last Name:</label>
                <div class="col-sm-10">
                <input class="form-control" type="text" name="lname" required>
                </div>
            </div>
            <div class="row form-group">
                <label class="col-sm-2 col-form-label" for="email">Email:</label>
                <div class="col-sm-10">
                <input class="form-control" type="email" name="email" required>
                </div>
            </div>
            <div class="row form-group">
                <label class="col-sm-2 col-form-label" for="phone">Phone Number:</label>
                <div class="col-sm-10">
                <input class="form-control" type="text" name="phone" required>
                </div>
            </div>
            <div class="row form-group">
                <label class="col-sm-2 col-form-label" for="password">Password:</label>
                <div class="col-sm-10">
                <input class="form-control" type="password" name="password" required>
                </div>
            </div>
            <div class="row form-group">
                <label class="col-sm-2 col-form-label" for="confirmpassword">Confirm Password:</label>
                <div class="col-sm-10">
                <input class="form-control" type="password" name="confirmpassword" required>
                </div>
            </div>
                
            
                <input class="btn btn-primary" type="submit" value="Register" name="register">
            
        </form>
            <a href="landing.jsp">Back</a>
        </div>
    </body>
</html>
