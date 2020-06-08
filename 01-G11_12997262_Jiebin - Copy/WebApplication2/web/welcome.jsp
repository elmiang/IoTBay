<%-- 
    Document   : welcome
    Created on : 2020-4-26, 14:11:46
    Author     : AAKK
--%>

<%@page import="uts.isd.model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <title>Welcome Page</title>
    </head>
    <body>
        

 

       <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
           %>
           
        <h1>Welcome <%= name%></h1>
        
        <div class="right">
            <a class="button" href="index.jsp">Back</a>
            <a class="button"  href="main.jsp">Main Page</a>
        </div>
        
       
        <p>Your email is: <%= email%></p>
        <p>Your password is <%= password%> </p>
        <p>Your gender is <%= gender%></p>
        <p>Your date of birth is <%= dob%></p>
        <p>Your address is <%= address%></p>
        <p>Your phone number is <%= phone%></p>
        
     
        <%
            user user = new user(name,email,password,gender,dob,address,phone);
            session.setAttribute("user", user);
            %>
       
        

        
    </body>
</html>
