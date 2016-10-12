<%-- 
    Document   : Admin
    Created on : 4/10/2016, 4:56:13 PM
    Author     : Joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
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
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Admin Control Panel</h1>
            </div>
        </div>
        <div class="back">
            <div class="content" id="center">
                <table cellspacing="0">
                    <tr>
                        <td><p id="button"><a href="CreateCustomerForm.jsp">Create Customer</a></p></td>
                        <td><p id="button"><a href="CreateEmployeeForm.jsp">Create Employee</a></p></td>
                        <td><p id="button"><a href="CreateJobForm.jsp">Create Job</a></p></td>
                    </tr><tr>
                        <td><p id="button"><a href="ViewCustomers.jsp">View Customers</a></p></td>
                        <td><p id="button"><a href="ViewEmployees.jsp">View Employees</a></p></td>
                        <td><p id="button"><a href="ViewJobs.jsp">View Jobs</a></p></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
        <% } %>
    </body>
</html>
