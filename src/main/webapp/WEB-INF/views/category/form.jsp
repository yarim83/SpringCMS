<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/category"/>
<html>
<style type="text/css">
    .error{
        color: red;
    }
</style>
<head>
    <title>Category form</title>
</head>
<body>
<h1>Category form</h1>

<form:form action="${contextPath}" method="post" modelAttribute="category">
    <div>
        Name <form:input path="name"/>
        <form:errors path="name" cssClass="error"/>
    </div>
    <div>
        Description<form:input path="description"/>
        <form:errors path="description" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="save">
    </div>
</form:form>

<button>
    <a href="/category/list">Back</a>
</button>
</body>
</html>
