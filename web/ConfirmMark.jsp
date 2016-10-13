<%-- 
    Document   : ConfirmMark
    Created on : 13/10/2016, 4:47:40 PM
    Author     : Joe
--%>

<%
    String id = request.getParameter("id");
    String status = request.getParameter("status");
    String source = request.getParameter("source");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grass Roots</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Are you sure you want to mark as complete?</h1>
            </div>
        </div>
        <div class="back">
            <div class="content" id="center">
                <p id="button">
                    <a href="/grassroots/MarkJobComplete?id=<%=id%>&status=<%=status%>&source=<%=source%>">Mark Complete</a>
                    <a href="javascript:history.back()">Back</a>
                </p>
            </div>
        </div>
    </body>
</html>
