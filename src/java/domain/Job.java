/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Rory
 */
public class Job {
    private Double chargeRate;
    private Integer employeeID;
    private Integer customerID;
    private String date;
    public enum Frequency {WEEKLY, FORTNIGHTLY, MONTHLY};
    private Frequency frequency;
    private String description;
    private String status; //make enum?

    public Job(Double chargeRate, Integer employeeID, Integer customerID, String date, Frequency frequency, String description, String status) {
        this.chargeRate = chargeRate;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.date = date;
        this.frequency = frequency;
        this.description = description;
        this.status = status;
    }

    
    public Double getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(Double chargeRate) {
        this.chargeRate = chargeRate;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

}
