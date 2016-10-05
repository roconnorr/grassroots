<%@page import="domain.Employee"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%
    EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();
    int employeeID = Integer.parseInt(request.getParameter("id"));
    Employee emp = eDAO.searchEmployeeID(employeeID);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Customer</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <p>
                <label>Name: </label>
                <%= emp.getName() %>
                </p><p>
                <label>Username: </label>
                <%= emp.getUserName()%>
                </p><p>
                <label>Email: </label>
                <%= emp.getEmail()%>
                </p><p>
                <label>Phone Number: </label>
                <%= emp.getPhoneNumber()%>
                </p>
                <p id="button">
                    <a href="CreateEmployeeForm.jsp?id=<%=emp.getEmployeeID()%>">Edit</a>
                    <a href="ConfirmDelete.jsp?type=2&id=<%=emp.getEmployeeID()%>">Delete</a>
                </p>
            </div>
        </div>
    </body>
</html>
