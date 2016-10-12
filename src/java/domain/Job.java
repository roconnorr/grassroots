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
    private Integer jobID;
    private Double chargeRate;
    private Integer employeeID;
    private Integer customerID;
    private String date;
    public enum Frequency {Weekly, Fortnightly, Monthly};
    private Frequency frequency;
    private String description;
    public enum Status {Complete, Incomplete};
    private Status status; //make enum?

    public Job(Integer jobID, Double chargeRate, Integer employeeID, Integer customerID, String date, Frequency frequency, String description, Status status) {
        this.jobID =  jobID;
        this.chargeRate = chargeRate;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.date = date;
        this.frequency = frequency;
        this.description = description;
        this.status = status;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
