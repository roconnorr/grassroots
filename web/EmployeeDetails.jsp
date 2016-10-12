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
        <% if(session.getAttribute("admin") == null) {%>
        <div class="back">
            <div class="content" id="button">
                <p id="center">You do not have access to this page</p>
            </div>
        </div>    
        <% } else { %>
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
                </p>
            </div>
        </div>
        <% } %>
    </body>
</html>
