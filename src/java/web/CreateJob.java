/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JobDatabaseAccess;
import domain.Job;
import domain.Job.Frequency;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rory
 */
@WebServlet(name = "CreateJob", urlPatterns = {"/CreateJob"})
public class CreateJob extends HttpServlet {

    JobDatabaseAccess jda = new JobDatabaseAccess();
        
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
        Double chargeRate = Double.parseDouble(request.getParameter("ChargeRate")); //placeholder id, real id is assigned when saved to the db
        int employeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        int customerID = Integer.parseInt(request.getParameter("CustomerID"));
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("Date"));
        } catch (ParseException ex) {
            Logger.getLogger(CreateJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        Frequency frequency = Frequency.valueOf(request.getParameter("Frequency"));
        String description = request.getParameter("Description");
        String status = request.getParameter("Status");
        

        Job j = new Job(chargeRate, employeeID, customerID, date, frequency, description, status);
        
        jda.saveJob(j);
        response.sendRedirect("index.jsp");
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
