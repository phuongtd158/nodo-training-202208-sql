<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h2>${message}</h2>
    </tiles:putAttribute>
</tiles:insertDefinition>



