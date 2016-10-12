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
import domain.Employee;

/**
 *
 * @author Rory
 */
public class EmployeeDatabaseAccess {


    static private String url = "jdbc:mysql://192.168.178.21:3306/grassroots";

    public EmployeeDatabaseAccess() {
    }

    public EmployeeDatabaseAccess(String altUrl) {
        url = altUrl;
    }

    public void saveEmployee(Employee e) {
        String sql = "insert into employees (name, username, password, email, phonenumber, message) values (?,?,?,?,?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, e.getName());
                stmt.setString(2, e.getUserName());
                stmt.setString(3, e.getPassword());
                stmt.setString(4, e.getEmail());
                stmt.setString(5, e.getPhoneNumber());
                stmt.setString(6, e.getMessage());
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Collection<Employee> getEmployees() {
        String sql = "select * from employees order by name";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                ResultSet rs = stmt.executeQuery();
                List<Employee> employees = new ArrayList<>();
                
                
                while (rs.next()) {
                    Integer customerID = rs.getInt("employeeid");
                    String name = rs.getString("name");
                    String username = rs.getString("username");
                    String password = rs.getString("password"); //possibly remove
                    String email = rs.getString("email");
                    String phonenumber = rs.getString("phonenumber");
                    String message = rs.getString("message");
                    Employee e = new Employee(customerID, name, username, password, email, phonenumber, message);
                    employees.add(e);
                }
                return employees;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Employee searchEmployeeUserName(String searchUsername){
        String sql = "select * from employees where username = ?";
        
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, searchUsername);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {                  
                    Integer customerID = rs.getInt("employeeid");
                    String name = rs.getString("name");
                    String username = rs.getString("username");
                    String password = rs.getString("password"); //possibly remove
                    String email = rs.getString("email");
                    String phonenumber = rs.getString("phonenumber");
                    String message = rs.getString("message");
                    Employee e = new Employee(customerID, name, username, password, email, phonenumber, message);
                    return e;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Employee searchEmployeeID(Integer searchID){
        String sql = "select * from employees where employeeid = ?";
        
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, searchID);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {                  
                    Integer customerID = rs.getInt("employeeid");
                    String name = rs.getString("name");
                    String username = rs.getString("username");
                    String password = rs.getString("password"); //possibly remove
                    String email = rs.getString("email");
                    String phonenumber = rs.getString("phonenumber");
                    String message = rs.getString("message");
                    Employee e = new Employee(customerID, name, username, password, email, phonenumber, message);
                    return e;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public String getPasswordHash(String searchUsername){
        String sql = "select * from employees where username = ?";
        
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, searchUsername);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {
                    String password = rs.getString("password");
                    return password;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public void deleteEmployee(Integer employeeID) {
        String sql = "delete from employees where employeeid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, employeeID);
                stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public void updateEmployee(Integer employeeID, String name, String email, String phoneNumber) {
        String sql = "update employees set name = ?, email = ?, phonenumber = ? where employeeid = ?";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phoneNumber);
                stmt.setInt(4, employeeID);
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}