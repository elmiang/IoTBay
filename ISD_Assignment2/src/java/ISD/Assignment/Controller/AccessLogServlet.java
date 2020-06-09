/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.AccessLogs;
import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marti
 */
public class AccessLogServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserManagementDao manager = (UserManagementDao) session.getAttribute("manager");
        validator.clear(session);
        ArrayList<AccessLogs> accessLogs = new ArrayList<AccessLogs>();
        User user = null;
        
        try {
            user = (User) session.getAttribute("user");
            int id = user.getUserID();
            accessLogs = manager.fetchAccessLogs(id);
            session.setAttribute("accessLogs", accessLogs);
            request.getRequestDispatcher("accessLog.jsp").include(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(AccessLogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
