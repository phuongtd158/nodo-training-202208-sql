<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Trang đăng nhập</h1>
        <form action="${pageContext.request.contextPath}/_j_spring_security_check" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <p>
                <label>
                    <input type="text" name="username" placeholder="Username">
                </label>
            </p>
            <p>
                <label>
                    <input type="password" name="password" placeholder="Password">
                </label>
            </p>
            <p>
                <input type="submit" name="commit" value="Login">
            </p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>
