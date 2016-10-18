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
        <% if (session.getAttribute("admin") == null) {%>
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
                <% if (request.getParameter("id") != null) {%>
                <h1>Update Employee</h1>
                <% } else { %>
                <h1>Create Employee</h1>
                <% } %>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <% if (request.getParameter("id") != null) {%>
                    <form action="EditEmployee" method=POST" id="empform">
                        <input name="id" type="hidden" value="<%=emp.getEmployeeID()%>">
                        <input name="Name" type="text" placeholder="Full Name" value="<%=emp.getName()%>">
                        <input name="Email" type="text" placeholder="Email" value="<%=emp.getEmail()%>">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number" value="<%=emp.getPhoneNumber()%>">
                        <textarea name="Message" type="text" placeholder="Message" form="empform"><%=emp.getMessage()%></textarea>
                        <button type="submit">Update</button>
                    </form>
                    <% } else { %>
                    <form action="CreateEmployee" method=POST" id="empform2">
                        <input name="Name" type="text" placeholder="Full Name">
                        <input name="Username" type="text" placeholder="Username">
                        <input name="Password" type="password" placeholder="Password">
                        <input name="Email" type="text" placeholder="Email">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number">
                        <textarea name="Message" type="text" placeholder="Message" form="empform2"></textarea>
                        <button type="submit">Create</button>
                    </form>
                    <% }%>
                </div>
            </div>
        </div>
        <% }%>
    </body>
</html>