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
    
    private int id;
    private String billlingAddress;
    private int cardNumber;
    private int ccv;
    private String cardType;
    private String cardExpDate;

    public Customer(int id, String billlingAddress, int cardNumber, int ccv, String cardType, String cardExpDate) {
        this.id = id;
        this.billlingAddress = billlingAddress;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.cardType = cardType;
        this.cardExpDate = cardExpDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }
}
