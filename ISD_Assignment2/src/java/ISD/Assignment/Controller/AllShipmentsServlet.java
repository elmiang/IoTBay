/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AllShipmentsServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
        HttpSession session = request.getSession();
          ShipmentManager sm = (ShipmentManager) session.getAttribute("sm");

        
        try{
            ArrayList<Shipment> shipments = sm.fectShipment();
            session.setAttribute("shipments", shipments);
            request.getRequestDispatcher("shipments.jsp").include(request, response);
 
        }catch(SQLException ex){
            Logger.getLogger(AllShipmentsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}


  /*  
            HttpSession session = request.getSession();
            ShipmentManager sd = (ShipmentManager) session.getAttribute("sd");
            try {
                ArrayList<shipment> shipments = sd.fectShipment();
                request.setAttribute("shipment", shipments);
                request.getRequestDispatcher("shipments.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain products from DB", e); 
            }
        }
    }*/
