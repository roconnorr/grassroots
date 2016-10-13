<%-- 
    Document   : 404NotFound
    Created on : 26/09/2016, 2:48:34 PM
    Author     : Rory
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>404 Not Found</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <a href="javascript:history.back()">Back</a>
            </div>
        </div>
    </body>
</html>
