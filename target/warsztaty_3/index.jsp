<%--
  Created by IntelliJ IDEA.
  User: leszek
  Date: 08.09.18
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
</head>
<body>
<jsp:include page="WEB-INF/fragments/header.jsp" />
<h3>List of solutions:</h3>
<table border="1" style="line-grid: create">
    <tr>
        <th>Created on</th>
        <th>Last updated on</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${solutions}" var="solution" >
        <tr>
            <td><c:out value="${solution.created}"/></td>
            <td><c:out value="${solution.updated}"/></td>
            <td><c:out value="${solution.description}"/></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="WEB-INF/fragments/footer.jsp" />
</body>
</html>