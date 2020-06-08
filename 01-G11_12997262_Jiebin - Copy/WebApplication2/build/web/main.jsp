<%-- 
    Document   : main
    Created on : 2020-4-30, 2:12:07
    Author     : AAKK
--%>

<%@page import="uts.isd.model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoT.css">
        <title>Main Page</title>
    </head>
    <body>
        <h2>User Profile</h2>
        
        <p class="right">
        <a class="button"  href="logout.jsp"> Logout</a>
        </p>
        
        <div>
            <jsp:include page="profile.jsp" flush="true" />
        </div>
 
        
     
  
    </body>
</html>
