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
        <div class="back">
            <div class="content">
                <h1>Admin Control Panel</h1>
            </div>
        </div>
        <div class="back">
            <div class="content" id="center">
                <table cellspacing="0">
                    <tr>
                        <td><p id="button"><a href="CreateCustomerForm.jsp">Create Customer</a></p></td>
                        <td><p id="button"><a href="CreateEmployeeForm.jsp">Create Employee</a></p></td>
                    </tr><tr>
                        <td><p id="button"><a href="ViewCustomers.jsp">View Customers</a></p></td>
                        <td><p id="button"><a href="ViewEmployees.jsp">View Employees</a></p></td>
                    </tr><tr>
                        <td><p id="button"><a href="CreateJobForm.jsp">New Job</a></p></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
