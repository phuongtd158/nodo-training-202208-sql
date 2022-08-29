<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login to application</h1>
<form action="/login" method="post">
    <%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
    <p>
        <label>
            <input type="text" name="j_username" placeholder="Username">
        </label>
    </p>
    <p>
        <label>
            <input type="password" name="j_password" placeholder="Password">
        </label>
    </p>
    <p>
        <input type="submit" name="commit" value="Login">
    </p>
</form>
</body>
</html>