
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


public class ShipmentEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        ShipmentManager sm = (ShipmentManager) session.getAttribute("sm");
        
        Shipment shipment = null;

        try{
            shipment = sm.findShipment(Integer. parseInt(id), date);
            if(shipment != null){
                session.setAttribute("shipment", shipment);
                request.getRequestDispatcher("shipmentEdit.jsp").include(request, response);
            }else{
                session.setAttribute("existErr", "Shipment does not exist in the Database!");
                request.getRequestDispatcher("shipmentEdit.jsp").include(request, response);
            }
        } catch (SQLException ex){
            Logger.getLogger(ShipmentEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " +ex.getMessage());
        }
    }

    }



