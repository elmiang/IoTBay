
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


public class RegisterServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        UserManagementDao manager = (UserManagementDao) session.getAttribute("manager");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String postCode = request.getParameter("postCode");
        String phoneNumber = request.getParameter("phoneNumber");
        validator.clear(session);
        User exist = null;
       
        if (!validator.validateEmail(email) ) {           
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {                  
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validateAddress(address)){    
            session.setAttribute("addressErr", "Error: Address format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validatePostCode(postCode)){    
            session.setAttribute("postCodeErr", "Error: postCode format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validatePhoneNumber(phoneNumber)){    
            session.setAttribute("phoneNumberErr", "Error: Phone Number format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                exist = manager.findUser(email , password);
                if(exist != null){
                    session.setAttribute("existErr","User already exists in the databse");
                    request.getRequestDispatcher("register.jsp").include(request,response);
                } else{
                    manager.addUser(email, password, name, dob, gender, address, postCode, phoneNumber);
                    User user = manager.findUser(email, password);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}