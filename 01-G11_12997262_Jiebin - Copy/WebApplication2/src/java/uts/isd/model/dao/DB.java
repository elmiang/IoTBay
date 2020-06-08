package uts.isd.model.dao;

import java.sql.Connection;

/** 
* Super class of DAO classes that stores the database information 
*  
*/

public abstract class DB {   

protected String URL = "jdbc:derby://localhost:1527/usersdb";//replace this string with your jdbc:derby local host url   
protected String db = "usersdb";//name of the database   
protected String dbuser = "isduser";//db root user   
protected String dbpass = "jiebin"; //db root password   
protected String driver = "org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
protected Connection conn; //connection null-instance to be initialized in sub-classes

}
