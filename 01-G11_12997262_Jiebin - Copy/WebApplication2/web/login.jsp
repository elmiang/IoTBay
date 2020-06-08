<%-- 
    Document   : login
    Created on : 2020-4-29, 22:03:28
    Author     : AAKK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <title>Login Page</title>
    </head>
    <body onload="startTime()">
        <%
            String existErr = (String) session.getAttribute("existErr");
             String emailErr = (String) session.getAttribute("emailErr");
              String passErr = (String) session.getAttribute("passErr");
        %>
        <h2>Login</h2>  <%=(existErr != null ? existErr: "")%>

         <form action = "LoginServlet" method = "post"> 
             <p class ="navi"></p>
             <table>
                 <tr><td>Account Name:</td><td><input type="text" name="name" placeholder="<%=(emailErr != null ? emailErr: "eneter email")%>" required="true"></td></tr>
                 <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(passErr != null ? passErr: "eneter pass")%>" required></td></tr>
             </table>
             <br>
             <div>
                 <a class="button" href ="CancelServlet"> Back</a>
                 <input class="button" type ="submit" value="Login">
             </div>
         </form>
    </body>
</html>
