<%-- 
    Document   : ValidationError
    Created on : 26/09/2016, 2:06:57 PM
    Author     : Rory
--%>

<html>
  <body>
    <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    <h1>Something unexpected happened</h1>
    <p><%=request.getAttribute("javax.servlet.error.message")%></p>
    <a href="javascript:history.back()">Back</a>
  </body>
</html>
