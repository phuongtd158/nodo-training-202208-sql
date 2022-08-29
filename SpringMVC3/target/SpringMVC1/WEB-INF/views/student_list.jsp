<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/list" method="get">
    <div style="width: 50%; margin: 0 auto 5px;">
        <input type="text" name="q">
        <button>Search</button>
    </div>
    <table border="1" style="width: 50%; margin: 0 auto;">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td colspan="3">
                    <a href="/student/delete/${student.id}">Delete</a>
                    <a href="/student/edit/${student.id}">Edit</a>
                    <a href="javascript:view(${student.id})">View</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>

<dialog id="viewStudent" style="width: 50%; border: 1px dotted black;">
    <div id="content"></div>
    <button id="hide">Close</button>
</dialog>

<script>
    function view(id) {
        const xmlHttp = new XMLHttpRequest();

        xmlHttp.open("GET", "json/" + id, true);
        xmlHttp.onload = function () {
            if (this.status !== 200) {
                return;
            }
            console.log(this.responseText);

            const student = JSON.parse(this.responseText);
            document.getElementById("content").innerHTML = "Name: " + student.name +
                '<img src="/student/avatar/' + student.id + '"/>'
            const dialog = document.getElementById("viewStudent");
            dialog.show();
        }
        xmlHttp.send();
    }

    const dialog = document.getElementById("viewStudent");
    document.getElementById("hide").onclick = function () {
        dialog.close();
    }
</script>
</body>
</html>
