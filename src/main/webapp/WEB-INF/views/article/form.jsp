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
    <title>Author form</title>
</head>
<body>
<h1>Author form</h1>

<form:form action="${contextPath}" method="post" modelAttribute="article">
    <div>
        Tytuł <form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
    </div>
    <div>
        Treść<form:input path="content"/>
        <form:errors path="content" cssClass="error"/>
    </div>

    <div>
        Author:
        <form:select path="author.id">
            <form:options items="${authors}" itemValue="id" itemLabel="firstName"/>
        </form:select>
        <form:errors path="author" cssClass="error"/>
    </div>

    <div>
        Categorie:
        <form:select path="categories" items="${categories}"
                     itemValue="id" itemLabel="name" multiple="true"/>
        <form:errors path="categories" cssClass="error"/>
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
