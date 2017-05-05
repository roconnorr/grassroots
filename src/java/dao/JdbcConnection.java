/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ocoro749
 */
public class JdbcConnection {

    private static final String username = "";
    private static final String password = "";
    private static Connection conn = null;
    

    public static Connection getConnection(String url) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
