/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.OrderDao;
import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.ShoppingCart;
import ISD.Assignment.Model.Order;
import java.util.Date;
import java.text.SimpleDateFormat;  
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static javax.ws.rs.client.Entity.form;


/**
 *
 * @author SOMESH
 */
public class OrderAddServlet extends HttpServlet {
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            
            
            ProductDao pd = (ProductDao) session.getAttribute("pd");
           // int orderID = Integer.parseInt(request.getParameter("orderID"));
            //int userID = Integer.parseInt(request.getParameter("userID"));
            User user = null;
            //session.setAttribute( "userID", userID);
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             sdf.format(new Date());
           
           //int userID = 1;
                
            String orderDate = sdf.format(new Date());
            String orderStatus = "not confirmed";  
            
            
            String name = request.getParameter("productName");
           
            
            ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
            //Order order = new Order(orderID, orderDate, orderStatus, userID);
            OrderDao od = (OrderDao) session.getAttribute("od");
            
            UserManagementDao manager = (UserManagementDao) session.getAttribute("manager");
            
           try {
                //session.setAttribute("order", order);
                
                user = (User) session.getAttribute("user");
                od.addOrder(orderDate, orderStatus, user.getUserID());
                
                
                //request.getRequestDispatcher("order.jsp").forward(request, response);
                //response.sendRedirect("OrderServlet");
                request.getRequestDispatcher("OrderServlet").include(request, response);
           } catch (SQLException e){
              throw new ServletException("Cannot add order to DB", e); 
            }
        }
    
}
