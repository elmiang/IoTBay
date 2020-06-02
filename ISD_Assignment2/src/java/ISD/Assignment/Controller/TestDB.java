package ISD.Assignment.Controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import ISD.Assignment.Model.Dao.DBConnector;
import ISD.Assignment.Model.Dao.DBManager;
import ISD.Assignment.Model.Dao.ProductDao;
import ISD.Assignment.Model.Product;

 

public class TestDB {
private static Scanner in = new Scanner(System.in);
private DBConnector connector;
private Connection conn;
private DBManager db;
private ProductDao pd;

public static void main(String[] args) throws SQLException {
    (new TestDB()).runQueries();
}

public TestDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        pd = new ProductDao(conn);
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
                testAdd();
                break;
            case 'D':
                testAddProduct();
                break;
            case 'R':
                testRemoveProduct();
                break;
            case 'S':
                testShow();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
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
    try {
        db.addUser(id, email, password, name, dob, gender, address, postcode, phoneNumber);
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

private void testRemoveProduct(){
    System.out.print("Product Name: ");
    String name = in.nextLine();
    
    try{
        pd.removeProduct(name);
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
    System.out.print("Product name: ");
    String name = in.nextLine();
    ArrayList<Product> products = pd.searchProducts(name);
    if (products != null){
        for(Product p: products){
            System.out.println(p.getProductName());
        }
    }
    else{
        System.out.println("Product does not exist");
    }
}

}