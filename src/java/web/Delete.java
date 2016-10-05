/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.CustomerDatabaseAccess;
import dao.EmployeeDatabaseAccess;
import dao.JobDatabaseAccess;
import domain.Customer;
import domain.Employee;
import domain.Job;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rory
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

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
        int type = Integer.parseInt(request.getParameter("type"));
        int id = Integer.parseInt(request.getParameter("toDelete"));

        if (type == 1) {
            CustomerDatabaseAccess cda = new CustomerDatabaseAccess();
            cda.deleteCustomer(id);
            response.sendRedirect("ViewCustomers.jsp");
        } else if (type == 2) {
            EmployeeDatabaseAccess dao = new EmployeeDatabaseAccess();
            dao.deleteEmployee(id);
            response.sendRedirect("ViewEmployees.jsp");
        } else if (type == 3) {
            JobDatabaseAccess dao = new JobDatabaseAccess();
            dao.deleteJob(id);
            response.sendRedirect("ViewJobs.jsp");
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
