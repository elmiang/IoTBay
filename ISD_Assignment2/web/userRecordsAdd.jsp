<%-- 
    Document   : userRecordsAdd
    Created on : 06/06/2020, 8:06:43 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/IoTBay.css">
        <title>Add User Record</title>
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
            <li style="float:right; margin-right:10px;"><a class="button top-actions" href="logout.jsp"> Logout </a></li>
          </c:if>
          <li style="float:right"><a href="cart.jsp"><img class="logo" src="css/cart.png"/></a></li>
        </ul>
        </div>
        
         <div class="topnav">
            <a href="StoreServlet" style="float: left;">All Products</a>
            <a href="StoreServlet" style="float: left;">Kits</a>
            <a href="StoreServlet" style="float: left;">Parts</a>
            <a href="StoreServlet" style="float: left;">Sensors</a>
            <a style="float: right;">About</a>
            <a style="float: right;">Contact</a>
            <a href="URServlet" style="float: right;">User Management</a>
        </div>
    <main class="main-content"> 
        
   <c:if test="${userID != null}">
            <h1>Edit User Record</h1>
            <form action="URUpdateServlet?userID=<c:out value="${userID}"/>" method="post">
        </c:if>     
        
   <c:if test="${userID == null}">
            <h1>Add User Record</h1>
            <form action="URAddServlet" method="post">
        </c:if>
                <div>
                    <p class="p instructions">Please fill out all text fields and select a DoB before pressing "Save"</p>
                </div>
         <table>
           
         
               <tr>
                    <th>Email</th>
                    <td>
                        <input type="email" name="email" placeholder="Insert email" />
                    </td>
                </tr>
                
                <tr>
                    <th>Password</th>
                    <td>
                        <input type="text" name="password" placeholder="Insert password"/>
                    </td>
                </tr>
                
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="name" placeholder="Insert name"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>DoB</th>
                    <td>
                        <input type="date" name="dob" placeholder="Insert dob"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>Gender</th>
                    <td>
                        <input type="text" name="gender" placeholder="Insert M or F"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>Address</th>
                    <td>
                        <input type="text" name="address" placeholder="Insert address"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>Postcode</th>
                    <td>
                        <input type="text" name="postcode" placeholder="Insert postcode"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>Phone number</th>
                    <td>
                        <input type="text" name="phoneNumber" placeholder="Insert phone number"/>
                    </td>
                </tr>
                
                 <tr>
                    <th>Role</th>
                    <td>
                        <input type="text" name="role" placeholder="Insert role"/>
                    </td>
                </tr>
                
                <tr>
                    <th></th>
                    <td>
                        <a href="URServlet" class="button">Back</a>
                        <input type="submit" value="Save" class="button"/>
                    </td>
                </tr>
            </table> 
            </form>
    </main>
    </body>
</html>
