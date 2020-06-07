/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ISD.Assignment.Model.Order;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author SOMESH
 */
public class OrderDao {
    private Statement st;
    
public OrderDao(Connection conn) throws SQLException {        
   st = conn.createStatement();   
}


//Add a user-data into the database    
public void addOrder(int orderID, String orderDate, String orderStatus, int userID) throws SQLException {       
  st.executeUpdate("INSERT INTO IOTUSER.ORDERTABLE" + "VALUES ('" + orderID + "','" + orderDate + "','" + orderStatus + "', + '" + userID + "')");    
  
}

//update a user details in the database    
public void updateOrder(int orderID, String orderDate, String orderStatus, int userID) throws SQLException {     
   st.executeUpdate("UPDATE ISDUSER.ORDERTABLE SET NAME='" + orderID + "','" + orderDate + "','" + orderStatus + "', + '" + userID + "')");  

}       

//delete a user from the database    
public void deleteOrder(int orderID) throws SQLException{        
   st.executeUpdate("DELETE FROM ISD.USER WHERE ORDERID='" + orderID + "'");
}

public Order findOrder(int orderID, String orderDate) throws SQLException {
   String fetch = "select * from ISDUSER.ORDERTABLE WHERE ORDERID = '" + orderID + "' and ORDERDATE='" + orderDate + "'";
   ResultSet rs = st.executeQuery(fetch);
  
   while (rs.next()) {
       int orderId = rs.getInt(1);
       String orderdate = rs.getString(3);
       if(orderId == orderID && orderdate.equals(orderDate)) {
           int userid = rs.getInt(2);
           String orderStatus = rs.getString(4);
           return new Order(orderId, orderdate, orderStatus, userid);
       }
   }
   return null;
}

public ArrayList<Order> fetchOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList();
        String fetch = "Select * from IOTUSER.ORDERTABLE";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int orderId = rs.getInt(1);
            String orderdate = rs.getString(2);
            String orderStatus = rs.getString(3);
            int userid = rs.getInt(4);
            orders.add(new Order(orderId, orderdate, orderStatus, userid));
        }
        return orders;
    }
   
   
   
   
   
}




