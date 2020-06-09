/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ISD.Assignment.Model.User;
/**
 *
 * @author jacks
 */
public class DBManager {
    private Statement st;
    
    public DBManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    public User findUser(String email, String password) throws SQLException{
        String read = "SELECT * FROM IOTUSER.Users WHERE EMAIL='" + email + "' " + " AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(read);
        
        while(rs.next()){
            int userID = rs.getInt(1);
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)){
                String userName = rs.getString(4);
                String userDOB = rs.getString(5);
                String userGender = rs.getString(6);
                String userAddress = rs.getString(7);
                String userPostCode = rs.getString(8);
                String userPhoneNumber = rs.getString(9);
                String userRole = rs.getString(10);
                return new User (userID, userEmail, userPass, userName, userDOB, userGender, userAddress, userPostCode, userPhoneNumber, userRole);
            }
        }
        return null;
    }
    
    public void addUser(String id, String email, String password, String name, String dob, String gender, String address, String postCode, String phoneNumber) throws SQLException{
        st.executeUpdate("INSERT INTO IOTUSER.Users " + "VALUES ('" + id + "', '" + email + "', '" + password + "', '" + name + "', '" + dob + "', '" + gender + "', '" + address + "', '" + postCode + "', '" + phoneNumber + "')");
    }
    
    public void updateUser(String id, String email, String password, String name, String dob, String gender, String address, String postCode, String phoneNumber) throws SQLException{
        st.executeUpdate("UPDATE IOTUSER.Users SET FULLNAME='" + name + "', PASSWORD='" + password + "', DOB='" + dob + "', GENDER='" + gender + "', ADDRESS='" + address + "', POSTCODE='" + postCode + "', PHONENUMBER='" + phoneNumber + "' WHERE EMAIL='" + email + "'");
    }
    
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.Users WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "select * from USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
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
}
