

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            .caption   {text-align:center;height:30px}
            .td-80     {padding-top:80px}
            .td-30     {padding-top:30px}
            td         {padding-right:20px}
        </style>
        <title>Ordering</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <form action="<c:url value='/updateOrdering' />" method="get">
        <table>
            <caption align="top" class="caption">Ordering</caption>
            <tr>
                <td>First Name</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${order.firstName}" 
                               name="firstName">
                </td>
            </tr>
            <tr>
                <td>Last Name</td>
            </tr>
                <td><input type="text" 
                               value ="${order.lastName}" 
                               name="lastName">
                </td>
            </tr>
            <tr>
                <td>Address</td>
            </tr>
                <td><input type="text" 
                               value ="${order.address}" 
                               name="address">
                </td>
            </tr>
            <tr>
                <td>City</td>
                <td>State</td>
                <td>Zip Code</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${order.city}" 
                               name="city">
                </td>
                <td>
                    <select name ="state">
                        <option value="${order.state}" disabled="disabled" selected="selected"></option>
                        <option value="Illinois">Illinois</option>
                        <option value="Indiana">Indiana</option>
                    </select>
                </td>
                <td><input type="text" 
                               value ="${order.zipCode}" 
                               name="zipCode"
                               size ="5">
                </td>
            </tr>
            <tr>
                <td class ="td-80">Departure City</td>
                <td class ="td-80">Arrival City</td>
            </tr>
            <tr>
                <td>
                    <select name ="departureCity">
                        <option value="${order.departureCity}" disabled="disabled" selected="selected"></option>
                        <option value="Illinois">Chicago</option>
                        <option value="Indiana">New York</option>
                    </select>
                </td>
                <td>
                    <select name ="arrivalCity">
                        <option value="${order.arrivalCity}" disabled="disabled" selected="selected"></option>
                        <option value="Illinois">Chicago</option>
                        <option value="Indiana">New York</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Number of Passenger</td>
            </tr>
            <tr>
                <td><input type="text" 
                               value ="${order.numberPassenger}" 
                               name="numberPassenger"
                               size ="3">
                </td>
            </tr>
            <tr>
                <td class ="td-30">
                    <input type="submit" value="Calculate Price">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
