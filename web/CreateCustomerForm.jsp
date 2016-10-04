<%-- 
    Document   : CreateAccountForm
    Created on : 8/09/2016, 2:18:37 PM
    Author     : Rory
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Customer</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Create Customer</h1>
        <div class="back"><div class="content">
        <div class ="form">
        <form action="CreateCustomer" method=POST">
              <label for="txtName">Full Name: </label> 
              <input id="txtName" name="Name" type="text">
              
              <label for="txtAddress">Address: </label> 
              <input id="txtAddress" name="Address" type="text">
              
              <label for="txtEmail">Email Address: </label> 
              <input id="txtEmail" name="Email" type="text">
              
              <label for="txtPhoneNumber">Phone Number: </label> 
              <input id="txtPhoneNumber" name="PhoneNumber" type="text">
              
              <label for="txtSectionSize">Section Size: </label> 
              <input id="txtSectionSize" name="SectionSize" type="text">
              
              <button type="submit">Submit</button>
        </form>
        </div></div></div>
    </body>
</html>
