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
    
    private String billlingAddress;
    private int cardNumber;
    private int ccv;
    private char cardType;
    private String cardExpDate;

    public Customer(String billlingAddress, int cardNumber, int ccv, char cardType, String cardExpDate) {
        this.billlingAddress = billlingAddress;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.cardType = cardType;
        this.cardExpDate = cardExpDate;
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

    public char getCardType() {
        return cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }
}
