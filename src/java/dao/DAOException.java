/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ocoro749
 */
public class DAOException extends RuntimeException {

    /**
     * Constructs an instance of <code>DAOException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DAOException(String msg) {
        super(msg);
    }
    
    public DAOException(String reason, Throwable cause){
        super(reason, cause);
    }
}
