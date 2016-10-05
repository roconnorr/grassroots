/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import domain.Job;
import domain.Job.Frequency;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Rory
 */
public class JobDatabaseAccess {

 
    static private String url = "jdbc:mysql://192.168.178.21:3306/grassroots";

    public JobDatabaseAccess() {
    }

    public JobDatabaseAccess(String altUrl) {
        url = altUrl;
    }

    public void saveJob(Job j) {
        String sql = "insert into jobs (chargerate, employeeid, customerid, date, frequency, description, status) values (?,?,?,?,?,?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setDouble(1, j.getChargeRate());
                stmt.setInt(2, j.getEmployeeID());
                stmt.setInt(3, j.getCustomerID());
                stmt.setString(4, j.getDate());
                stmt.setString(5, j.getFrequency().toString());
                stmt.setString(6, j.getDescription());
                stmt.setString(7, j.getStatus());
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Collection<Job> getJobs() {
        String sql = "select * from jobs order by date";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                ResultSet rs = stmt.executeQuery();
                List<Job> jobs = new ArrayList<>();
                
                
                while (rs.next()) {
                    Integer jobID = rs.getInt("jobid");
                    double chargerate = rs.getDouble("chargerate");
                    Integer employeeID = rs.getInt("employeeid");
                    Integer customerID = rs.getInt("customerid");
                    String date = rs.getString("date");
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    String status = rs.getString("status");
                    Job j = new Job(jobID, chargerate, employeeID, customerID, date, frequency, description, status);
                    jobs.add(j);
                }
                return jobs;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Job searchJobID(Integer searchID){
        String sql = "select * from jobs where jobid = ?";
        
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, searchID);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {                  
                    Integer jobID = rs.getInt("jobid");
                    double chargerate = rs.getDouble("chargerate");
                    Integer employeeID = rs.getInt("employeeid");
                    Integer customerID = rs.getInt("customerid");
                    String date = rs.getString("date");
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    String status = rs.getString("status");
                    Job j = new Job(jobID, chargerate, employeeID, customerID, date, frequency, description, status);
                    return j;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public void deleteJob(Integer jobid) {
        String sql = "delete from jobs where jobid = ?";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, jobid);
                stmt.executeUpdate();
        }catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}