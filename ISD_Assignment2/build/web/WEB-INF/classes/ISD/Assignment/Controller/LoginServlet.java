package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.*;
import ISD.Assignment.Model.Dao.UserManagementDao;
import java.util.Date;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
   

    @Override   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       

        HttpSession session = request.getSession();
        Validator validator = new Validator();  
        String email = request.getParameter("email");
        String password = request.getParameter("password");   
        UserManagementDao manager = (UserManagementDao)session.getAttribute("manager");
        validator.clear(session);
        
        User user = null; 
        
        try {      
            user = manager.findUser(email, password);
            } catch (SQLException ex) {           
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);       
            }

        if (!validator.validateEmail((email)) ) {           
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {                  
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (user != null) {      
            session.setAttribute("user", user);
            String loginTime = new Date().toString();
            try {
                manager.addAccessLogLoginTime(user.getUserID(), loginTime);
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("main.jsp").include(request,response);
        } else {                                
            session.setAttribute("existErr", "Error: User does not exist in the Database");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }   
    }
}