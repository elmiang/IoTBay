package uts.isd.model.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class shipmentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public shipmentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
        protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public boolean addShipment(String prefname, String email,Integer phone,String address,String city,String stats,Integer postCode,String date, String shipmentMethod) throws SQLException {                   //code for add-operation       
        String sql = "INSERT INTO ISDUSER.SHIPMENT (prefername, email, phone_number,address,city,territory,post_code,startdate,shipmentmethod) VALUES (?,?,?,?,?,?,?,?,?)";
        connect();
        
        PreparedState
    st.executeUpdate("" +
"VALUES ('"+prefname+"','"+email+"',"+phone+",'"+address+"','"+city+"','"+stats+"',"+postCode+",'"+date+"','"+shipmentMethod+"')");   


}
}
