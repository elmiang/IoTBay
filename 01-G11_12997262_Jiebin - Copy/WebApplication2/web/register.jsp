<%-- 
    Document   : register
    Created on : 2020-4-26, 14:00:26
    Author     : AAKK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <title>Registeration Page</title>
    </head>
    <body>
        <h2>Register</h2>
        <form action = "welcome.jsp" method = "post">
            <table>
                <tr><td>Full name:</td><td><input type = "text" placeholder = "Enter name" name="name" required="yes"></td></tr>
                
               <tr><td>Gender</td>
                       <td>
                           <input type="radio"  name="gender"  value ="male">
                            <lable for ="male"> Male</lable>
                       </td></tr>
                <tr><td></td>
                    <td><input type="radio"  name="gender" value="female">
                    <lable for ="female"> Female</lable>
                    </td>
                </tr>
                
                <tr><td>Email:</td><td><input type = "text" placeholder = "Enter email" name="email" required></td></tr>
                <tr><td>Password:</td><td><input type = "password" placeholder = "Enter password" name="password" required></td></tr>
                <tr><td>DOB:</td><td><input type="date" name="dob" required></td></tr>
                <tr><td>Address</td><td><input type="text" placeholder = "Enter address" name="address" required></td></tr>
                <tr><td>Phone Number</td><td><input type="text" placeholder = "Enter phone number" name="phone" required></td></tr>
        
                <tr><td>Agree to TOS</td><td><input type="checkbox"  name="tos" vale="yes" required></td></tr>
            </table>     
            <br>
            <div>
                <a class="button" href="index.jsp" value="Back">Back</a>
                <input class="button" type ="submit" value ="Register">
            </div>
        </form>
    </body>
</html>
