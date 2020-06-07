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
public class Customer {
    
    private int userID;
    private String billlingAddress;
    private int cardNumber;
    private char cardType;
    private String cardExpiry;
    private int ccv;

    public Customer(int userID, String billlingAddress, int cardNumber, char cardType, String cardExpiry, int ccv) {
        this.userID = userID;
        this.billlingAddress = billlingAddress;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardExpiry = cardExpiry;
        this.ccv = ccv;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getBilllingAddress() {
        return billlingAddress;
    }

    public void setBilllingAddress(String billlingAddress) {
        this.billlingAddress = billlingAddress;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public char getCardType() {
        return cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    

}
