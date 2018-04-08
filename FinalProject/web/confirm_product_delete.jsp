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
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Are you sure you want to delete this products?</h1>
        
        <table>
                <tr>
                    <td style ="text-align:right">Product Code:</td>
                    <td>${product.code}</td>
                </tr>
                <tr>
                    <td style ="text-align:right">Product description:</td>
                    <td>${product.description}</td>
                </tr>
                <tr>
                    <td style ="text-align:right">Product price:</td>
                    <td>${product.priceNumberFormat}</td>
                </tr>
        </table>
    
    <br>
    <table>
        <tr>
            <td>
                <form action="<c:url value='/deleteProduct' />" method="get">
                    <input style ="width:60px" type ="submit" name ="Yes_button" value ="Yes" class ="button"> 
                </form>
            </td>

            <td>
                <form action="<c:url value='/displayProducts' />" method="get">
                    <input style ="width:60px" type ="submit" value ="No" class ="button"> 
                </form>
            </td>
        </tr>
    </table>
        
    </body>
</html>
