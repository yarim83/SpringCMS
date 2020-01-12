<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>
<style type="text/css">
    .error{
        color: red;
    }
</style>
<head>
    <title>Author form</title>
</head>
<body>
<h1>Author form</h1>

<form:form action="${contextPath}" method="post" modelAttribute="author">
    <div>
        Imię <form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </div>
    <div>
        Nazwisko<form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="save">
    </div>
</form:form>

<button>
    <a href="/author/list">Back</a>
</button>
</body>
</html>
