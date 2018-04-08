<%-- 
    Document   : bookhomepage
    Created on : Nov 23, 2013, 12:06:14 PM
    Author     : Karyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            /*table {border-collapse:separate;padding:1px;border:1px solid}*/
            td    {padding:5px;border:0px solid} 
            .center {text-align:center}
            .caption   {text-align:center;height:30px}
            .table  {border:1px solid;width:400px;height:200px}
        </style>
        <title>Book Home Page</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <% String message = (String) request.getAttribute("message");
           if (message == null)
               message ="Please, enter Ordering Number and email";
        %>
        <table>
            <tr>
                <td>
                    <form action="<c:url value='/displayOrdering' />" method="get">
                    <table class ="table">
                        <caption align="top" class="caption">Reviewing Ordering</caption>
                        <tr><td><p><i><%=message%></i></p></td></tr>
                        <tr>
                            <td>Ordering Number</td>
                        </tr>
                        <tr>
                            <td><input type="text" 
                               value ="0000001"
                               name="orderingNumber">
                            </td>
                        </tr>
                        <tr>
                            <td>Email Address</td>
                        </tr>
                        <tr>
                            <td><input type="text" 
                               value ="philippeferron@hotmail.com" 
                               name="emailAddress"
                               size ="50">
                            </td>
                        </tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                        <tr>
                            <td class ="center">
                                <input type ="submit" value ="View Ordering">
                                </form>
                            </td>
                        </tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                    </table>
                </td>
                <td>or</td>
                <td>
                    <table class ="table">
                        <caption align="top" class="caption">New order</caption>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr
                        <tr><td></td></tr>
                        <tr>
                            <td class ="center">
                                <form action="<c:url value='/updateOrdering' />" method="get">
                                <input type ="submit" value ="New Ordering">
                                </form>
                            </td>
                        </tr
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                        <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
                </td>
            </tr>
        </table>
    </body>
</html>
