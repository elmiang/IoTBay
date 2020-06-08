   package ISD.Assignment.Controller;
   import java.io.IOException;
   import java.sql.Connection;
   import java.sql.SQLException;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import ISD.Assignment.Model.Dao.*;

   public class ConnServlet extends HttpServlet {

       private DBConnector db;
       private UserManagementDao manager;
       private ProductDao pd;
       private Connection conn;   
       private UserManagementDao ud;
       private PaymentDAO pyd;
       private ShipmentManager sm;
       
       @Override //Create an instance of DBConnector for the deployment session
       
       public void init() {
           try {
               db = new DBConnector();

           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }      
       }

       @Override //Add the DBConnector, DBManager, Connection instances to the session

       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");       
           HttpSession session = request.getSession();
           conn = db.openConnection();       
           try {
               manager = new UserManagementDao(conn);
               pd = new ProductDao(conn);
               ud = new UserManagementDao(conn);
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }

           //export the DB manager to the view-session (JSPs)
           session.setAttribute("manager", manager);  
           session.setAttribute("pd", pd);
           session.setAttribute("ud", ud);
           session.setAttribute("pyd", pyd);
           session.setAttribute("sm", sm);
       }   

       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
