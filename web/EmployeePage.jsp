<%-- 
    Document   : EmployeePage
    Created on : 12/10/2016, 2:36:59 PM
    Author     : Joe
--%>

<%@page import="domain.Job"%>
<%@page import="dao.JobDatabaseAccess"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%
    JobDatabaseAccess jDAO = new JobDatabaseAccess();
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <% if (session.getAttribute("user") == null) {%>
        <div class="back">
            <div class="content" id="button">
                <p id="center">You do not have access to this page</p>
            </div>
        </div>    
        <% } else {%>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Assigned Jobs</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <h2>Welcome <%= employee.getName()%></h2>
                <p><%=employee.getMessage()%></p>
                <h2>Jobs:</h2>
                <table cellspacing="0">
                    <tr>
                        <th width="200" id="left">Customer</th>
                        <th width="300" id="left">Rate</th>
                        <th width="150" id="left">Date</th>
                        <th width="150" id="left">Description</th>
                        <th width="150" id="left">Mark Complete</th>
                    </tr>
                    <% for (Job job : jDAO.getIncompleteJobsByEmployeeID(employee.getEmployeeID())) {%>
                    <tr>
                        <td><a href="CustomerDetails.jsp?id=<%=job.getCustomerID()%>"><%= cDAO.searchCustomerID(job.getCustomerID()).getName()%></a></td>
                        <td id="money"><%= job.getChargeRate()%></td>
                        <td><%= job.getDateTime()%></td>
                        <td><%= job.getDescription()%></td>
                        <td id="button"><a href="/grassroots/MarkJobComplete?id=<%=job.getJobID()%>&status=<%=job.getStatus()%>&source=2">Mark Complete</a></td>
                    </tr>
                    <% } %>
                </table>

            </div>
        </div>
        <% }%>
    </body>
</html>
