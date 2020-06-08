
package uts.isd.controller;

 

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.dao.*;
import uts.isd.model.shipment;

 

public class TestDB {

private static Scanner in = new Scanner(System.in);
private DBConnector connector;
private Connection conn;
private ShipmentManager db;
    
    public static void main(String[] args) throws SQLException{
        (new TestDB()).runQueires();
    }

    public TestDB(){
        try{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new ShipmentManager(conn);
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueires() throws SQLException{
        char c;
        
        while((c=readChoice())!='*'){
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
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
    

    private void testAdd() {
        System.out.print("prefname: ");
        String prefname = in.nextLine();
        System.out.print("email: ");
        String email = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("city: ");
        String city = in.nextLine();
        System.out.print("stats: ");
        String stats = in.nextLine();
        System.out.print("date: ");
        String date = in.nextLine();
        System.out.print("shipmentMethod: ");
        String shipmentMethod = in.nextLine();
        System.out.print("userPhone: ");
        String Phone = in.nextLine();
        int phone = Integer.parseInt(Phone);
        System.out.print("postCode: ");
        String post_Code = in.nextLine();
        int postCode = Integer.parseInt(post_Code);
        try{
            db.addShipment(prefname, email, phone, address, city, stats, postCode,date,shipmentMethod);
        }catch(SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Student is added to the database");
    }

    private void testRead() throws SQLException{
        System.out.print("id: ");
        Integer id = Integer.parseInt(in.nextLine());
        System.out.print("date: ");
        String date = in.nextLine();
        shipment shipment = db.findShipment(id, date);
        if(shipment != null){
            System.out.println("user " +shipment.getPreferName()+" in the database.");
        }else{
            System.out.println("student does not exist.");
        }
    }

    private void testUpdate() throws SQLException{
         System.out.print("id: ");
        Integer id = Integer.parseInt(in.nextLine());
        System.out.print("date: ");
        String date = in.nextLine();
         
         try{
             if(db.checkUser(id, date)){
                System.out.print("prefname: ");
                String prefname = in.nextLine();
                System.out.print("email: ");
                String email = in.nextLine();
                System.out.print("address: ");
                String address = in.nextLine();
                System.out.print("city: ");
                String city = in.nextLine();
                System.out.print("stats: ");
                String stats = in.nextLine();
                System.out.print("shipmentMethod: ");
                String shipmentMethod = in.nextLine();
                System.out.print("userPhone: ");
                String Phone = in.nextLine();
                int phone = Integer.parseInt(Phone);
                System.out.print("postCode: ");
                String post_Code = in.nextLine();
                int postCode = Integer.parseInt(post_Code);
                 db.updateShipment(id, prefname, email, phone, address, city, stats, postCode, date, shipmentMethod);
             }else{
                 System.out.println("no exist");
             }
         }catch(SQLException ex){
             Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void testDelete() throws SQLException{
         System.out.print("id: ");
        Integer id = Integer.parseInt(in.nextLine());
        System.out.print("date: ");
        String date = in.nextLine();
         
         try {
             if(db.checkUser(id, date)){
                 db.deleteShipment(id);
             }else{
                 System.out.println("no exist");
             }
         }catch(SQLException ex){
              Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }

    private void showAll() throws SQLException{
       try {
           ArrayList<shipment> shipments = db.fectShipment();
           System.out.println("user table: ");
           shipments.stream().forEach((shipment)->{
               System.out.printf("%-20s %-30s %-20s \n", shipment.getShipmentID(), shipment.getPreferName(), shipment.getAddress());
           });
         }catch(SQLException ex){
              Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}