<%-- 
    Document   : accessLog
    Created on : 06/06/2020, 6:16:36 PM
    Author     : marti
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ISD.Assignment.Model.AccessLogs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Access Log</title>
    </head>
    <body>
        <%
            ArrayList<AccessLogs> accessLogs = (ArrayList<AccessLogs>) session.getAttribute("accessLogs");
        %>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <c:if test="${user == null}">
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          </c:if>
          <c:if test="${user != null}">
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="main.jsp"> Account </a></li>
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="LogoutServlet"> Logout </a></li>
          </c:if>
          <li style="float:right" class="listImage"><a href="cart.jsp"><img class="logo" src="css/cart.png"/></a></li>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreServlet" style="float: left;">Kits</a>
            <a href="StoreServlet" style="float: left;">Parts</a>
            <a href="StoreServlet" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
        </div>
        <h1>Access log</h1>
        
        <input type="text" id="logSearch" onkeyup="loginSearch()" placeholder="Search login time" title="Type in a name">
        <input type="text" id="outSearch" onkeyup="logoutSearch()" placeholder="Search logout time" title="Type in a name">
        <table id="myTable">
            <thead>
                <tr>
                    <th>Visit ID</th>
                    <th>User ID</th>
                    <th>Login Time</th>
                    <th>Logout Time</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach var="AccessLogs" items="${accessLogs}">
                    <tr>
                        <td><c:out value="${AccessLogs.getVisitId()}"/></td>
                        <td><c:out value="${AccessLogs.getUserId()}"/></td>
                        <td><c:out value="${AccessLogs.getLoginTime()}"/></td>
                        <td><c:out value="${AccessLogs.getLogoutTime()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
    <script>
        function loginSearch() {
          var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("logSearch");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }       
          }
        }
        function logoutSearch() {
          var input, filter, table, tr, td, i, txtValue;
          input = document.getElementById("outSearch");
          filter = input.value.toUpperCase();
          table = document.getElementById("myTable");
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[3];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }       
          }
        }
    </script>
    </body>
</html>
