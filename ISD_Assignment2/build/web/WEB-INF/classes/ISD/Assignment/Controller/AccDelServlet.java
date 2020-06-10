/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;


import ISD.Assignment.Model.Dao.UserManagementDao;
import ISD.Assignment.Model.User;
import java.io.IOException;
import java.sql.SQLException;
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
public class AccDelServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserManagementDao manager = (UserManagementDao) session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        validator.clear(session);
        User user = null;
        
        try {
            user = manager.findUser(email, password);
            if(user != null){
                try{
                    manager.deleteUser(email);
                    session.invalidate();
                    request.getRequestDispatcher("index.jsp").include(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(AccDelServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                session.setAttribute("accRemoved","Account not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccDelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
