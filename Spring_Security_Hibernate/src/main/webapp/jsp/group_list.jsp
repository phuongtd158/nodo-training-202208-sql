<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Group list</h1>
        <a href="/group/add-or-update">Create</a>
        <form action="/group/list" method="get">
            <label>
                <input type="text" name="q" placeholder="Name">
            </label>
            <button>Search</button>
        </form>
        <table style="width:50%">
            <thead>
            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.name}</td>
                    <td>
                        <a href="/group/delete/${group.id}">Delete</a>
                        <a href="/group/edit/${group.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>

