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
import ISD.Assignment.Model.UserRecord;
import java.sql.PreparedStatement;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class UserRecordDao {
    
    private Statement st;
    private Connection conn;
    
     public UserRecordDao(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
     
 public ArrayList<UserRecord> searchUserRecord(String searchName, String searchPassword) throws SQLException{
        ArrayList<UserRecord> searchUserRecord = new ArrayList();
        String search = "SELECT * FROM IOTUSER.UserRecord WHERE password LIKE '%" + searchPassword + "%' OR name LIKE '%" + searchName +"%'";
        ResultSet rs = st.executeQuery(search);
        
        while(rs.next()){
            String userID = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String name = rs.getString(4);
            String dob = rs.getString(5);
            String gender = rs.getString(6);
            String address = rs.getString(7);
            String postcode = rs.getString(8);
            String phonenumber = rs.getString(9);
            String role = rs.getString(10);
            searchUserRecord.add(new UserRecord(userID, email, password, name, dob, gender, address, postcode, phonenumber, role));
            }
        if(searchUserRecord.size() > 0 ) {
            return searchUserRecord;
	}
        else{
            return null;
    }
}   
     
public void addUserRecord(String email, String password, String name, String dob, String gender, String address, String postcode, String phonenumber, String role) throws SQLException {
    String update = "INSERT INTO IOTUSER.USERRECORD(email,password,name,dob,gender,address,postcode,phonenumber,role) VALUES(?,?,?,?,?,?,?,?,?)";
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
    String update = "UPDATE IOTUSER.USERRECORD SET email = ?, password = ?, name = ?, dob = ?, gender = ?, address = ?, postcode = ?, phonenumber = ?, role = ? WHERE userID = ? ";
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
    st.executeUpdate("DELETE FROM IOTUSER.USERRECORD WHERE email='" + email + "'");
}
    
public ArrayList<UserRecord> fetchUserRecord() throws SQLException{
   ArrayList<UserRecord> userrecords = new ArrayList(); 
   String fetch = "Select * from IOTUSER.USERRECORD";
   ResultSet rs = st.executeQuery(fetch);
   
   while (rs.next()) {
           String userID = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String name = rs.getString(4);
            String dob = rs.getString(5);
            String gender = rs.getString(6);
            String address = rs.getString(7);
            String postcode = rs.getString(8);
            String phonenumber = rs.getString(9);
            String role = rs.getString(10);
            userrecords.add(new UserRecord(userID, email, password, name, dob, gender, address, postcode, phonenumber, role));    
   }
   return userrecords;
}

}
