/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.OrderDao;
import ISD.Assignment.Model.Order;
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SOMESH
 */
public class OrderServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            User user = null;
            OrderDao od = (OrderDao) session.getAttribute("od");
            
           
            try {
                user = (User) session.getAttribute("user");
                ArrayList<Order> orders = od.searchOrder(user.getUserID());
                request.setAttribute("orders", orders);
              
                
                
                request.getRequestDispatcher("Order.jsp").include(request, response);
           } catch (SQLException e){
               throw new ServletException("Cannot obtain orders from DB", e); 
            }
        }
}
    


    