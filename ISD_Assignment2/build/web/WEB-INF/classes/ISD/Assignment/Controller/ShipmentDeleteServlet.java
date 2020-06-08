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
import ISD.Assignment.Model.shipment;
import ISD.Assignment.Model.Dao.ShipmentDao;

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
        ShipmentDao sm = (ShipmentDao) session.getAttribute("sm");
        String currentS;
        
        try{
                currentS = sm.getCurrentStatus(Integer.parseInt(id));
                if(currentS.equals("processing")){
                sm.deleteShipment(Integer.parseInt(id));
                session.setAttribute("deleted", "Delete was successful");
                request.getRequestDispatcher("shipments.jsp").include(request, response);}
                else{
                    session.setAttribute("deleted", "Shipment finalisation, can't be deleted!");
                    request.getRequestDispatcher("shipments.jsp").include(request, response);
                }
        }catch (SQLException ex){
            Logger.getLogger(ShipmentEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
