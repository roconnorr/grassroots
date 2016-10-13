/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JobDatabaseAccess;
import domain.Job;
import domain.Job.Frequency;
import domain.Job.Status;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rory
 */
@WebServlet(name = "MarkJobComplete", urlPatterns = {"/MarkJobComplete"})
public class MarkJobComplete extends HttpServlet {
    
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int jobID = -1; //placeholder
        int source = Integer.parseInt(request.getParameter("source"));
        Job j = jda.searchJobID(id);
        System.out.println("j" + j.getDateTime());
        Status status = Status.valueOf(request.getParameter("status"));
        Status newStatus;
        if(status == Status.Incomplete){
            newStatus = Status.Complete;
            //this means the job was marked complete, and a new one with date plus the frequency should be created
            Job newjob = new Job(jobID, j.getChargeRate(), j.getEmployeeID(), j.getCustomerID(), j.getDateTime(), j.getFrequency(), j.getDescription(), Status.Incomplete);
            if(j.getFrequency() == Frequency.Weekly){
                newjob.setDateTime(newjob.getDateTime().plusWeeks(1));
                jda.saveJob(newjob);
            }else if(j.getFrequency() == Frequency.Fortnightly){
                newjob.setDateTime(newjob.getDateTime().plusWeeks(2));
                jda.saveJob(newjob);
            }else if(j.getFrequency() == Frequency.Monthly){
                newjob.setDateTime(newjob.getDateTime().plusMonths(1));
                jda.saveJob(newjob);
            }
        }else{
            newStatus = Status.Incomplete;
        }
        jda.markJob(id, newStatus, j.getDateTime());
        if(source == 1){
            response.sendRedirect("ViewJobs.jsp");
        }else{
            response.sendRedirect("EmployeePage.jsp");
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
