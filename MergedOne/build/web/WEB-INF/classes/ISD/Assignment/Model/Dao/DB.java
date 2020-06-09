/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model.Dao;

import java.sql.Connection;

/**
 *
 * @author jacks
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "iotdb";
    protected String dbuser = "iotuser";
    protected String dbpass = "password";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
