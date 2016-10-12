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
        <% if(session.getAttribute("admin") == null) {%>
        <div class="back">
            <div class="content" id="button">
                <p id="center">You do not have access to this page</p>
            </div>
        </div>    
        <% } else { %>
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
                    </tr>
                    <% for (Customer customer : dao.getCustomers()) { %>
                    <tr>
                        <td><a href="CustomerDetails.jsp?id=<%=customer.getCustomerID()%>"><%= customer.getName()%></a></td>
                        <td><%= customer.getAddress()%></td>
                        <td><%= customer.getPhoneNumber()%></td>
                        <td><%= customer.getEmail()%></td>
                        <td><%= customer.getSectionSize()%></td>
                        <td id="button"><a href="CreateCustomerForm.jsp?id=<%=customer.getCustomerID()%>">Edit</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
        <% } %>
    </body>
</html>
