<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Product Maintenance</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="mystyle.css">
        <style type="text/css">
            /*table {border-collapse:separate;padding:1px;border:1px solid}*/
            td    {text-align:center;padding:5px;border:1px solid}                                  
        </style>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Products</h1>
        <table class ="table">
            <tr>
                <td>Code</td>
                <td>Description</td>
                <td>Price</td>
                <td colspan ="2"> </td>
                
            </tr>
            <c:forEach var="p" items="${products}" >
            
            <tr>
                <td>${p.code}</td>
                <td>${p.description}</td>
                <td>${p.priceCurrencyFormat}</td>
                <td><a href="<c:url value='/displayProduct?productCode=${p.code}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteProduct?productCode=${p.code}' />">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <form action="<c:url value='/displayProduct' />" method="get">
        <input type ="submit" value ="Add Product" class ="button btn-big" >
        </form>
     </body>
</html>