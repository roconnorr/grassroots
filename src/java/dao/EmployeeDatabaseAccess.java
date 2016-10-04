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
import domain.Employee;
import domain.Job;
import domain.Job.Frequency;
import java.sql.Timestamp;
import java.util.Date;

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
        String sql = "insert into employees (name, username, password, email, phonenumber) values (?,?,?,?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, e.getName());
                stmt.setString(2, e.getUserName());
                stmt.setString(3, e.getPassword());
                stmt.setString(4, e.getEmail());
                stmt.setString(5, e.getPhoneNumber());
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
                    Employee e = new Employee(customerID, name, username, password, email, phonenumber);
                    employees.add(e);
                }
                return employees;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Employee getEmployeeUserName(String searchUsername){
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
                    Employee e = new Employee(customerID, name, username, password, email, phonenumber);
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
}