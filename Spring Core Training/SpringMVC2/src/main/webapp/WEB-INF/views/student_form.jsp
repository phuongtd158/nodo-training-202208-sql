<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please input student information</h2><br>
    <form:form action="${pageContext.request.contextPath}/student/save-or-update" method="post">
        <form:input type="hidden" path="id"/>
        Name: <form:input type="text" path="name"/>
        <form:errors path="name" cssStyle="color: red" cssClass="name"/> <br>
        Age: <form:input type="text" path="age"/>
        <form:errors path="age" cssStyle="color: red" cssClass="age"/>
        <br>
        <button>Submit</button>
    </form:form>
    <c:if test="${id != null}">
        <h2>Please upload a image</h2>
        <form action="${pageContext.request.contextPath}/student/avatar/save"
              method="POST"
              enctype="multipart/form-data">
            <input type="hidden" name="id" value="${id}">
            <input type="file" name="file">
            <button>Upload</button>
        </form>
    </c:if>
</body>
</html>
