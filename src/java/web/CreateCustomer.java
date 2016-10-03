/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerDatabaseAccess;
import domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateAccount", urlPatterns = {"/CreateAccount"})
public class CreateCustomer extends HttpServlet {

    CustomerDatabaseAccess cda = new CustomerDatabaseAccess();

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
        Integer customerID = -1; //placeholder id, real id is assigned when saved to the db
        String name = request.getParameter("Username");
        String address = request.getParameter("Name");
        String email = request.getParameter("CreditCard");
        String phoneNumber = request.getParameter("Password");
        String sectionSize = request.getParameter("Email");

        Customer c = new Customer(customerID, name, address, email, phoneNumber, sectionSize);
        

        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(c);

        // were there any violations?
        if (violations.isEmpty()) {
            cda.saveCustomer(c);
            response.sendRedirect("index.jsp");
        } else {
            StringBuilder message = new StringBuilder();
            message.append("<ul>\n");

            //	loop through the violations extracting the message for each
            for (ConstraintViolation violation : violations) {
                message.append("<li>").append(violation.getMessage()).append("</li>\n");
            }
            
            message.append("</ul>");

            response.sendError(422, message.toString());
        }

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
