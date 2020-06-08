/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Product;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
    
    public class StoreAddServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            ProductDao pd = (ProductDao) session.getAttribute("pd");
            Validator validator = new Validator();
            String name = request.getParameter("productName");
            String type = request.getParameter("productType");
            int quantity = Integer.parseInt(request.getParameter("productQuantity"));
            double price = Double.parseDouble(request.getParameter("productPrice"));
            validator.clear(session);
            
            //if()
            if(!validator.validateNumber(quantity+"")){
                session.setAttribute("quantityErr", "Please enter a valid number.");
                request.getRequestDispatcher("productAdd.jsp").include(request, response);
            }
            
            if(!validator.validateNumber(price+"")){
                session.setAttribute("priceErr", "Please enter a valid number.");
                request.getRequestDispatcher("productAdd.jsp").include(request, response);
            }
            
            try {
                pd.addProduct(name, type, quantity, price);
                response.sendRedirect("StoreServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot add product to DB", e); 
            }
        }
    }
