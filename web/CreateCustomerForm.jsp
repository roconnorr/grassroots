<%@page import="domain.Customer"%>
<%@page import="dao.CustomerDatabaseAccess"%>
<%
    Customer customer = null;
    if (request.getParameter("id") != null) {
        CustomerDatabaseAccess cDAO = new CustomerDatabaseAccess();
        int customerID = Integer.parseInt(request.getParameter("id"));
        customer = cDAO.searchCustomerID(customerID);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Customer</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <h1>Create Customer</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <form action="CreateCustomer" method=POST">
                        <% if (request.getParameter("id") != null) { %>
                        <input name="Name" type="text" placeholder="Full Name" value="<%=customer.getName()%>">
                        <input name="Address" type="text" placeholder="Address" value="<%=customer.getAddress()%>">
                        <input name="Email" type="text" placeholder="Email" value="<%=customer.getEmail()%>">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number" value="<%=customer.getPhoneNumber()%>">
                        <input name="SectionSize" type="text" placeholder="Section Size" value="<%=customer.getSectionSize()%>">
                        <% } else { %>
                        <input name="Name" type="text" placeholder="Full Name">
                        <input name="Address" type="text" placeholder="Address">
                        <input name="Email" type="text" placeholder="Email">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number">
                        <input name="SectionSize" type="text" placeholder="Section Size">
                        <% }%>
                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
