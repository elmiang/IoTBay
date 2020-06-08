<%-- 
    Document   : profile
    Created on : 2020-4-30, 23:42:56
    Author     : AAKK
--%>

<%@page import="uts.isd.model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
                <%
            user user = (user)session.getAttribute("user");
        %>
        
        
        <table id="profile_table">
            <thead>
               <th>Name</th>
               <th>Email</th>
               <th>Password</th>
               <th>Gender</th>
               <th>DOB</th>
               <th>Address</th>
               <th>Phone Number</th>
           </thead>
           <tr>
               <td>${user.name}</td>
               <td>${user.email}</td>
               <td>${user.password}</td>
               <td>${user.gender}</td>
               <td>${user.dob}</td>
               <td>${user.address}</td>
               <td>${user.phone}</td>
           </tr>
        </table>
    </body>
</html>
