/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Rory
 */
public class Customer {
    private Integer customerID;
    private String Name;
    private String address;
    private String email;
    private String phoneNumber;
    private String sectionSize;
    
    //collection of jobs?

    public Customer(Integer customerID, String Name, String address, String email, String phoneNumber, String sectionSize) {
        this.customerID = customerID;
        this.Name = Name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sectionSize = sectionSize;
    }
    

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSectionSize() {
        return sectionSize;
    }

    public void setSectionSize(String sectionSize) {
        this.sectionSize = sectionSize;
    }
}
