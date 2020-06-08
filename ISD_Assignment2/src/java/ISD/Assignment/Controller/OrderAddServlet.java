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
            String name = request.getParameter("productName");
            int quantity = 1;
            ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
            Order order = (Order) session.getAttribute("Order");
            if (cart == null){
            cart = new ShoppingCart();
            session.setAttribute("ShoppingCart", cart);
            }
       
            
            String orderStatus = "not confirmed";
      
            try {
                od.updateStatus(orderStatus);
                if(cart.getCart().contains(pd.exactSearch(name))){
                cart.setQuantity(++quantity);
                
                
            }
            else{
                cart.addProduct(pd.exactSearch(name));
                cart.setQuantity(quantity);
                
            }
                
                
                
                //request.getRequestDispatcher("order.jsp").forward(request, response);
                request.getRequestDispatcher("Order.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot add order to DB", e); 
            }
        }
    
}
