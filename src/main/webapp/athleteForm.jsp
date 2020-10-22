<%-- 
    Document   : athleteForm
    Created on : Oct 22, 2020, 9:00:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Athlete</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/CreateAthleteServlet" method="post">
            name: <input type="text" name="name">
            <br/>
            weight:<input type="number" step="0.01" name="weight">
            <br/>
            height:<input type="number" step="0.01" name="height">
            <br/>
            team: 
            <select name="team">
                <c:forEach items="${teams}" var="omada">
                    <option value="${omada.id}">${omada.sport}</option>
                </c:forEach>
            </select>

            <br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
