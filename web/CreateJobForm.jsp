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
        <% if (session.getAttribute("admin") == null) {%>
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
                <% if (request.getParameter("id") != null) {%>
                <h1>Update Job</h1>
                <% } else { %>
                <h1>Create Job</h1>
                <% } %>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <!--Editing-->
                    <% if (request.getParameter("id") != null) {%>
                    <form action="EditJob" method=POST" id="jobform">
                        <input name="id" type="hidden" value="<%=job.getJobID()%>">
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
                                        if (emp.getEmployeeID() == job.getEmployeeID()) {%>
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
                                <% if (job.getFrequency() == Frequency.Weekly) { %>
                                <option value="Weekly" selected="selected">Weekly</option>
                                <option value="Fortnightly">Fortnightly</option>
                                <option value="Monthly">Monthly</option>
                                <% } else if (job.getFrequency() == Frequency.Fortnightly) { %>
                                <option value="Weekly">Weekly</option>
                                <option value="Fortnightly" selected="selected">Fortnightly</option>
                                <option value="Monthly">Monthly</option>
                                <% } else if (job.getFrequency() == Frequency.Monthly) { %>
                                <option value="Weekly">Weekly</option>
                                <option value="Fortnightly">Fortnightly</option>
                                <option value="Monthly" selected="selected">Monthly</option>
                                <% }%>
                            </select></p>
                        <input name="Date" type="datetime-local" value="<%=job.getDateTime()%>">
                        <input name="Rate" type="text" placeholder="Rate" value="<%=job.getChargeRate()%>">
                        <textarea name="Description" type="text" placeholder="Decription" form="jobform"><%=job.getDescription()%></textarea>
                        <button type="submit">Update</button>
                    </form>


                    <!--Not Editing-->
                    <% } else { %>
                    <form action="CreateJob" method=POST" id="jobform">
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
                            </select>
                        </p>
                        <input name="Date" type="datetime-local">
                        <input name="Rate" type="text" placeholder="Rate">
                        <textarea name="Description" type="text" placeholder="Decription" form="jobform"></textarea>
                        <button type="submit">Create</button>
                        <% }%>
                    </form>
                </div>
            </div>
        </div>
        <% }%>
    </body>
</html>
