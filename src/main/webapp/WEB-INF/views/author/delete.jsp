<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>


<html>
<head>
    <title>Author delete confirmation</title>
</head>
<body>
<p>
    Are you sure ?
</p>
<button><a href="${contextPath}/delete-action/${authorId}?action=true">Yes</a></button>
<button><a href="${contextPath}/delete-action/${authorId}?action=false">No</a></button>
</body>
</html>
