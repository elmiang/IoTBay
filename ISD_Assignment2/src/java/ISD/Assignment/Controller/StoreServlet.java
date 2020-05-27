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
import java.sql.Connection;
import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;

    @WebServlet("/products")
    public class StoreServlet extends HttpServlet {
        @Resource(name="jdbc/iotdb")
        private Connection conn;
        private ProductDao productDao;
        
        
       @Override
       public void init(){
           productDao = new ProductDao(conn);
       }
       
       @Override
       protected void doGet(HttpServlet request, HttpServlet response) throws ServletException, IOException{
           
           ProductDao productDao = (ProductDao) session.getAttribute("productDao");
       }
    }
