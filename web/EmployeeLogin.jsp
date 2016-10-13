<%-- 
    Document   : Login
    Created on : 10/09/2016, 3:50:44 PM
    Author     : Rory
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Log In</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <% if (request.getParameter("pass") != null) { %>
                <p id="center">Incorrect Username or Password</p>
                <% }%>
                <div class="form">
                    <form action="EmployeeLogin" method=POST">
                        <label for="txtUsername">Username: </label> 
                        <input id="txtUsername" name="Username" type="text">

                        <label for="txtName">Password: </label> 
                        <input id="txtPassword" name="Password" type="password">
                        <button type="submit" class="button">Login</button> 
                        <p id="button"><a href="AdminLogin.jsp">Admin Login</a></p>
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>
