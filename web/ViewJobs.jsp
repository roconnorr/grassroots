<%-- 
    Document   : ViewCustomers
    Created on : 2/10/2016, 6:18:37 PM
    Author     : Rory
--%>

<%@page import="java.util.Collection"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%@page import="domain.Job"%>
<%@page import="dao.JobDatabaseAccess"%>
<%
    JobDatabaseAccess jDAO = new JobDatabaseAccess();
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
    EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();
    Collection<Job> list;
    if (request.getParameter("filter") != null) {
        list = jDAO.getIncompleteJobs();
    } else {
        list = jDAO.getJobs();
    }
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
        <% if (session.getAttribute("admin") == null) {%>
        <div class="back">
            <div class="content" id="button">
                <p id="center">You do not have access to this page</p>
            </div>
        </div>    
        <% } else { %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Job Details</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div id="right">
                    <% if (request.getParameter("filter") != null) { %>
                    <p id="button"><a href="ViewJobs.jsp">Show Completed</a></p>
                    <% } else { %>
                    <p id="button"><a href="?filter=1">Hide Completed</a></p>
                    <% } %>
                </div>
                <table cellspacing="0">
                    <tr>
                        <th width="200" id="left">Customer</th>
                        <th width="300" id="left">Employee</th>
                        <th width="100" id="left">Rate</th>
                        <th width="250" id="left">Date</th>
                        <th width="150" id="left">Frequency</th>
                        <th width="300" id="left">Description</th>
                        <th width="150" id="left">Status</th>
                        <th width="50">Edit</th>
                        <th width="50">Delete</th>
                    </tr>
                    <% for (Job job : list) {%>
                    <tr>
                        <td><a href="CustomerDetails.jsp?id=<%=job.getCustomerID()%>"><%= cDAO.searchCustomerID(job.getCustomerID()).getName()%></a></td>
                        <td><a href="EmployeeDetails.jsp?id=<%=job.getEmployeeID()%>"><%= eDAO.searchEmployeeID(job.getEmployeeID()).getName()%></a></td>
                        <td id="money"><%= job.getChargeRate()%></td>
                        <td><%= job.getDate()%></td>
                        <td><%= job.getFrequency()%></td>
                        <td><%= job.getDescription()%></td>
                        <td id="button"><a href="/grassroots/MarkJobComplete?id=<%=job.getJobID()%>&status=<%=job.getStatus()%>&source=1"><%= job.getStatus()%></a></td>
                        <td id="button"><a href="CreateJobForm.jsp?id=<%=job.getJobID()%>">Edit</a></td>
                        <td id="button"><a href="ConfirmDelete.jsp?type=3&id=<%=job.getJobID()%>">Delete</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
        <% }%>
    </body>
</html>
