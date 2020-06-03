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
import javax.servlet.RequestDispatcher;
    
    public class StoreEditServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            ProductDao pd = (ProductDao) session.getAttribute("pd");
            String oname = (String) request.getParameter("oName");
            RequestDispatcher dispatcher = request.getRequestDispatcher("productAdd.jsp");
            request.setAttribute("oName", oname);
            dispatcher.forward(request, response);
        }
    }