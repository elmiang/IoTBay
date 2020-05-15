/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author jacks
 */
public class User implements Serializable {
    private String fName;
    private String lName;
    private String email;
    private String phoneNo;
    private String password;

    public User(String fName, String lName, String email, String phoneNo, String password){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
    
    public String getFName(){
        return fName;
    }   
    public void setFName(String fName){
        this.fName = fName;
    }
    public String getLName(){
        return lName;
    }   
    public void setLName(String LName){
        this.lName = lName;
    }
    public String getEmail(){
        return email;
    }   
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNo(){
        return phoneNo;
    }   
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public String getPassword(){
        return password;
    }   
    public void setPassword(String password){
        this.password = password;
    }
}
