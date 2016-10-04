<%-- 
    Document   : ViewCustomers
    Created on : 2/10/2016, 6:18:37 PM
    Author     : Rory
--%>

<%@page import="domain.Customer"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%
    CustomerDatabaseAccess dao = new CustomerDatabaseAccess();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Customer Details</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <table cellspacing="0">
                    <tr>
                        <th width="200" id="left">Name</th>
                        <th width="300" id="left">Address</th>
                        <th width="150" id="left">Ph Number</th>
                        <th width="300" id="left">Email</th>
                        <th width="100" id="left">Section Size</th>
                        <th width="50">Edit</th>
                        <th width="50">Delete</th>
                    </tr>
                    <% for (Customer customer : dao.getCustomers()) { %>
                    <tr>
                        <td><%= customer.getName()%></td>
                        <td><%= customer.getAddress()%></td>
                        <td><%= customer.getPhoneNumber()%></td>
                        <td><%= customer.getEmail()%></td>
                        <td><%= customer.getSectionSize()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </body>
</html>
