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
    <title>Edit form</title>
</head>
<body>
<h1>Edit form</h1>

<form:form action="${contextPath}/edit" method="post" modelAttribute="author">
    <form:hidden path="id"/>
    <div>
        Imię:<form:input path="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </div>
    <div>
        Nazwisko:<form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </div>
    <div>
        <input type="submit" value="save">
    </div>
</form:form>
</body>
</html>
