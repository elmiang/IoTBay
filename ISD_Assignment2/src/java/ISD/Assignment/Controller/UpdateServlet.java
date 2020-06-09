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
public class UpdateServlet extends HttpServlet {

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
        String role = request.getParameter("role");
        validator.clear(session);
        
        User exist = null;
        User user = null;
        int ID;
        try{
            exist = manager.findUser(email, password);
            ID = exist.getUserID();
            user = new User(ID, email, password, name, dob, gender, address, postCode, phoneNumber, role);
        }catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        try{
            if (user != null){
                session.setAttribute("user", user);
                manager.updateUser(email, password, name, dob, gender, address, postCode, phoneNumber);
                session.setAttribute("updated","Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request,response);
            }else{
                session.setAttribute("updated", "Update was not succesful");
                request.getRequestDispatcher("edit.jsp").include(request,response);
            }   
               
        }catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }            
        response.sendRedirect("edit.jsp");
    }
}

