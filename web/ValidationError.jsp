<%-- 
    Document   : ValidationError
    Created on : 26/09/2016, 2:06:57 PM
    Author     : Rory
--%>

<html>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <div class="back">
            <div class="content">
                <div class="childleft">
                    <img src="resources/logo.png" alt="Logo" style="width:83px;height:103px;" id="logo">
                </div>
                <h1>Something unexpected happened</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <a href="javascript:history.back()">Back</a>
                <p><%=request.getAttribute("javax.servlet.error.message")%></p>
            </div>
        </div>
    </body>
</html>
