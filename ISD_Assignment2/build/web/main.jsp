<%-- 
    Document   : main
    Created on : 28/04/2020, 11:09:52 PM
    Author     : CristinaFidelino
--%>

<%@page import="ISD.Assignment.Model.Dao.DBManager"%>
<%@page import="ISD.Assignment.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Main</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        
        
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <li style="float:right; margin-right:10px;"> <a class="button top-actions" href="LogoutServlet"> Logout </a></li>
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
       
        <div class="tab">
            <button class="tablinks" onclick="openPage(event, 'profileTable')">Dashboard</button>
            <button class="tablinks" onclick="openPage(event, 'accessLogs')">Access Logs</button>
            <button class="tablinks" onclick="openPage(event, 'userCart')">Your cart</button>
            <button class="tablinks" onclick="openPage(event, 'userCart')">Your orders</button>
            <button class="tablinks" onclick="openPage(event, 'deleteAcc')">Delete Account</button>
          </div>

          <div id="profileTable" class="tabcontent" style="display: none">  
              
              <jsp:include page="profileTable.jsp" flush="true" />
          </div>

          <div id="accessLogs" class="tabcontent" style="display: none">
              <jsp:include page="AccessLogServlet" flush="true" />
          </div>

          <div id="userCart" class="tabcontent" style="display: none">
            <jsp:include page="" flush="true" />
          </div>

          <div id="deleteAcc" class="tabcontent" style="display: none">
            <form method="post" action="AccDelServlet">
                <input type ="hidden" name="email" value="${user.email}"/>
                <input type ="hidden" name="password" value="${user.password}"/>
                <input class="button" type="submit" value="Delete"/>
            </form>
          </div>
            
          <script>
          function openPage(evt, page) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
              tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
              tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(page).style.display = "block";
            evt.currentTarget.className += " active";
          }
          </script>
         
        </main>    
    </body>
</html>
