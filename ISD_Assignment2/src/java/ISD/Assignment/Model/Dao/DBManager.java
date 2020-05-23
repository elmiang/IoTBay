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
        String read = "SELECT * FROM ISDUSER.Users WHERE EMAIL='" + email + "' " + " AND PASSWORD=" + password;
        ResultSet rs = st.executeQuery(read);
        
        while(rs.next()){
            String userEmail = rs.getString(1);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)){
                String userName = rs.getString(2);
                String userDOB = rs.getString(4);
                String userFavCol = rs.getString(5);
                return new User (userEmail, userName, userPass, userDOB, userFavCol);
            }
        }
        return null;
    }
    
    public void addUser(String email, String name, String password, String dob, String favcol) throws SQLException{
        st.executeUpdate("INSERT INTO ISDUSER.Users " + "VALUES ('" + email + "', '" + name + "', " + password + "', " + dob + "', " + favcol + "')");
    }
    
    public void updateUser(String email, String name, String password, String dob, String favcol) throws SQLException{
        st.executeUpdate("UPDATE ISDUSER.Users SET NAME='" + name + "', PASSWORD='" + password + "', DOB='" + dob + "', FAVCOL='" + favcol + "' WHERE EMAIL='" + email + "'");
    }
    
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDUSER.Users WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "select * from USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
        while (rs.next()){
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String dob = rs.getString(4);
            String favcol = rs.getString(5);
            temp.add(new User(email, name, password, dob, favcol));
        }
        return temp;
    }
}
