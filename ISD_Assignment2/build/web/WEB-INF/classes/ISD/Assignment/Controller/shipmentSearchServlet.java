/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Shipment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ISD.Assignment.Model.Dao.ShipmentManager;


public class shipmentSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String ID =  request.getParameter("shipmentID");
        String date = request.getParameter("shipmentDate");
        ShipmentManager sm = (ShipmentManager) session.getAttribute("sm");
        session.setAttribute("deleted", "");
        Shipment shipment = null;
        validator.clear(session);
        
        if(!validator.validateDate(date)){
            session.setAttribute("dateErr", "Error: Date format incorrect");
            request.getRequestDispatcher("shipmentSearch.jsp").include(request, response);
        }else if(!validator.validateInt(ID)){
            session.setAttribute("IDErr","Error:ID format incorrect");
            request.getRequestDispatcher("shipmentSearch.jsp").include(request, response);            
        }else{     
            try{
            shipment = sm.findShipment(Integer. parseInt(ID), date);
            
            if(shipment != null){
                session.setAttribute("shipment", shipment);
                request.getRequestDispatcher("shipmentSearchResult.jsp").include(request, response);            
            }else{
                session.setAttribute("existErr","Shipment is not in the databse ");
                request.getRequestDispatcher("shipmentSearch.jsp").include(request, response);            
            }
            }catch(SQLException | NullPointerException ex){
                        System.out.println(ex.getMessage() == null ? "Shipment does not exist": "welcome");
                    }
        }
    }
}
