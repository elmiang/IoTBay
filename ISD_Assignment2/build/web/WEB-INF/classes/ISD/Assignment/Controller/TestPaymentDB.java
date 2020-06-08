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
import ISD.Assignment.Model.Dao.PaymentDAO;
import ISD.Assignment.Model.Payment;
/**
 *
 * @author CristinaFidelino
 */
public class TestPaymentDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    private PaymentDAO pyd;

    public static void main(String[] args) throws SQLException {
        (new TestPaymentDB()).runQueries();
    }
    
    public TestPaymentDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new DBManager(conn);
        pyd = new PaymentDAO(conn);
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
                testShow();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
        System.out.print("Card Holder Name: ");
        String cardHolderName = in.nextLine();

        System.out.print("First Name: ");
        String firstName = in.nextLine();
        
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        
        System.out.print("Card Number: ");
        int cardNumber = in.nextInt();
        in.nextLine();
        
        System.out.print("Expiry Date: ");
        String expDate = in.nextLine();
        
        System.out.print("Paid Date: ");
        String paidDate = in.nextLine();

        System.out.print("Payment Method: ");
        String paymentMethod = in.nextLine();

        System.out.print("Paid Amount: ");
        double paidAmount = in.nextDouble();
        in.nextLine();
    
        try {
            pyd.addPayment(cardHolderName, firstName, lastName, cardNumber, expDate, paidDate, paymentMethod, paidAmount);
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Payment is added to the database.");
} 

    private void testRead() throws SQLException {
        System.out.print("Payment ID: ");
        String paymentID = in.nextLine();
        
        ArrayList<Payment> payment = pyd.searchPayment(paymentID);
        
        if (payment != null){
            for(Payment p: payment){
                System.out.println(p.getPaymentID());
            }
        }
        else {
            System.out.println("Payment does not exist");
        }  
    }
    
    private void testUpdate() throws SQLException {
        System.out.print("Payment ID: ");
        String paymentID = in.nextLine();
        
        try{
            if(pyd.checkPayment(paymentID)) {
                
                System.out.print("Card Holder Name: ");
                String cardHolderName = in.nextLine();

                System.out.print("First Name: ");
                String firstName = in.nextLine();
                
                System.out.print("Last Name: ");
                String lastName = in.nextLine();
                
                System.out.print("Card Number: ");
                int cardNumber = in.nextInt();
                
                System.out.print("Expiry Date: ");
                String expDate = in.nextLine();
                pyd.updatePayment(cardHolderName, firstName, lastName, cardNumber, expDate);
            } else {
                System.out.println("Payment ID does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() throws SQLException {
        System.out.print("Payment ID: ");
        String paymentID = in.nextLine();
        
        try{
            if(pyd.checkPayment(paymentID)) {
                pyd.deletePayment(paymentID);
            } else {
                System.out.println("Payment does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testShow() throws SQLException {
        try{
            ArrayList<Payment> payments = pyd.fetchPayments();
            System.out.println("PAYMENT TABLE: ");
            payments.stream().forEach((payment) -> {
                System.out.printf("%-20s %-30s %-20s %10s \n", payment.getPaymentID(), payment.getCardHolderName(), payment.getFirstName(), payment.getLastName(), payment.getCardNumber(), payment.getExpDate(), payment.getPaidDate(), payment.getPaymentMethod(), payment.getPaidAmount());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}