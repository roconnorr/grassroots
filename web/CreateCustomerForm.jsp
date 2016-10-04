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
        <div class="back">
            <div class="content">
                <h1>Create Customer</h1>
            </div>
        </div>
        <div class="back">
            <div class="content">
                <div class ="form">
                    <form action="CreateCustomer" method=POST">
                        <input name="Name" type="text" placeholder="Full Name">
                        <input name="Address" type="text" placeholder="Address">
                        <input name="Email" type="text" placeholder="Email">
                        <input name="PhoneNumber" type="text" placeholder="Phone Number">
                        <input name="SectionSize" type="text" placeholder="Section Size">

                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
