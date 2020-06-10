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
public void addOrder(String orderDate, String orderStatus, int userID) throws SQLException {       
  st.executeUpdate("INSERT INTO IOTUSER.ORDERTABLE(orderDate, orderStatus, userID)" + "VALUES ('" + orderDate + "','" + orderStatus + "', + " + userID + ")");    
 
}

//update a user details in the database    
public void updateOrder(String orderDate, String orderStatus, int orderID) throws SQLException {     
   st.executeUpdate("UPDATE IOTUSER.ORDERTABLE SET ORDERDATE ='" + orderDate + "' WHERE ORDERID =" + orderID + "");  

}  

public void updateStatus(String orderStatus, int orderID) throws SQLException {     
   st.executeUpdate("UPDATE IOTUSER.ORDERTABLE SET ORDERSTATUS='" + orderStatus + "' WHERE ORDERID =" + orderID +"" );  

}       

//delete a user from the database    
public void deleteOrder(int orderID) throws SQLException{        
   st.executeUpdate("DELETE FROM IOTUSER.ORDERTABLE WHERE ORDERID=" + orderID + "");
}

public Order findOrder(int userid) throws SQLException {
   String fetch = "select * from IOTUSER.ORDERTABLE WHERE USERID = " + userid + ""; 
   ResultSet rs = st.executeQuery(fetch);
  
   while (rs.next()) {
       int userID = rs.getInt(2);
       String orderdate = rs.getString(3);
       if(userid == userID) {
           int orderid = rs.getInt(1);
           String orderStatus = rs.getString(4);
           return new Order(orderid, orderdate, orderStatus,userid);
       }
   }
   return null;
}

public ArrayList<Order> fetchOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        String fetch = "Select * from IOTUSER.ORDERTABLE";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int orderId = rs.getInt(1);
            String orderdate = rs.getString(3);
            String orderStatus = rs.getString(4);
            int userid = rs.getInt(2);
            orders.add(new Order(orderId,orderdate, orderStatus,userid));
        }
        return orders;
    }
   
  public ArrayList<Order> searchOrder(int id) throws SQLException {
        ArrayList<Order> searchOrder = new ArrayList();
        String search = "Select * from IOTUSER.ORDERTABLE where USERID = " +id +"";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int orderid = rs.getInt(1);
            String orderdate = rs.getString(3);
            String status = rs.getString(4);
            int userid = rs.getInt(2);
           
            searchOrder.add(new Order(orderid, orderdate, status, userid));
        }
        if(searchOrder.size() > 0){
            return searchOrder;
        }
        else{
            return null;
        }
  }
   public ArrayList<Order> searchPastOrder(int id, String orderDate) throws SQLException {
        ArrayList<Order> searchOrder = new ArrayList();
        String search = "Select * from IOTUSER.ORDERTABLE where USERID = " +id +" AND ORDERDATE != '"+ orderDate +"' ";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int orderid = rs.getInt(1);
            String orderdate = rs.getString(3);
            String status = rs.getString(4);
            int userid = rs.getInt(2);
           
            searchOrder.add(new Order(orderid, orderdate, status, userid));
        }
        if(searchOrder.size() > 0){
            return searchOrder;
        }
        else{
            return null;
        }
    } 
   
   
   
}




