<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>User list</h1>
        <a href="/user/add-or-update">Create</a>
        <form action="/user/list" method="get">
            <label>
                <input type="text" name="q" placeholder="Name">
            </label>
            <button>Search</button>
        </form>
        <table style="width:50%">
            <thead>
            <tr style="font-weight: bolder">
                <td>Username</td>
                <td>Email</td>
                <td>Age</td>
                <td>Group</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.age}</td>
                    <td>${user.group.name}</td>
                    <td>
                        <a href="/user/delete/${user.username}">Delete</a>
                        <a href="/user/edit/${user.username}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>