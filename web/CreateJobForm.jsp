<%@page import="domain.Job.Frequency"%>
<%@page import="dao.JobDatabaseAccess"%>
<%@page import="domain.Job"%>
<%@page import="domain.Customer"%>
<%@page import="dao.EmployeeDatabaseAccess"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
    EmployeeDatabaseAccess eDAO = new EmployeeDatabaseAccess();

    Job job = null;
    if (request.getParameter("id") != null) {
        JobDatabaseAccess jDAO = new JobDatabaseAccess();
        int jobID = Integer.parseInt(request.getParameter("id"));
        job = jDAO.searchJobID(jobID);
    }
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
                        <!--Editing-->
                        <% if (request.getParameter("id") != null) { %>
                        <p><label for="Customer">Customer:</label><br>
                            <select name="Customer">
                                <% for (Customer cust : cDAO.getCustomers()) {
                                        if (cust.getCustomerID() == job.getCustomerID()) {%>
                                <option value="<%= cust.getCustomerID()%>" selected="selected"><%= cust.getName()%></option>
                                <% } else {%>
                                <option value="<%= cust.getCustomerID()%>"><%= cust.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select></p>
                        <p><label for="Employee">Employee:</label><br>
                            <select name="Employee">
                                <% for (Employee emp : eDAO.getEmployees()) {
                                        if (emp.getEmployeeID()== job.getEmployeeID()) {%>
                                <option value="<%= emp.getEmployeeID()%>" selected="selected"><%= emp.getName()%></option>
                                <% } else {%>
                                <option value="<%= emp.getEmployeeID()%>"><%= emp.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select></p>
                        <p><label for="Frequency">Frequency</label><br>
                            <select name="Frequency">
                                <% if(job.getFrequency() == Frequency.Weekly) { %>
                                <option value="Weekly" selected="selected">Weekly</option>
                                <option value="Fortnightly">Fortnightly</option>
                                <option value="Monthly">Monthly</option>
                                <% } else if(job.getFrequency() == Frequency.Fortnightly) { %>
                                <option value="Weekly">Weekly</option>
                                <option value="Fortnightly" selected="selected">Fortnightly</option>
                                <option value="Monthly">Monthly</option>
                                <% } else if(job.getFrequency() == Frequency.Monthly) { %>
                                <option value="Weekly">Weekly</option>
                                <option value="Fortnightly">Fortnightly</option>
                                <option value="Monthly" selected="selected">Monthly</option>
                                <% } %>
                            </select></p>
                        <input name="Day" type="text" placeholder="Day" value="<%=job.getDate()%>">
                        <input name="Rate" type="text" placeholder="Rate" value="<%=job.getChargeRate()%>">
                        <input name="Description" type="text" placeholder="Decription" value="<%=job.getDescription()%>">
                        <input name="Status" type="text" placeholder="Status" value="<%=job.getStatus()%>">
                        
                        
                        <!--Not Editing-->
                        <% } else { %>
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
                                <% } %>
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
                        <% }%>
                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
