<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="2">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Available</th>
    </tr>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td>${owner.firstName}</td>
            <td>${owner.lastName}</td>
            <td>
                <a href="/owners/update/${owner.id}">Edit</a>
                <a href="/owners/delete/${owner.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
