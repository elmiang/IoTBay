/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ISD.Assignment.Model.Product;
import java.util.ArrayList;

/**
 *
 * @author jacks
 */
public class ProductDao {
    private Statement st;
    private Connection conn;
    
    public ProductDao(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
    
    public ArrayList<Product> fetchProducts() throws SQLException {
        ArrayList<Product> products = new ArrayList();
        String fetch = "Select * from IOTUSER.Product";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int productId = rs.getInt(1);
            String productName = rs.getString(2);
            String productType = rs.getString(3);
            String productDesc = rs.getString(4);
            int productQuantity = rs.getInt(5);
            boolean productAvailability = rs.getBoolean(6);
            double productPrice = rs.getDouble(7);
            products.add(new Product(productId, productName, productType, productDesc, productQuantity, productAvailability, productPrice));
        }
        return products;
    }
}
