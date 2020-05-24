<%-- 
    Document   : edit
    Created on : 30/04/2020, 6:48:21 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Edit</title>
    </head>
    
    <body>
        
        <%
            User user = (User)session.getAttribute("user");
            String updated = request.getParameter("update");
        %>
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="logout.jsp"> Logout </a></li>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart2.png"/></a></li>
          <li style="float:right" class="listImage"><a href="main.jsp"><img class="logo" src="css/userIcon.png"/></a></li>
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
             <div class="greeting">
            <h1>Edit Account Information</h1>
        </div>
        
        <form method="post" action="edit.jsp">
            <h2 class="h2 instructions">Account Settings</h2>
        
            <p class="p instructions">Personal Information</p>
            
            <label for="name">Name</label>
            <input id="name" name="name" type="text" placeholder="Full Name" value = "${user.name}"/>
            <label for="email">Email address</label>
            <input id="email" name="email" type="email" placeholder="Email address" value ="${user.email}"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" value = "${user.password}"/>
            
            <h4 class="gender">Gender:</h4>
            <div class="gender-labels">
                <label for="male">Male</label>
                <input type="radio" id="male" name="gender"value = "${user.gender}"/>
                <label for="female">Female</label>
                <input type="radio" id="female" name="gender" value = "${user.gender}"/>
            </div>
            
            <label for="dob">Date of Birth:</label>
            <input type="date" name="dob" id="dob" value = "${user.dob}">
            <label for="address">Address</label>
            <input id="address" name="address" type="text" placeholder="Address" value = "${user.address}"/>
            <label for="postcode">Postcode</label>
            <input id="postcode" name="postcode" type="text" placeholder="Postcode" value ="${user.postcode}"/>
            <label for="phoneNumber">Phone Number</label>
            <input id="phoneNumber" name="phoneNumber" type="tel"  pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}" placeholder="1234-567-890" value = "${user.phoneNumber}"/>
            
            <input class="button" type="submit" value="Update"/><br>
            <p class="p instructions">Return to the <a class="p"href = "main.jsp">main page</a> </p>
            <input type ="hidden" name="update" value="Updated">

        </form>
        
        <%
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String postcode = request.getParameter("postcode");
            String phoneNumber = request.getParameter("phoneNumber");
            
            
            user = new User(userID, email, password, name, dob, gender, address, postcode, phoneNumber);
            session.setAttribute("user",user);
        %>
        </main>
        
    </body>
</html>
