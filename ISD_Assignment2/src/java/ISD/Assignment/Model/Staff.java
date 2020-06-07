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
public class Staff {
    
    private char position;
    private String dateHired;
    private double salary;

    public Staff(char position, String dateHired, double salary) {
        this.position = position;
        this.dateHired = dateHired;
        this.salary = salary;
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
            
}
