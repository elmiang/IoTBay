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

import ISD.Assignment.Model.Dao.UserRecordDao;
import ISD.Assignment.Model.UserRecord;
import ISD.Assignment.Model.Dao.DBConnector;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class URServlet extends HttpServlet{
   @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{ 
            HttpSession session = request.getSession();
            UserRecordDao ud = (UserRecordDao) session.getAttribute("ud");
            try {
                ArrayList<UserRecord> ur = ud.fetchUserRecord();
                request.setAttribute("ur", ur);
                request.getRequestDispatcher("userRecords.jsp").include(request, response);
            } catch (SQLException e){
               throw new ServletException("Cannot obtain user records from DB", e); 
            }
        }  
}
