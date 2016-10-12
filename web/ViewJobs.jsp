<%-- 
    Document   : ViewCustomers
    Created on : 2/10/2016, 6:18:37 PM
    Author     : Rory
--%>

<%@page import="dao.CustomerDatabaseAccess"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%@page import="domain.Job"%>
<%@page import="dao.JobDatabaseAccess"%>
<%
    JobDatabaseAccess jDAO = new JobDatabaseAccess();
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
    EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Details</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <% if(session.getAttribute("admin") == null) {%>
        <div class="back">
            <div class="content" id="button">
                <p id="center">You do not have access to this page</p>
            </div>
        </div>    
        <% } else { %>
        <div class="back">
            <div class="content">
                <h1>Job Details</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <table cellspacing="0">
                    <tr>
                        <th width="200" id="left">Customer</th>
                        <th width="300" id="left">Employee</th>
                        <th width="300" id="left">Rate</th>
                        <th width="150" id="left">Day</th>
                        <th width="150" id="left">Frequency</th>
                        <th width="150" id="left">Description</th>
                        <th width="150" id="left">Status</th>
                        <th width="50">Edit</th>
                        <th width="50">Delete</th>
                    </tr>
                    <% for (Job job : jDAO.getJobs()) { %>
                    <tr>
                        <td><a href="CustomerDetails.jsp?id=<%=job.getCustomerID()%>"><%= cDAO.searchCustomerID(job.getCustomerID()).getName()%></a></td>
                        <td><a href="EmployeeDetails.jsp?id=<%=job.getEmployeeID()%>"><%= eDAO.searchEmployeeID(job.getEmployeeID()).getName()%></a></td>
                        <td id="money"><%= job.getChargeRate()%></td>
                        <td><%= job.getDate()%></td>
                        <td><%= job.getFrequency()%></td>
                        <td><%= job.getDescription()%></td>
                        <td id="button"><a href="/grassroots/MarkJobComplete?id=<%=job.getJobID()%>&status=<%=job.getStatus()%>"><%= job.getStatus()%></a></td>
                        <td id="button"><a href="CreateJobForm.jsp?id=<%=job.getJobID()%>">Edit</a></td>
                        <td id="button"><a href="ConfirmDelete.jsp?type=3&id=<%=job.getJobID()%>">Delete</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
        <% } %>
    </body>
</html>
