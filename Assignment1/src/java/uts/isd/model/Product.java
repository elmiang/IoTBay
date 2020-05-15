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
public class Product {
    String name;
    String type;
    String desc;
    int availableQuantity;
    String availability;
    double price;

    public Product(String name, String type, String desc, int availableQuantity, String availability, double price) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.availableQuantity = availableQuantity;
        this.availability = availability;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getAvailability() {
        return availability;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
