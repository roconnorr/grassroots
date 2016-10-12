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
import domain.Job;
import domain.Job.Frequency;
import domain.Job.Status;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        
        Timestamp timestamp = Timestamp.valueOf(j.getDateTime());
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setDouble(1, j.getChargeRate());
                stmt.setInt(2, j.getEmployeeID());
                stmt.setInt(3, j.getCustomerID());
                stmt.setTimestamp(4, timestamp);
                stmt.setString(5, j.getFrequency().toString());
                stmt.setString(6, j.getDescription());
                stmt.setString(7, j.getStatus().toString());
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
                    LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    Status status = Status.valueOf(rs.getString("status"));
                    Job j = new Job(jobID, chargerate, employeeID, customerID, date, frequency, description, status);
                    jobs.add(j);
                }
                return jobs;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Collection<Job> getIncompleteJobs() {
        String sql = "select * from jobs where status = 'Incomplete' order by date";
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
                    LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    Status status = Status.valueOf(rs.getString("status"));
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
                    LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    Status status = Status.valueOf(rs.getString("status"));
                    Job j = new Job(jobID, chargerate, employeeID, customerID, date, frequency, description, status);
                    return j;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public void markJob(Integer jobID, Status status, LocalDateTime date){
        String sql = "update jobs set status = ?, date = date where jobid = ?";
        Timestamp timestamp = Timestamp.valueOf(date);
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, status.toString());
                //stmt.setTimestamp(2, timestamp);
                stmt.setInt(2, jobID);
                stmt.executeUpdate();
        }catch (SQLException ex) {
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
    
    public void updateJob(Job j) {
        String sql = "update jobs set chargerate = ?, employeeid = ?, customerid = ?, date = ?, frequency = ?, description = ?, status = ? where jobid = ?";
        Timestamp timestamp = Timestamp.valueOf(j.getDateTime());
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setDouble(1, j.getChargeRate());
                stmt.setInt(2, j.getEmployeeID());
                stmt.setInt(3, j.getCustomerID());
                stmt.setTimestamp(4, timestamp);
                stmt.setString(5, j.getFrequency().toString());
                stmt.setString(6, j.getDescription());
                stmt.setString(7, j.getStatus().toString());
                stmt.setInt(8, j.getJobID());
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Collection<Job> getIncompleteJobsByEmployeeID(Integer id) {
        String sql = "select * from jobs where status = 'Incomplete' and employeeid = ? order by date";
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                List<Job> jobs = new ArrayList<>();
                
                
                while (rs.next()) {
                    Integer jobID = rs.getInt("jobid");
                    double chargerate = rs.getDouble("chargerate");
                    Integer employeeID = rs.getInt("employeeid");
                    Integer customerID = rs.getInt("customerid");
                    LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
                    Frequency frequency = Frequency.valueOf(rs.getString("frequency"));
                    String description = rs.getString("description");
                    Status status = Status.valueOf(rs.getString("status"));
                    Job j = new Job(jobID, chargerate, employeeID, customerID, date, frequency, description, status);
                    jobs.add(j);
                }
                return jobs;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}