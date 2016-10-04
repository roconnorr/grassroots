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
        <title>Create Employee</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Create Employee</h1>
        <div class="back"><div class="content">
        <div class ="form">
        <form action="CreateEmployee" method=POST">
              <label for="txtName">Name: </label> 
              <input id="txtName" name="Name" type="text">
              
              <label for="txtUsername">Username: </label> 
              <input id="txtUsername" name="Username" type="text">
              
              <label for="txtPassword">Password: </label> 
              <input id="txtPassword" name="Password" type="password">
              
              <label for="txtEmail">Email: </label> 
              <input id="txtEmail" name="Email" type="text">
              
              <label for="txtPhoneNumber">Phone Number: </label> 
              <input id="txtPhoneNumber" name="PhoneNumber" type="text">
              
              <button type="submit">Submit</button>
        </form>
        </div></div></div>
    </body>
</html>