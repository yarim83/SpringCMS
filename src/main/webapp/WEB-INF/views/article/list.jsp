<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/article"/>
<html>

<style type="text/css">
    table,tbody,thead,td,th{
        border-collapse: collapse;
        border: 1px solid black;
    }
</style>

<head>
    <title>Article list</title>
</head>
<body>
<h1>Lista artukułów</h1>


<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Creation Date</th>
        <th>Updated Date</th>
        <th>Content</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${article}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.created.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}</td>
            <td>${article.updated.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))}</td>
            <td>${article.content}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<button><a href="${contextPath}/form">Add article</a> </button>
</body>
</html>
