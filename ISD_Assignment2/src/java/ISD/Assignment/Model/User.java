/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISD.Assignment.Model;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CristinaFidelino
 */
public class User implements Serializable {
    private int userID;
    private String email;
    private String password;
    private String name;
    private String dob;
    private String gender;
    private String address;
    private String postcode;
    private String phoneNumber;

    public User(int userID, String email, String password, String name, String dob, String gender, String address, String postcode, String phoneNumber) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
    }


    
    
    /*public static void updateUser(HttpServletRequest request, HttpSession session, User user)
    {
    int userID = request.getParameter("userID");
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    String dob = request.getParameter("dob");
    String password = request.getParameter("password");
    String gender = request.getParameter("gender");
    String address = request.getParameter("address");
    String postcode = request.getParameter("postcode");
    String phoneNumber = request.getParameter("phoneNumber");
    user = new User(userID, email, password, name, dob, gender, address, postcode, phoneNumber);
    session.setAttribute("user",user);
    }*/
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
