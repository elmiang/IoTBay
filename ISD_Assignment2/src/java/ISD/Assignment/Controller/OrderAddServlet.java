/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.OrderDao;
import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.ShoppingCart;
import ISD.Assignment.Model.Order;
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SOMESH
 */
public class OrderAddServlet extends HttpServlet {
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            OrderDao od = (OrderDao) session.getAttribute("od");
            ProductDao pd = (ProductDao) session.getAttribute("pd");
            User user = (User) session.getAttribute("User");
           
            String orderDate = "Jan 15";
            String orderStatus = "not confirmed";  
            
            String name = request.getParameter("productName");
           
            
            ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
           
            
      
           try {
                
                od.addOrder(user.getUserID(), orderDate, orderStatus);
                
                
                //request.getRequestDispatcher("order.jsp").forward(request, response);
                request.getRequestDispatcher("OrderServlet").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot add order to DB", e); 
            }
        }
    
}
