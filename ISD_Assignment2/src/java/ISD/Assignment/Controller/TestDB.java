package ISD.Assignment.Controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import ISD.Assignment.Model.Dao.DBConnector;
import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.OrderDao;
import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Product;
import ISD.Assignment.Model.Order;

 

public class TestDB {
private static Scanner in = new Scanner(System.in);
private DBConnector connector;
private Connection conn;
private DBManager db;
private ProductDao pd;
private OrderDao od;

public static void main(String[] args) throws SQLException {
    (new TestDB()).runQueries();
}

public TestDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        pd = new ProductDao(conn);
        od = new OrderDao(conn);
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
                testAddOrder();
                break;
            case 'R':
                testRemoveOrder();
                break;
            case 'U':
                testUpdateOrder();
                break;
            case 'S':
                testShowOrders();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAddOrder(){
    System.out.print("User ID: ");
    int user = in.nextInt();
    in.nextLine();

    System.out.print("date: ");
    String date = in.nextLine();
    
    
    System.out.print("Status:");
    String status= in.nextLine();

    

   
    try {
        od.addOrder(user, date, status);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("User is added to the database.");
} 

private void testAddProduct(){
    System.out.print("Product Name: ");
    String name = in.nextLine();
    
    System.out.print("Product Type: ");
    String type = in.nextLine();
    
    System.out.print("Quantity: ");
    int quantity = in.nextInt();
    in.nextLine();
    
    System.out.print("Price: ");
    double price = in.nextDouble();
    in.nextLine();
    
    try{
        pd.addProduct(name, type, quantity, price);
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Product is added to the database.");
}

private void testUpdateOrder(){
    System.out.print("User ID : ");
    int id = in.nextInt();
    in.nextLine();
    
    System.out.print("Date: ");
    String date = in.nextLine();
    
    System.out.print("Status: ");
    String status = in.nextLine();
    
 
    
    try{
       od.updateOrder(id, date, status); 
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
    System.out.println("Product removed from the database.");
}

private void testShow(){
    try {
        ArrayList<Product> products = pd.fetchProducts();
        System.out.println("PRODUCTS TABLE: ");
        for(Product p: products){
            System.out.println(p.getProductName());
            }    
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void testRead() throws SQLException{
    System.out.print("Order id: ");
    int id = in.nextInt();
    System.out.print("Order date: ");
    String date = in.nextLine();
    ArrayList<Order> orders = od.searchOrder(id,date);
    if (orders != null){
        for(Order o: orders){
            System.out.println(o.getOrderStatus());
        }
    }
    else{
        System.out.println("Order does not exist");
    }
}
private void testShowOrders(){
    try {
        ArrayList<Order> orders = od.fetchOrders();
        System.out.println("ORDER TABLE: ");
        for(Order o: orders){
            System.out.println(o.getOrderID());
            System.out.println(o.getUserID());
            System.out.println(o.getOrderDate());
            System.out.println(o.getOrderStatus());
            }    
    } catch (SQLException ex) {
        Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}