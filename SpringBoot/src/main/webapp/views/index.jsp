<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<ul>
    <sec:authorize access="!hasAnyRole('ROLE_USER')">
        <li><a href="/login">Login</a></li>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_USER')">
        <li><a href="/nguoi-dung">Profile</a></li>
        <li><a href="/logout">Logout</a></li>
    </sec:authorize>
</ul>
${message}
</body>
</html>