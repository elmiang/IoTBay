/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.controller;
 
import ISD.Assignment.Model.AccessLogs;
import java.util.*;

import java.util.logging.*;
import ISD.Assignment.Model.User;
import ISD.Assignment.Model.Dao.*;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;

    public static void main(String[] args) throws SQLException{
        (new TestDB()).runQueries();
    }

    public TestDB(){
        try{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
            } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException{
        char c;

        while((c = readChoice()) != '*'){
            switch(c){
            case 'C':
            testAdd();
            break;
            case 'R':
            testRead();
            break;
            case 'U':
            testUpdate();
            break;
            case 'D':
            testDelete();
            break;
            case 'S':
            testAccessAog();
            break;
            case 'B':
            testFetchAccess(6);
            break;
            default:
            System.out.println("Unknown Command");

            }
        }
    }
    
    private void testFetchAccess(int id) throws SQLException{
        ArrayList<AccessLogs> accessLogs = db.fetchAccessLogs(id);
        for(AccessLogs t : accessLogs){
            System.out.println(t.getUserId());
            System.out.println(t.getVisitId());
            System.out.println(t.getLoginTime());
            System.out.println(t.getLogoutTime());
        }
    }
    
    
    private void testAccessAog(){
        String time = new Date().toString();
        try {
            db.addAccessLogLoginTime(10, time);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    private void testRead(){
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        try{
            User user = db.findUser(email, password);
            System.out.print(user.getName());
            System.out.print(user.getPhoneNumber());
            System.out.print(user.getPostcode());
            System.out.print(user.getUserID());
            System.out.print(user.getAddress());
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testUpdate(){
        
        System.out.print("Email: ");
        String email = in.nextLine();
        
        System.out.print("Password: ");
        String password = in.nextLine();        
        
        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("dob: ");
        String dob = in.nextLine();
        
        System.out.print("Gender: ");
        String gender = in.nextLine();

        System.out.print("address: ");
        String address = in.nextLine();

        System.out.print("post code: ");
        String postCode = in.nextLine();

        System.out.print("phone: ");
        String phone = in.nextLine();
        
        try{
                db.updateUser(email, password, name, dob, gender, address, postCode, phone);
        }   catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete(){
        System.out.print("Email: ");
        String email = in.nextLine();
        try{
                db.deleteUser(email);
        }   catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void testAdd(){
        System.out.print("Email: ");
        String email = in.nextLine();
        
        System.out.print("Password: ");
        String password = in.nextLine();
                
        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("dob: ");
        String dob = in.nextLine();
        
        System.out.print("Gender: ");
        String gender = in.nextLine();

        System.out.print("address: ");
        String address = in.nextLine();

        System.out.print("post code: ");
        String postCode = in.nextLine();

        System.out.print("phone: ");
        String phone = in.nextLine();
                 
        try{
            db.addUser(email, password, name, dob, gender, address, postCode, phone);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("User is added to the database");

    }

      
        

}