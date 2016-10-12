/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerDatabaseAccess;
import dao.EmployeeDatabaseAccess;
import domain.Customer;
import domain.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author Rory
 */
@WebServlet(name = "CreateEmployee", urlPatterns = {"/CreateEmployee"})
public class CreateEmployee extends HttpServlet {

    EmployeeDatabaseAccess eda = new EmployeeDatabaseAccess();
    PasswordHash pHash = new PasswordHash();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer employeeID = -1; //temp id, real one assigned in db
        String name = request.getParameter("Name");
        String userName = request.getParameter("Username");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        String phoneNumber = request.getParameter("PhoneNumber");
        String message = request.getParameter("Message");
        
        String saltedPassword = pHash.SALT + password;
        String hashedPassword = pHash.generateHash(saltedPassword);

        Employee e = new Employee(employeeID, name, userName, hashedPassword,  email, phoneNumber, message);
        
        eda.saveEmployee(e);
        response.sendRedirect("ViewEmployees.jsp");
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
