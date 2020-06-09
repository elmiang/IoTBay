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

import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.User;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class URUpdateServlet extends HttpServlet {

  @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            UserManagementDao ud = (UserManagementDao) session.getAttribute("ud");
          
                String userID = request.getParameter("userID");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String dob = request.getParameter("dob");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");
                String postcode = request.getParameter("postcode");
                String phoneNumber = request.getParameter("phoneNumber");
                String role = request.getParameter("role");
            
            try {
                ud.updateUserRecord(userID, email, password, name, dob, gender, address, postcode, phoneNumber, role);
                response.sendRedirect("URServlet");
            } catch (SQLException e){
               throw new ServletException("Cannot update UR", e); 
            }
        }
    

    
}
