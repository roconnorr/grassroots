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
    private Employee employee;
    private Customer customer;
    private Date date;
    private enum Frequency {WEEKLY, FORTNIGHTLY, MONTHLY};
    private Frequency frequency;
    private String description;

    public Job(Double chargeRate, Employee employee, Date date, Frequency frequency, String description) {
        this.chargeRate = chargeRate;
        this.employee = employee;
        this.date = date;
        this.frequency = frequency;
        this.description = description;
    }

    

    public Double getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(Double chargeRate) {
        this.chargeRate = chargeRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
