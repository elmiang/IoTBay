/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.OrderDao;
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
public class OrderUpdateServlet extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            OrderDao od = (OrderDao) session.getAttribute("od");
            String status = "confirmed";
            User user = (User) session.getAttribute("User");
            try {
                od.updateStatus(status, user.getUserID());
                response.sendRedirect("OrderServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot update order", e); 
            }
        }

   
}
