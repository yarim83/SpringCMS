<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<style type="text/css">
    table,tbody,thead,th,td{
        border: 1px solid black;
        border-collapse: collapse;

    }

</style>
<head>
    <title>Strona główna</title>
</head>
<body>

<h1>Lista 5 artykułów</h1>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Creation Date</th>
        <th>Content</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>

    </tbody>


</table>

</body>
</html>
