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
public class Admin extends User {
    String dateHired;
    double salary;

    public Admin(String fName, String lName, String email, String phoneNo, String password, String dateHired, double salary) {
        super(fName, lName, email, phoneNo, password);
        this.dateHired = dateHired;
        this.salary = salary;
    }

    public String getDateHired() {
        return dateHired;
    }

    public double getSalary() {
        return salary;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
