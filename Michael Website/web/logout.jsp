<%-- 
    Document   : logout
    Created on : Apr 6, 2020, 6:02:17 PM
    Author     : jacks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <p text-align="center">You have been logged out. Click <a href="landing.jsp">here</a> to return to the landing page.</p>
        <% 
                if(session!=null){
                    session.invalidate();
                }
            %>
    </body>
</html>
