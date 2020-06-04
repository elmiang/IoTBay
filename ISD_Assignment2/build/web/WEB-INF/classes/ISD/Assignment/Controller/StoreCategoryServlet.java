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
    
    public class StoreCategoryServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            String result = request.getParameter("type");
            ProductDao pd = (ProductDao) session.getAttribute("pd");
            try {
                ArrayList<Product> products = pd.searchTypes(result);
                request.setAttribute("products", products);
                request.getRequestDispatcher("products.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain products from DB", e); 
            }
        }
    }
