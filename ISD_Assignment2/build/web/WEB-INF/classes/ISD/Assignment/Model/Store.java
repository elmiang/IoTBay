/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model;

/**
 *
 * @author CristinaFidelino
 */
public class Store {
    
    private int storeID;
    private String storeAddress;
    private String openingHours;

    public Store(int storeID, String storeAddress, String openingHours) {
        this.storeID = storeID;
        this.storeAddress = storeAddress;
        this.openingHours = openingHours;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
    
    
}
