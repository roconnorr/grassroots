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
        <% if (session.getAttribute("admin") == null && session.getAttribute("user") == null) {%>
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
                <h1>Customer</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <p>
                    <label>Name: </label>
                    <%= customer.getName()%>
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
                <% if (session.getAttribute("user") == null) {%>
                <p id="button">
                    <a href="CreateCustomerForm.jsp?id=<%=customer.getCustomerID()%>">Edit</a>
                </p>
                <% } %>
            </div>
        </div>
        <% }%>
    </body>
</html>
