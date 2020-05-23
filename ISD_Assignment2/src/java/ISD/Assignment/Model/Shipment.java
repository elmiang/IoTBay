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
public class Shipment {
    
    private int shipmentID;
    private String startDate;
    private String estArrivalDate;
    private String deliveryAddress;
    private String currentStatus;

    public Shipment(int shipmentID, String startDate, String estArrivalDate, String deliveryAddress, String currentStatus) {
        this.shipmentID = shipmentID;
        this.startDate = startDate;
        this.estArrivalDate = estArrivalDate;
        this.deliveryAddress = deliveryAddress;
        this.currentStatus = currentStatus;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEstArrivalDate() {
        return estArrivalDate;
    }

    public void setEstArrivalDate(String estArrivalDate) {
        this.estArrivalDate = estArrivalDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    
    
           
}
