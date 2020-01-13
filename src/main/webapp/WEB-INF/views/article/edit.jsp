<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/article"/>
<html>
<style type="text/css">
    .error{
        color: red;
    }
</style>
<head>
    <title>Edit form</title>
</head>
<body>
<h1>Edit form</h1>

<form:form action="${contextPath}/edit" method="post" modelAttribute="article">
    <form:hidden path="id"/>
    <div>
        Tytuł:<form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
    </div>
    <div>
        Treść:<form:input path="content"/>
        <form:errors path="content" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="save">
    </div>
</form:form>
</body>
</html>
