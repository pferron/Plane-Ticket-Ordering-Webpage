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
            table {border-spacing:1px;padding:3px;border:0px}
            td    {padding:4px}
        </style>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="pf" uri="/WEB-INF/maint.tld" %>
        <h1>Products</h1>
        <p><i>${requestScope.message}</i></p>
        <pf:IfEmptyFields code="${product.code}" description="${product.description}" price ="${product.priceNumberFormat}">
            <p><pf:ifEmptyMark color="blue" field=""/> marks required fields</p>
        </pf:IfEmptyFields>
        
        <form action="<c:url value='/updateProduct' />" method="get">
            <table>
                <tr>
                    <td style ="text-align:right">Product Code:</td>
                    <td><input type="text" 
                               value ="${product.code}" 
                               name="productCode">
                        <pf:ifEmptyMark color="blue" field ="${product.code}" />
                    </td>
                </tr>
                <tr>
                    <td style ="text-align:right">Product description:</td>
                    <td><input type="text" 
                               value ="${product.description}" 
                               size ="55" name="productDescription">
                        <pf:ifEmptyMark color="blue" field ="${product.description}" />
                    </td>
                </tr>
                <tr>
                    <td style ="text-align:right">Product price:</td>
                    <td><input type="text" 
                               value ="${product.priceNumberFormat}" 
                               name="productPrice">
                        <pf:ifEmptyMark color="blue" field ="${product.priceNumberFormat}" />
                    </td>
                </tr>
             </table>
            
        
        <br>    
        <table>
            <tr>
                <td>
                    <input type="submit" value="Update Product" class ="button">
                    </form>
                </td>

                <td>
                    <form action="<c:url value='/displayProducts' />" method="get">
                    <input type ="submit" value ="View Products" class ="button"> 
                </form>
                </td>
            </tr>
        </table>
               
    </body>
</html>
