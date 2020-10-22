<%-- 
    Document   : teamList
    Created on : Oct 22, 2020, 8:46:09 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Teams</h1>
        <table>
            <th>ID</th>
            <th>Sport</th>
                <c:forEach items="${teams}" var="omada">
                <tr>
                    <td>
                        ${omada.id}
                    </td>
                    <td>
                        ${omada.sport}
                    </td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
