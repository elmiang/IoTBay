package ISD.Assignment.Model.Dao;
import ISD.Assignment.Model.AccessLogs;
import ISD.Assignment.Model.Admin;
import ISD.Assignment.Model.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ISD.Assignment.Model.User;
import java.sql.PreparedStatement;



public class UserManagementDao {
    private Statement st;
    private Connection conn;
    
    public UserManagementDao(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
    
    public User findUser(String email, String password) throws SQLException{
        String read = "SELECT * FROM IOTUSER.Users WHERE EMAIL= '"+email+"' AND PASSWORD='"+password+"'";
        ResultSet rs = st.executeQuery(read);
        
        while(rs.next()){
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)){
                int userID = rs.getInt(1);
                String userName = rs.getString(4);
                String userDOB = rs.getString(5);
                String userGender = rs.getString(6);
                String userAddress = rs.getString(7);
                String userPostCode  = rs.getString(8);
                String userPhoneNumber = rs.getString(9);
                String userRole = rs.getString(10);
                return new User (userID, userEmail, userPass, userName, userDOB, userGender, userAddress, userPostCode, userPhoneNumber, userRole);
            }
        }
        return null;
    }
    
    public void addUser(String email, String password, String name, String dob, String gender, String address, String postCode, String phoneNumber) throws SQLException{

        st.executeUpdate("INSERT INTO IOTUSER.Users (email,password,name,dob,gender,address,postcode,phonenumber,role) "

        + "VALUES ('" + email + "', '" + password + "', '" + name + "', '" + dob + "', '" + gender + "', '" + address + "', "
        + "'" + postCode + "', '" + phoneNumber + "','customer')");
    }
    
    public void updateUser(String email, String password, String name, String dob, String gender, String address, String postCode, String phoneNumber) throws SQLException{
            
            st.executeUpdate("UPDATE IotBayAdmin.Users SET  PASSWORD='" + password + "', NAME = '"+ name +"',"
            + "DOB='" + dob + "', GENDER='" + gender + "', ADDRESS='" + address + "', POSTCODE='" + postCode + "', "
            + "PHONENUMBER='" + phoneNumber + "' WHERE EMAIL='" + email + "'");     
    }
    
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("UPDATE IotBayAdmin.Users SET EMAIL =NULL, PASSWORD=NULL, NAME =NULL,"
            + "DOB=CAST(NULL AS DATE), GENDER=NULL, ADDRESS=NULL, POSTCODE=NULL, "
            + "PHONENUMBER=NULL, ROLE=NULL WHERE EMAIL='" + email + "'");
        
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "select * IOTUSER.Users";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList<User>();
        
        while (rs.next()){
            int userID = rs.getInt(1);
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            String userName = rs.getString(4);
            String userDOB = rs.getString(5);
            String userGender = rs.getString(6);
            String userAddress = rs.getString(7);
            String userPostCode = rs.getString(8);
            String userPhoneNumber = rs.getString(9);
            String userRole = rs.getString(10);
            temp.add(new User(userID, userEmail, userPass, userName, userDOB, userGender, userAddress, userPostCode, userPhoneNumber, userRole));
        }
        return temp;
    
    }
    
    public void addAccessLogLoginTime(int id, String loginTime) throws SQLException{
        
        ResultSet rs = st.executeQuery("SELECT MAX(VISITID) FROM IOTUSER.ACCESSLOGS WHERE USERID="+id);
          if(!rs.next()){
                st.executeUpdate("INSERT INTO IOTUSER.AccessLogs (visitid,userid,loginTime) VALUES ("+1+"," + id + ",'" + loginTime + "')");
            }
            else{
                int max = rs.getInt(1);
                max++;
                st.executeUpdate("INSERT INTO IOTUSER.AccessLogs (visitid,userid,loginTime) VALUES ("+ max +"," + id + ",'" + loginTime + "')");
            }       
    }
    
    public void addAccessLogLogoutTime(int id, String logoutTime) throws SQLException{
        ResultSet rs = st.executeQuery("SELECT MAX(VISITID) FROM IOTUSER.ACCESSLOGS WHERE USERID="+id);
                
        if(rs.next()){
            int max = rs.getInt(1);
            st.executeUpdate("UPDATE IOTUSER.AccessLogs SET LOGOUTTIME = '"+ logoutTime+"' WHERE VISITID ="+max+" AND USERID="+id);
        }
    }
    
    public ArrayList<AccessLogs> fetchAccessLogs(int id) throws SQLException{
        ArrayList<AccessLogs> result = new ArrayList<AccessLogs>();
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.AccessLogs WHERE USERID="+id);
        
        while(rs.next()){
            int visitId = rs.getInt(1);
            int userId = rs.getInt(2);
            String loginTime = rs.getString(3);
            String logoutTime = rs.getString(4);
            result.add(new AccessLogs(visitId, userId, loginTime, logoutTime));
        }
    return result;
    }
    
    public ArrayList<User> searchUserRecord(String searchName, String searchPhoneNumber) throws SQLException{
        ArrayList<User> searchUserRecord = new ArrayList();
        String search = "SELECT * FROM IOTUSER.Users WHERE phoneNumber LIKE '%" + searchPhoneNumber + "%' OR name LIKE '%" + searchName +"%'";
        ResultSet rs = st.executeQuery(search);
        
        while(rs.next()){
            int userID = rs.getInt(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String name = rs.getString(4);
            String dob = rs.getString(5);
            String gender = rs.getString(6);
            String address = rs.getString(7);
            String postcode = rs.getString(8);
            String phonenumber = rs.getString(9);
            String role = rs.getString(10);
            searchUserRecord.add(new User(userID, email, password, name, dob, gender, address, postcode, phonenumber, role));
            }
        if(searchUserRecord.size() > 0 ) {
            return searchUserRecord;
	}
        else{
            return null;
    }
}   
     
public void addUserRecord(String email, String password, String name, String dob, String gender, String address, String postcode, String phonenumber, String role) throws SQLException {
    String update = "INSERT INTO IOTUSER.USERS(email,password,name,dob,gender,address,postcode,phonenumber,role) VALUES(?,?,?,?,?,?,?,?,?)";
    PreparedStatement st = conn.prepareStatement(update);
    st.setString(1, email);
    st.setString(2, password);
    st.setString(3, name);
    st.setString(4, dob);
    st.setString(5, gender);
    st.setString(6, address);
    st.setString(7, postcode);
    st.setString(8, phonenumber);
    st.setString(9, role);
    st.execute();
}     
     
public void updateUserRecord(String userID, String email, String password, String name, String dob, String gender, String address, String postcode, String phonenumber, String role) throws SQLException {
    String update = "UPDATE IOTUSER.USERS SET email = ?, password = ?, name = ?, dob = ?, gender = ?, address = ?, postcode = ?, phonenumber = ?, role = ? WHERE userID = ? ";
    PreparedStatement st = conn.prepareStatement(update);
    st.setString(1, email);
    st.setString(2, password);
    st.setString(3, name);
    st.setString(4, dob);
    st.setString(5, gender);
    st.setString(6, address);
    st.setString(7, postcode);
    st.setString(8, phonenumber);
    st.setString(9, role);
    st.setString(10, userID);
    st.execute();
    
}     
    
public void deleteUserRecord(String email) throws SQLException {
    st.executeUpdate("DELETE FROM IOTUSER.USERS WHERE email='" + email + "'");
}
    
public ArrayList<User> fetchUserRecord() throws SQLException{
   ArrayList<User> userrecords = new ArrayList(); 
   String fetch = "Select * from IOTUSER.USERS";
   ResultSet rs = st.executeQuery(fetch);
   
   while (rs.next()) {
           int userID = rs.getInt(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String name = rs.getString(4);
            String dob = rs.getString(5);
            String gender = rs.getString(6);
            String address = rs.getString(7);
            String postcode = rs.getString(8);
            String phonenumber = rs.getString(9);
            String role = rs.getString(10);
            userrecords.add(new User(userID, email, password, name, dob, gender, address, postcode, phonenumber, role));    
   }
   return userrecords;
}

}

