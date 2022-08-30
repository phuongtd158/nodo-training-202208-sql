<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to Spring Clazz</h1>
<p>
    <a href="${pageContext.request.contextPath}/">Trang chủ</a>
    <sec:authorize access="!hasAnyRole('ROLE_USER')">
        <a href="${pageContext.request.contextPath}/dang-nhap">Đăng nhập</a>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_USER')">
        <a href="${pageContext.request.contextPath}/nguoi-dung">Ngưởi dùng</a>
        <a href="javascript:document.getElementById('logout').submit()">Đăng xuất</a>
    </sec:authorize>
    <tiles:insertAttribute name="body"/>
</p>
<form action="/j_spring_security_logout" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>
