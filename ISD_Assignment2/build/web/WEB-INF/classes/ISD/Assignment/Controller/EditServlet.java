
package ISD.Assignment.Controller;

import ISD.Assignment.Model.Dao.DBManager;
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


public class EditServlet extends HttpServlet {

    @Override
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserManagementDao manager = (UserManagementDao) session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        validator.clear(session);
        User user = null;
        
        try{
            user = manager.findUser(email, password);
            if(user != null){
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
            session.setAttribute("existErr","User does not exist in the database");
            request.getRequestDispatcher("edit.jsp").include(request,response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
