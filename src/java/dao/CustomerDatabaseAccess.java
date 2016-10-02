/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import domain.Customer;

/**
 *
 * @author Rory
 */
public class CustomerDatabaseAccess {


    private String url = "jdbc:h2:tcp://localhost:9013/soultest;IFEXISTS=TRUE";

    public CustomerDatabaseAccess() {
    }

    public CustomerDatabaseAccess(String altUrl) {
        url = altUrl;
    }

    public void saveCustomer(Customer c) {
        String sql = "merge into customers (name, address, email, phonenumber, sectionsize) values (?,?,?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, c.getName());
                stmt.setString(2, c.getAddress());
                stmt.setString(3, c.getEmail());
                stmt.setString(4, c.getPhoneNumber());
                stmt.setString(4, c.getSectionSize());
                stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Collection<Customer> getCustomers() {
        String sql = "select * from customers order by name";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                ResultSet rs = stmt.executeQuery();
                List<Customer> customers = new ArrayList<>();
                while (rs.next()) {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phonenumber");
                    String sectionSize = rs.getString("sectionsize");
                    Customer c = new Customer(name, address, email, phoneNumber, sectionSize);
                    customers.add(c);
                }
                return customers;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /*
    public Customer searchCustomerName(String name) {
        String sql = "select * from products where productid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {                  
                    Integer productID = rs.getInt("productid");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String category = rs.getString("category");
                    Double price = rs.getDouble("price");
                    Integer quantityInStock = rs.getInt("quantity");
                    Product p = new Product(productID, name, description, category, price, quantityInStock);
                    return p;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    */

    /*
    public void deleteCustomer(Customer c) {
        String sql = "delete from customers where productid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, c.getProductID());
                stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }*/
    
    //edit customer method
}