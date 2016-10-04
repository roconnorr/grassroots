<%@page import="domain.Customer"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%
    CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
    int customerID = Integer.parseInt(request.getParameter("id"));
    Customer customer = cDAO.searchCustomerID(customerID);
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
                <%= customer.getName() %>
                </p><p>
                <label>Address: </label>
                <%= customer.getAddress()%>
                </p><p>
                <label>Email: </label>
                <%= customer.getEmail()%>
                </p><p>
                <label>Phone Number: </label>
                <%= customer.getPhoneNumber()%>
                </p><p>
                <label>Section Size: </label>
                <%= customer.getSectionSize()%>
                </p>
            </div>
        </div>
    </body>
</html>
