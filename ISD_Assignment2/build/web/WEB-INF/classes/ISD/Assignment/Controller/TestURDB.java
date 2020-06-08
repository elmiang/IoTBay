package ISD.Assignment.Controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import ISD.Assignment.Model.Dao.DBConnector;
import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.UserRecordDao;
import ISD.Assignment.Model.UserRecord;

 

public class TestURDB {
private static Scanner in = new Scanner(System.in);
private DBConnector connector;
private Connection conn;
private DBManager db;
private UserRecordDao ud;

public static void main(String[] args) throws SQLException {
    (new TestURDB()).runQueries();
}

public TestURDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        ud = new UserRecordDao(conn);
    }
    catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private char readChoice(){
    System.out.print("Operation CDRUDS or * to exit: ");
    return in.nextLine().charAt(0);
}

private void runQueries() throws SQLException {
    char c;
    
    while ((c = readChoice()) != '*'){
        switch(c){
            case 'C':
                testURShow();
                break;
            case 'D':
                testURRead();
                break;
            case 'R':
                testAddUR();
                break;
            case 'U':
                testUpdateUR();
                break;
          
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testURShow() throws SQLException{
     try {
        ArrayList<UserRecord> ur = ud.fetchUserRecord();
        System.out.println("UR Email List: ");
        for(UserRecord p: ur){
            System.out.println(p.getEmail());
            }    
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

private void testURRead() throws SQLException{
    System.out.print("Name or Phone Number: ");
    String name = in.nextLine();
    
    ArrayList<UserRecord> ur = ud.searchUserRecord(name,name);
    if (ur != null){
        for(UserRecord p: ur){
            System.out.println(p.getName());
        }
    }
    else{
        System.out.println("Product does not exist");
    }
}

private void testAddUR(){
    System.out.print("Email: ");
    String email = in.nextLine();
    
    System.out.print("Password: ");
    String password = in.nextLine();
    
    System.out.print("Name: ");
    String name = in.nextLine();
        
    System.out.print("DoB: ");
    String dob= in.nextLine();
    
    System.out.print("Gender: ");
    String gender = in.nextLine();
    
    System.out.print("Address: ");
    String address = in.nextLine();
    
    System.out.print("Postcode: ");
    String postcode = in.nextLine();
    
    System.out.print("Phonenumber: ");
    String phoneNumber = in.nextLine();
    
    System.out.print("Role: ");
    String role = in.nextLine();
    
    
    
    try{
        ud.addUserRecord(email, password, name, dob, gender, address, postcode, phoneNumber, role);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("UR is added to the database.");
}
private void testUpdateUR(){
    System.out.print("UserID: ");
    String userID = in.nextLine();
    
   System.out.print("Email: ");
    String email = in.nextLine();
    
    System.out.print("Password: ");
    String password = in.nextLine();
    
    System.out.print("Name: ");
    String name = in.nextLine();
        
    System.out.print("DoB: ");
    String dob= in.nextLine();
    
    System.out.print("Gender: ");
    String gender = in.nextLine();
    
    System.out.print("Address: ");
    String address = in.nextLine();
    
    System.out.print("Postcode: ");
    String postcode = in.nextLine();
    
    System.out.print("Phonenumber: ");
    String phoneNumber = in.nextLine();
    
    System.out.print("Role: ");
    String role = in.nextLine();
    
    
    try{
       ud.updateUserRecord(userID,email, password, name, dob, gender, address, postcode, phoneNumber, role);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("UR updated.");
}

}
