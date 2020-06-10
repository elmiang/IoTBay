<%-- 
    Document   : userRecords
    Created on : 06/06/2020, 7:28:42 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/IoTBay.css">
        <title>User Management</title>
    </head>
    <body>
        <div class="header-img">
        <ul>
          <li><a href="index.jsp"><img class="logo" src="css/IoTBlogo3.png"/></a></li>
          <c:if test="${user == null}">
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="register.jsp"> Register </a></li>
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="login.jsp"> Login </a></li>
          </c:if>
          <c:if test="${user != null}">
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="main.jsp"> Account </a></li>
            <li style="float:right; margin-right:10px;"> <a class="button top-actions"href="LogoutServlet"> Logout </a></li>
          </c:if>
        </ul>
        </div>
        <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreCategoryServlet?type=motor" style="float: left;">Motors</a>
            <a href="StoreCategoryServlet?type=display" style="float: left;">Displays</a>
            <a href="StoreCategoryServlet?type=sensor" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
            <a href="URServlet" style="float: right;">User Management</a>
        </div>
        
        <main class="main-content">
            
        <center>
        <h1>User Management</>
            
                <form action="userRecordsAdd.jsp" method="post">
                    <input type="submit" class="button" name="addUR" value="Add User Record"/>
                </form>
                
                <form action="URServlet" method="get">
                    <input type="submit" class="button" name="listUR" value="List User Records"/>
                </form>
            
            <div>
                <form action="URSearchServlet" method="get">
                    <input type="text" id="searchText" name="searchText" placeholder="Search name or phone number"/>
                </form>
            </div>
            
    </center>
            <div align="center">     
        <h1>User Records</h1>
        
         <table border="1" cellpadding="5">
                <tr>
                    <th>UserID</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Name</th>
                    <th>DoB</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Postcode</th>
                    <th>Phone number</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
                 <c:forEach var="userrecord" items="${ur}">
                     <tr>
                        <td><c:out value="${userrecord.userID}" /></td>
                        <td><c:out value="${userrecord.email}" /></td>
                        <td><c:out value="${userrecord.password}" /></td>
                        <td><c:out value="${userrecord.name}" /></td>
                        <td><c:out value="${userrecord.dob}" /></td>
                        <td><c:out value="${userrecord.gender}" /></td>
                        <td><c:out value="${userrecord.address}" /></td>
                        <td><c:out value="${userrecord.postcode}" /></td>
                        <td><c:out value="${userrecord.phoneNumber}" /></td>
                        <td><c:out value="${userrecord.role}" /></td>
                        <td>
                            <a href="UREditServlet?userID=<c:out value ="${userrecord.userID}"/>">Edit</a>
                            &nbsp;&nbsp;&nbsp;
                           <a href="URDeleteServlet?email=<c:out value ="${userrecord.email}"/>">Delete</a>
                            &nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                    </c:forEach>
            </table>
            </div>
        
    </body>
</html>
