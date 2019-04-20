<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

    <title>Title</title>
</head>

<body>
<%@include file="/WEB-INF/views/header.jspf"%>

<div class="container">

    <header>Districts</header>

    <div class="card">
        <div class="card-body">
            <a href="/distrcts/add" class="btn btn-primary">Add district</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>District</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${districts}" var="district">
                    <tr>
                        <td>${district.name}</td>
                        <td>
                            <a href="/districts/update/${district.id}" class="btn btn-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${district.id}, '${district.name}')" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>

</html>