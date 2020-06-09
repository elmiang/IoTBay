/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin
 */
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserManagementDao manager = (UserManagementDao)session.getAttribute("manager");
        validator.clear(session);
        User user = (User)session.getAttribute("user");
        
        if(user != null){
            String logoutTime = new Date().toString();
            try {
                manager.addAccessLogLogoutTime(user.getUserID(), logoutTime);
            } catch (SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        else{
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        
    }
}
