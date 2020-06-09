
package ISD.Assignment.Model.Dao;

import ISD.Assignment.Model.shipment;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class ShipmentManager {

private Statement st;
   
public ShipmentManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public shipment findShipment(int shipmentID, String date) throws SQLException {       
   String fetch = "select * from IOTUSER.SHIPMENT where shipmentID =" +shipmentID+" and startDate ='" +date+"'";
   ResultSet rs = st.executeQuery(fetch);
   
   while(rs.next()){
       Integer userShipmentID = rs.getInt(1);
       String userShipDate = rs.getString(10);
       if(userShipmentID.equals(shipmentID) && userShipDate.equals(date)){
           Integer userID = rs.getInt(2);
           String prefname = rs.getString(3);
           String email = rs.getString(4);
           Integer phone = rs.getInt(5);
           String address = rs.getString(6);
           String city = rs.getString(7);
           String stats = rs.getString(8);
           Integer postCode = rs.getInt(9);
           String shipmentMethod = rs.getString(11);
           String shipmentStatus = rs.getString(12);
              //             currentStatus
            
          return new shipment( userShipmentID, userID, prefname, email, phone, address, city, stats, postCode, userShipDate, shipmentMethod, shipmentStatus);
       }
   }
   
   return null;   
}

//Add a user-data into the database   
public void addShipment(String prefname, String email,Integer phone,String address,String city,String stats,Integer postCode,String date, String shipmentMethod) throws SQLException {                   //code for add-operation       
 
    st.executeUpdate("INSERT INTO IOTUSER.SHIPMENT (prefername, email, phone_number,address,city,territory,post_code,startdate,shipmentmethod,currentStatus)" +
"VALUES ('"+prefname+"','"+email+"',"+phone+",'"+address+"','"+city+"','"+stats+"',"+postCode+",'"+date+"','"+shipmentMethod+"','processing')");   

}

//update a user details in the database   
public void updateShipment( Integer shipmentID, String prefname, String email,Integer phone,String address,String city,String stats,Integer postCode,String date, String shipmentMethod) throws SQLException {       
    st.executeUpdate("UPDATE IOTUSER.SHIPMENT SET prefername= '"+prefname+"' , email='"+email+"', phone_number ="+phone+""
                        + ",address = '"+address+"',city = '"+city+"',territory='"+stats+"',\n" +
                          "post_code="+postCode+",startdate='"+date+"',shipmentmethod='"+shipmentMethod+"' where shipmentID ="+shipmentID+"");

}       



//delete a user from the database   
public void deleteShipment(Integer shipmentID) throws SQLException{       
  st.executeUpdate("DELETE FROM IOTUSER.SHIPMENT WHERE SHIPMENTID= "+shipmentID+"");

}

public ArrayList<shipment> fectShipment() throws SQLException{
    String fetch = "SELECT * FROM IOTUSER.SHIPMENT";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<shipment> temp = new ArrayList();
    
    while(rs.next()){
           Integer userShipmentID = rs.getInt(1);
           String userShipDate = rs.getString(10);
           Integer userID = rs.getInt(2);
           String prefname = rs.getString(3);
           String email = rs.getString(4);
           Integer phone = rs.getInt(5);
           String address = rs.getString(6);
           String city = rs.getString(7);
           String stats = rs.getString(8);
           Integer postCode = rs.getInt(9);
           String shipmentMethod = rs.getString(11);
           String shipmentStatus = rs.getString(12);
        temp.add(new shipment( userShipmentID, userID, prefname, email, phone, address, city, stats, postCode, userShipDate, shipmentMethod, shipmentStatus));
    }
    return temp;
}

public boolean checkUser(Integer shipmentID, String date) throws SQLException{
    String fect = "SELECT * FROM IOTUSER.SHIPMENT WHERE SHIPMENTID = " +shipmentID+ " and startdate='"+date+"'";
    ResultSet rs = st.executeQuery(fect);
    
    while(rs.next()){
           Integer userShipmentID = rs.getInt(1);
           String userShipDate = rs.getString(10);
        if(userShipmentID.equals(shipmentID) && userShipDate.equals(date)){
            return true;
        }
    }
    return false;
}

public String getCurrentStatus(Integer shipmentID) throws SQLException{
    String fect = "SELECT * FROM IOTUSER.SHIPMENT WHERE SHIPMENTID = " +shipmentID+ " ";
    ResultSet rs = st.executeQuery(fect);

    while(rs.next()){
           String currentStatus = rs.getString(12);
           return currentStatus;
    }
    return null;
}

}