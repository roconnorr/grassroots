<%@page import="domain.Customer"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
    EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Job</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Create Job</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <form action="CreateJob" method=POST">
                        <p><label for="Customer">Customer:</label><br>
                        <select name="Customer">
                            <% for (Customer cust : cDAO.getCustomers()) {%>
                            <option value="<%= cust.getCustomerID()%>" ><%= cust.getName()%></option>
                            <% } %>
                        </select></p>
                        <p><label for="Employee">Employee:</label><br>
                        <select name="Employee">
                            <% for (Employee emp : eDAO.getEmployees()) {%>
                            <option value="<%= emp.getEmployeeID()%>" ><%= emp.getName()%></option>
                            <% }%>
                        </select></p>
                        <p><label for="Frequency">Frequency</label><br>
                        <select name="Frequency">
                            <option value="Weekly" >Weekly</option>
                            <option value="Fortnightly" >Fortnightly</option>
                            <option value="Monthly" >Monthly</option>
                        </select></p>
                        <input name="Day" type="text" placeholder="Day">
                        <input name="Rate" type="text" placeholder="Rate">
                        <input name="Description" type="text" placeholder="Decription">
                        <input name="Status" type="text" placeholder="Status">

                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
