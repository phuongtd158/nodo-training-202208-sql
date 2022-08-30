<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please input student information</h2><br>
<form:form action="${pageContext.request.contextPath}/student/save" method="post">
    Name: <form:input type="text" path="name"/>
    <form:errors path="name" cssStyle="color: red" cssClass="name"/> <br>
    Age: <form:input type="text" path="age"/>
    <form:errors path="age" cssStyle="color: red" cssClass="age"/>
    <br>
    <button>Submit</button>
</form:form>
</body>
</html>
