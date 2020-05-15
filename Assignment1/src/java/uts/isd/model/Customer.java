/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author jacks
 */
public class Customer extends User {
    String billingAddress;
    int cardNumber;
    int cvv;
    String cardType;
    String cardExpiry;
    public Customer(String fName, String lName, String email, String phoneNo, String password, int cardNumber, int cvv, String cardType, String cardExpiry) {
        super(fName, lName, email, phoneNo, password);
        this.billingAddress = billingAddress;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardType = cardType;
        this.cardExpiry = cardExpiry;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }
    
}
