<%@page import="domain.Employee"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%
    Employee emp = null;
    if (request.getParameter("id") != null) {
        EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();
        int employeeID = Integer.parseInt(request.getParameter("id"));
        emp = eDAO.searchEmployeeID(employeeID);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Employee</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Create Employee</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <form action="CreateEmployee" method=POST">
                        <% if (request.getParameter("id") != null) { %>
                        <input name="Name" type="text" placeholder="Full Name" value="<%=emp.getName()%>">
                        <input name="Email" type="text" placeholder="Email" value="<%=emp.getEmail()%>">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number" value="<%=emp.getPhoneNumber()%>">
                        <% } else { %>
                        <input name="Name" type="text" placeholder="Full Name">
                        <input name="Username" type="text" placeholder="Username">
                        <input name="Password" type="password" placeholder="Password">
                        <input name="Email" type="text" placeholder="Email">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number">
                        <% }%>
                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>