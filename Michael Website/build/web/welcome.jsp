<%-- 
    Document   : welcome
    Created on : Apr 6, 2020, 6:01:56 PM
    Author     : jacks
--%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <%  
            String firstName = request.getParameter("fname"); 
            String lastName = request.getParameter("lname");          
            String phoneNo = request.getParameter("phone");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//            session.setAttribute("firstName", firstName);
//            session.setAttribute("lastName", lastName);
//            session.setAttribute("phoneNo", phoneNo);
//            session.setAttribute("email", email);
//            session.setAttribute("password", password);
        %>
        <%
            User user = new User(firstName, lastName, email, phoneNo, password);
            session.setAttribute("user", user);
        %>
        <div align="center" class="container">
            <h1>Welcome, 
            ${user.FName} ${user.LName}
            <%
                if(user.getFName() == null){
                    out.print("user");
                }
            %>
            </h1>
            <p>Please click <a href="main.jsp">here</a> to continue to the store</p>
        </div>
    </body>
</html>
