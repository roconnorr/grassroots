/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rory
 */
public class AdminDatabaseAccess {
    
    static private String url = "jdbc:mysql://192.168.178.21:3306/grassroots";

    public AdminDatabaseAccess() {
    }

    public AdminDatabaseAccess(String altUrl) {
        url = altUrl;
    }
    
    public void saveAdmin(Admin a) {
        String sql = "insert into admins (username, password) values (?,?)";
        
        try (   
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, a.getUsername());
                stmt.setString(2, a.getPassword());
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public Admin searchAdminUserName(String searchUsername){
        String sql = "select * from admins where username = ?";
        
        try (
                Connection dbCon = JdbcConnection.getConnection(url);
                PreparedStatement stmt = dbCon.prepareStatement(sql);
        ) {
                stmt.setString(1, searchUsername);
                ResultSet rs = stmt.executeQuery();      
                if(rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    Admin a = new Admin(username, password);
                    return a;
                }else{
                    return null;
                }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    
    public String getAdminPasswordHash(String searchUsername){
        String sql = "select * from admins where username = ?";
        
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
