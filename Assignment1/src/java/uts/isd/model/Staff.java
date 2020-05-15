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
public class Staff extends User {
    String position;
    String dateHired;
    double salary;
    
    public Staff(String fName, String lName, String email, String phoneNo, String password, String position, String dateHired, double salary) {
        super(fName, lName, email, phoneNo, password);
        this.position = position;
        this.dateHired = dateHired;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDateHired() {
        return dateHired;
    }

    public double getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
