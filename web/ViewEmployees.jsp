<%-- 
    Document   : ViewCustomers
    Created on : 2/10/2016, 6:18:37 PM
    Author     : Rory
--%>

<%@page import="domain.Employee"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%
    EmployeeDatabaseAccess dao = new EmployeeDatabaseAccess();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Employee Details</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <table cellspacing="0">
                    <tr>
                        <th width="200" id="left">Name</th>
                        <th width="300" id="left">Username</th>
                        <th width="300" id="left">Email</th>
                        <th width="150" id="left">Ph Number</th>
                        <th width="50">Edit</th>
                    </tr>
                    <% for (Employee emp : dao.getEmployees()) { %>
                    <tr>
                        <td><a href="EmployeeDetails.jsp?id=<%=emp.getEmployeeID()%>"><%= emp.getName()%></a></td>
                        <td><%= emp.getUserName()%></td>
                        <td><%= emp.getEmail()%></td>
                        <td><%= emp.getPhoneNumber()%></td>
                        <td id="button"><a href="CreateEmployeeForm.jsp?id=<%=emp.getEmployeeID()%>">Edit</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </body>
</html>
