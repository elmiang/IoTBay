<%-- 
    Document   : login
    Created on : 28/04/2020, 11:09:20 PM
    Author     : CristinaFidelino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Login</title>
    </head>
    <body>
        <%
            String existErr = (String)session.getAttribute("existErr");
            String emailErr = (String)session.getAttribute("emailErr"); 
            String passwordErr = (String)session.getAttribute("passErr");
        %>
        
        <div class="header-img">
            <ul>
                <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
            </ul>
        </div>
        
        <div class="topnav">
            <a href="index.jsp"style="float: left;">Home</a>
            <a style="float: left;">All Products</a>
            <a style="float: left;">Kits</a>
            <a style="float: left;">Parts</a>
            <a style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        
        
        <main class="main-content">
        <form style="text-align: center;" method="post" action="LoginServlet">
            <h1>Login</h1> <span><%=(existErr != null ? existErr : "")%></span>
            <label for="email">Email address</label>
            <input id="email" name="email" type="text" placeholder="<%=(emailErr != null ? emailErr : "Email Address")%>"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="<%=(passwordErr != null ? passwordErr : "Password")%>"/>
            <a class="button" href="index.jsp"> Cancel </a>
            <input class="button" type="submit" value="Login"/><br>
            <p class="instructions">New User? <a href= "register.jsp"> Sign Up Here</p>
        </form>
        </main>
    </body>
</html>
