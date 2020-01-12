<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>

<style type="text/css">
    table,tbody,thead,td,th{
        border-collapse: collapse;
        border: 1px solid black;
    }
</style>

<head>
    <title>Author list</title>
</head>
<body>
<h1>Lista autorów</h1>


<table>
    <thead>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${author}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
                <button><a href="${contextPath}/edit/${author.id}">Edit author</a> </button>
                <button><a href="${contextPath}/delete/${author.id}">Delete author</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button><a href="${contextPath}/form">Add author</a> </button>
</body>
</html>
