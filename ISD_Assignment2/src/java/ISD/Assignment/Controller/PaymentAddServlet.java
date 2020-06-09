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

import ISD.Assignment.Model.Dao.PaymentDAO;
import ISD.Assignment.Model.Payment;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author CristinaFidelino
 */
public class PaymentAddServlet  extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            PaymentDAO pyd = (PaymentDAO) session.getAttribute("pyd");
            int paymentID = Integer.parseInt(request.getParameter("paymentID"));
            String cardHolderName = request.getParameter("cardHolderName");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
            String expDate = request.getParameter("expDate");
            String paidDate = request.getParameter("paidDate");
            String paymentMethod = request.getParameter("paymentMethod");
            double paidAmount = Double.parseDouble(request.getParameter("paidAmount"));
            
            try {
                pyd.addPayment(cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod, paidAmount);
                response.sendRedirect("PaymentServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot add payment to Database", e); 
            }
        }
}
