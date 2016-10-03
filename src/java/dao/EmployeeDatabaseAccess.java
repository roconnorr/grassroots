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


    private String url = "jdbc:h2:tcp://localhost:9013/soultest;IFEXISTS=TRUE";

    public EmployeeDatabaseAccess() {
    }

    public EmployeeDatabaseAccess(String altUrl) {
        url = altUrl;
    }

    public void saveEmployee(Employee e) {
        String sql = "merge into employees (name, username, password, email, phonenumber) values (?,?,?,?,?)";
        
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
}