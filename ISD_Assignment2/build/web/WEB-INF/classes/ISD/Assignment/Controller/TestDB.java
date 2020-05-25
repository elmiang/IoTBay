package ISD.Assignment.Controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import ISD.Assignment.Model.Dao.DBConnector;
import ISD.Assignment.Model.Dao.DBManager;

 

public class TestDB {
private static Scanner in = new Scanner(System.in);

public static void main(String[] args) {

try {
DBConnector connector = new DBConnector();
Connection conn = connector.openConnection();
DBManager db = new DBManager(conn);

System.out.print("User ID: ");
String id = in.nextLine();

System.out.print("User email: ");
String email = in.nextLine();

System.out.print("User password: ");
String password = in.nextLine();

System.out.print("User name: ");
String name = in.nextLine();

System.out.print("User DOB: ");
String dob = in.nextLine();

System.out.print("User gender: ");
String gender = in.nextLine();

System.out.print("User address: ");
String address = in.nextLine();

System.out.print("User postcode: ");
String postcode = in.nextLine();

System.out.print("User phone number: ");
String phoneNumber = in.nextLine();

db.addUser(id, email, password, name, dob, gender, address, postcode, phoneNumber);

System.out.println("User is added to the database.");
connector.closeConnection();

} 
catch (ClassNotFoundException | SQLException ex) {

Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}