/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.AdminDatabaseAccess;
import dao.EmployeeDatabaseAccess;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Rory
 */
public class PasswordHash {
    
    public static final String SALT = "g74g1tb12124^!#$71YV!%V71g171g6!v7";
    EmployeeDatabaseAccess eda = new EmployeeDatabaseAccess();
    AdminDatabaseAccess ada = new AdminDatabaseAccess();
    
    public Boolean login(String username, String password) {
        Boolean isAuthenticated;

        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        String storedPasswordHash = eda.getPasswordHash(username);
        if (hashedPassword.equals(storedPasswordHash)) {
            isAuthenticated = true;
        } else {
            isAuthenticated = false;
        }
        return isAuthenticated;
        
    }
    
    public Boolean adminLogin(String username, String password) {
        Boolean isAuthenticated;

        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        String storedPasswordHash = ada.getAdminPasswordHash(username);
        if (hashedPassword.equals(storedPasswordHash)) {
            isAuthenticated = true;
        } else {
            isAuthenticated = false;
        }
        return isAuthenticated;
        
    }

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        return hash.toString();
    }
    
}
