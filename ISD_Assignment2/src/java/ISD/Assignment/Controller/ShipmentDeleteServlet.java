/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ISD.Assignment.Model.Shipment;
import ISD.Assignment.Model.Dao.ShipmentManager;

/**
 *
 * @author admin
 */
public class ShipmentDeleteServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        ShipmentManager manager = (ShipmentManager) session.getAttribute("manager");
        

        try{
                manager.deleteShipment(Integer.parseInt(id));
                session.setAttribute("deleted", "Delete was successful");
                request.getRequestDispatcher("shipmentSearch.jsp").include(request, response);         
        }catch (SQLException ex){
            Logger.getLogger(ShipmentEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
