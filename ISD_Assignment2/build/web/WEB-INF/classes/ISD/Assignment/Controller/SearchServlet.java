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
    
    public class SearchServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            ProductDao pd = (ProductDao) session.getAttribute("pd");
            String name = request.getParameter("searchName");
            String type = request.getParameter("searchType");
            //String result = (String)session.getAttribute("searchText");
            try {
                    ArrayList<Product> products = new ArrayList<Product>();
                    if(name != null){
                        products = pd.searchProducts(name);
                    }
                    if(type != null){
                        products = pd.searchTypes(type);
                    }
                    request.setAttribute("products", products);

                request.getRequestDispatcher("products.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain products from DB", e); 
            }
        }
    }
