<%@page import="domain.Job"%>
<%@page import="dao.JobDatabaseAccess"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%@page import="domain.Customer"%>
<%@page import="dao.CustomerDatabaseAccess"%>

<%
    int type = Integer.parseInt(request.getParameter("type"));
    if (type == 1) {
        int customerID = Integer.parseInt(request.getParameter("id"));
        CustomerDatabaseAccess dao = new CustomerDatabaseAccess();
        Customer customer = dao.searchCustomerID(customerID);
        session.setAttribute("toDelete", customer);
    } else if (type == 2) {
        int employeeID = Integer.parseInt(request.getParameter("id"));
        EmployeeDatabaseAccess dao = new EmployeeDatabaseAccess();
        Employee emp = dao.searchEmployeeID(employeeID);
        session.setAttribute("toDelete", emp);
    } else if (type == 3) {
        int jobID = Integer.parseInt(request.getParameter("id"));
        JobDatabaseAccess dao = new JobDatabaseAccess();
        Job job = dao.searchJobID(jobID);
        session.setAttribute("toDelete", job);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Deletion</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Are you sure you want to delete?</h1>
            </div>
        </div>
        <div class="back">
            <div class="content" id="center">
                <p id="button">
                    <a href="/grassroots/Delete">Confirm</a>
                    <a href="javascript:history.back()">Back</a>
                </p>
            </div>
        </div>
    </body>
</html>
