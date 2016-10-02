<%-- 
    Document   : index.jsp
    Created on : 13/09/2016, 4:21:45 PM
    Author     : ocoro749
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <%if (customer != null) {%>
            <h1>Welcome to the Shop, <%= customer.getName()%></h1>
        <%} else {%>
            <h1>Welcome to the Shop</h1>
        <%}%>

    </body>
</html>
