<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/article"/>


<html>
<head>
    <title>Article delete confirmation</title>
</head>
<body>
<p>
    Are you sure ?
</p>
<button><a href="${contextPath}/delete-action/${articleId}?action=true">Yes</a></button>
<button><a href="${contextPath}/delete-action/${articleId}?action=false">No</a></button>
</body>
</html>
