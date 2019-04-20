<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a flat \"" + title + "\"?")) {
                window.location.href = "/flats/delete/" + id;
            }
        }
    </script>
    <title>Title</title>
</head>

<body>
<%@include file="/WEB-INF/views/header.jspf"%>

<div class="container">

    <header>Flats</header>

    <div class="card">
        <div class="card-body">
            <a href="/flats/add" class="btn btn-primary">Add flat</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Price</th>
                    <th>Year</th>
                    <th>District</th>
                </tr>
                <c:forEach items="${flats}" var="flat">
                    <tr>
                        <td>${flat.price}</td>
                        <td>${flat.year}</td>
                        <td>${flat.district.name}</td>
                        <td>
                            <a href="/flats/update/${flat.id}" class="btn btn-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${flat.id}, '${flat.price}')" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>

</html>