<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
            <td>${article.created.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<button><a href="${contextPath}/category/list">Category list</a> </button>
<button><a href="${contextPath}/author/list">Author list</a> </button>


</body>
</html>
