/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import ISD.Assignment.Model.Dao.DBConnector;
import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.OrderDao;
import ISD.Assignment.Model.Dao.PaymentDAO;
import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Payment;
import ISD.Assignment.Model.Order;

/**
 *
 * @author SOMESH
 */
public class TestOrderdb {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    private PaymentDAO pyd;
    private OrderDao od;

 public static void main(String[] args) throws SQLException {
    (new TestOrderdb()).runQueries();
}

public TestOrderdb(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        od = new OrderDao(conn);
    }
    catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private char readChoice(){
    System.out.print("Operation CDRUS or * to exit: ");
    return in.nextLine().charAt(0);
}

private void runQueries() throws SQLException {
    char c;
    
    while ((c = readChoice()) != '*'){
        switch(c){
            case 'C':
                testAdd();
                break;
            case 'D':
                testRead();
                break;
            case 'R':
                testRemoveOrder();
                break;
            case 'U':
                testUpdateOrder();
                break;
            case 'F':
                testFindOrder();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
    System.out.print("User ID: ");
    int id = in.nextInt();
    in.nextLine();

    System.out.print("Date: ");
    String date = in.nextLine();

    System.out.print("Order Status: ");
    String status = in.nextLine();

    
    try {
        od.addOrder(date, status, id);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("User is added to the database.");
} 



private void testUpdateOrder(){
    System.out.print("Date: ");
    String date = in.nextLine();
    
    System.out.print("Status: ");
    String status = in.nextLine();
    
    System.out.print("UserID: ");
    int id = in.nextInt();
    in.nextLine();
    
    
    
    try{
       od.updateOrder(date, status, id);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Order updated.");
}

private void testRemoveOrder(){
    System.out.print("Order id: ");
    int id = in.nextInt();
    in.nextLine();
    
    try{
       od.deleteOrder(id);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Order removed from the database.");
}

private void testShow(){
    try {
        ArrayList<Order> orders = od.fetchOrders();
        System.out.println("ORDERS TABLE: ");
        for(Order o: orders){
            System.out.println(o.getOrderStatus());
            }    
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void testRead() throws SQLException{
    System.out.print("User id: ");
    int id = in.nextInt();
    in.nextLine();
    System.out.print("Date: ");
    String date = in.nextLine();
    
    ArrayList<Order> orders = od.searchPastOrder(id, date);
    if (orders != null){
        for(Order o: orders){
            System.out.println(o.getOrderID());
            System.out.println(o.getOrderDate());
            System.out.println(o.getOrderStatus());
        }
    }
    else{
        System.out.println("Order does not exist");
    }
}
 private void testFindOrder() throws SQLException{
        System.out.print("User id: ");
        int id = in.nextInt();
        in.nextLine();
        try{
       od.findOrder(id);
       
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
        
    }


