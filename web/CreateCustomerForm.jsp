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
        <title>Create Account</title>
    </head>
    <body>
        memes
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Create an Account</h1>
        <div class ="form">
        <form action="CreateAccount" method=POST">
              <label for="txtUsername">Username: </label> 
              <input id="txtUsername" name="Username" type="text">
              
              <label for="txtName">Full Name: </label> 
              <input id="txtName" name="Name" type="text">
              
              <label for="txtName">Credit Card: </label> 
              <input id="txtName" name="CreditCard" type="text">
              
              <label for="password">Password: </label> 
              <input id="password" name="Password" type="password">
              
              <label for="txtEmail">Email Address: </label> 
              <input id="txtEmail" name="Email" type="text">
              
              <label for="txtAddress">Address: </label> 
              <input id="txtAddress" name="Address" type="text">
              
              <button type="submit">Submit</button>
        </form>
        </div>
    </body>
</html>
