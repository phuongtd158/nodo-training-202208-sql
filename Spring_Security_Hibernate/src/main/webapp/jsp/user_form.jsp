<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Add user</h1>
        <a href=""></a>
        <form:form action="${pageContext.request.contextPath}/user/add-or-update" method="post">
            <p>
                <label>
                    <form:input type="text" path="username" placeholder="Username"/>
                </label>
            </p>
            <p>
                <label>
                    <form:input type="password" path="password" placeholder="Password"/>
                </label>
            </p>
            <p>
                <label>
                    <form:input type="email" path="email" placeholder="Email"/>
                </label>
            </p>
            <p>
                <label>
                    <form:input type="number" path="age" placeholder="Age"/>
                </label>
            </p>
            <p>
                <label>
                    <form:select path="group">
                        <form:options items="${groups}"/>
                    </form:select>
                </label>
            </p>
            <p>
                <input type="submit" name="add" value="Add">
            </p>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>
