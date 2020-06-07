/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model;

import java.util.ArrayList;

/**
 *
 * @author jacks
 */
public class ShoppingCart {
    private ArrayList<Product> cart = new ArrayList<Product>();
    private int quantity = 0;
    private int noItems = 0;
    private double itemsPrice = 0;
    private double shippingPrice = 0;
    private double totalPrice = 0;
    
    public ShoppingCart(){}
    
    public void addProduct(Product product){
        cart.add(product);
    }
    
    public void removeProduct(Product product){
        cart.remove(product);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public int getNumberOfItems() {
        noItems = cart.size();
        return noItems;
    }

    public double getItemsPrice() {
        for(Product p: cart){
            itemsPrice += p.getPrice();
        }
        return itemsPrice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public double getTotalPrice() {
        totalPrice = shippingPrice + itemsPrice;
        return totalPrice;
    }
    
}
