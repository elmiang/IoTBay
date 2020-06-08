
package uts.isd.model.dao;

import uts.isd.model.shipment;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public shipment findShipment(Integer shipmentID, String date) throws SQLException {       
   String fetch = "select * from ISDUSER.SHIPMENT where shipmentID =" +shipmentID+" and startDate ='" +date+"'";
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
public void addShipment(String prefname, String email,Integer phone,String address,String city,String stats,Integer postCode,String date, String shipmentMethod  ) throws SQLException {                   //code for add-operation       
 
    st.executeUpdate("INSERT INTO ISDUSER.SHIPMENT (prefername, email, phone_number,address,city,territory,post_code,startdate,shipmentmethod)" +
"VALUES ('"+prefname+"','"+email+"',"+phone+",'"+address+"','"+city+"','"+stats+"',"+postCode+",'"+date+"','"+shipmentMethod+"'");   

}

//update a user details in the database   
public void updateUser( Integer shipmentID, String prefname, String email,Integer phone,String address,String city,String stats,Integer postCode,String date, String shipmentMethod) throws SQLException {       
    st.executeUpdate("UPDATE ISDUSER.SHIPMENT SET prefername= '"+prefname+"' , email='"+email+"', phone_number ="+phone+""
                        + ",address = '"+address+"',city = '"+city+"',territory='"+stats+"',\n" +
"                         post_code="+postCode+",startdate='"+date+"',shipmentmethod='"+shipmentMethod+"' where shipmentID ="+shipmentID+" ;");

}       

//delete a user from the database   
public void deleteUser(Integer shipmentID) throws SQLException{       
  st.executeUpdate("DELETE FROM ISDUSER.SHIPMENT WHERE SHIPMENTID= "+shipmentID+"");

}

public ArrayList<shipment> fectUsers() throws SQLException{
    String fetch = "SELECT * FROM SHIPMENT";
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
    String fect = "SELECT * FROM ISDUSER.SHIPMENT WHERE SHIPMENTID = " +shipmentID+ " and startdate='"+date+"'";
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


}