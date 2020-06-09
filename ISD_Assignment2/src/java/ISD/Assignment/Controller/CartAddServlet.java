/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Product;
import ISD.Assignment.Model.ShoppingCart;
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
 * @author jacks
 */
public class CartAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        ProductDao pd = (ProductDao) session.getAttribute("pd");
        String name = request.getParameter("productName");
        int quantity = 1;
        ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
        if (cart == null){
            cart = new ShoppingCart();
            session.setAttribute("ShoppingCart", cart);
        }
        try {
            
            if(cart.getCart().contains(pd.exactSearch(name))){
                cart.setQuantity(++quantity);
            }
            else{
                cart.addProduct(pd.exactSearch(name));
                cart.setQuantity(quantity);
            }
            
            request.getRequestDispatcher("StoreServlet").include(request, response);
        } catch (SQLException e){
            throw new ServletException("Cannot add product to Cart", e);
        }
    }
}
