<%-- 
    Document   : ViewProducts
    Created on : 10/09/2016, 3:03:11 PM
    Author     : Rory
--%>

<%@page import="dao.ProductDatabaseAccess"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.ProductDataAccess"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Products</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Products</h1>
        <%
            ProductDatabaseAccess pda = new ProductDatabaseAccess();
            String category = (String) request.getParameter("category");
            Collection<String> categories = pda.getCategories();
            Collection<Product> products;
            if (category != null) {
                products = pda.filterCategory(category);
            } else {
                products = pda.getProducts();
            }
        %>
        <div class="navigation">
                <a href="ViewProducts.jsp">All Products</a>
                <% for (String cat : categories) {%>
                <a href="ViewProducts.jsp?category=<%= cat%>"><%= cat%></a>
                <%}%>
        </div>
        <div class="producttable">
            <table>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Buy</th>
                </tr>
                <% for (Product p : products) {%>
                <tr>
                    <td><%= p.getProductID()%></td>
                    <td><%= p.getName()%></td>
                    <td><%= p.getDescription()%></td>
                    <td><%= p.getCategory()%></td>
                    <td><p id="money"><%= p.getPrice()%></p></td>
                    <td><%= p.getQuantityInStock()%></td>
                    <td><a href="BuyItem.jsp?productID=<%= p.getProductID()%>">Buy</a></td>
                </tr>
                <%}%>
            </table>
        </div>
    </body>
</html>
