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
     
 public ArrayList<UserRecord> searchUserRecord(String searchEmail) throws SQLException{
        ArrayList<UserRecord> searchUserRecord = new ArrayList();
        String search = "SELECT * FROM IOTUSER.UserRecord WHERE UPPER(EMAIL) LIKE UPPER('%" + searchEmail + "%')";
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
            // searchProducts.add(new Product(productId, productName, productType, productDesc, productQuantity, productAvailability, productPrice));
            searchUserRecord.add(new UserRecord(userID, email, password, name, dob, gender, address, postcode, phonenumber, role));
            }
        if(searchUserRecord.size() > 0 ) {
	return searchUserRecord;
	}
        else{
        return null;
    }
}   
     
public void addUserRecord(String userID, String email, String password, String name, String dob, String gender, String address, String postcode, String phonenumber, String role) throws SQLException {
    String update = "INSERT INTO IOTUSER.USERRECORD(userid,email,password,name,dob,gender,address,postcode,phonenumber,role) VALUES(?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement st = conn.prepareStatement(update);
    st.setString(1, userID);
    st.setString(2, email);
    st.setString(3, password);
    st.setString(4, name);
    st.setString(5, dob);
    st.setString(6, gender);
    st.setString(7, address);
    st.setString(8, postcode);
    st.setString(9, phonenumber);
    st.setString(10, role);
    st.execute();
}     
     
public void updateUserRecord(String userID, String email, String password, String name, String dob, String gender, String address, String postcode, String phonenumber, String role) throws SQLException {
    String update = "UPDATE IOTUSER.USERRECORD SET userID = ?, email = ?, password = ?, name = ?, dob = ?, gender = ?, address = ?, postcode = ?, phonenumber = ?, role = ? WHERE email = ? ";
    PreparedStatement st = conn.prepareStatement(update);
    st.setString(1, userID);
    st.setString(2, email);
    st.setString(3, password);
    st.setString(4, name);
    st.setString(5, dob);
    st.setString(6, gender);
    st.setString(7, address);
    st.setString(8, postcode);
    st.setString(9, phonenumber);
    st.setString(10, role);
    st.execute();
    
}     
    
public void deleteUserRecord() {
    
}
    
public ArrayList<UserRecord> fetchUserRecord() throws SQLException{
   ArrayList<UserRecord> userrecords = new ArrayList(); 
   return userrecords;
}

}
