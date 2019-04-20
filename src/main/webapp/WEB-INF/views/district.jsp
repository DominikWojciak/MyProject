<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%@include file="header.jspf" %>

<form:form method="post" modelAttribute="district">

    <div class="container">

        <header>Add district</header>

        <div class="card">
            <div class="card-body">
                <a href="/districts/list" class="btn btn-primary">Back</a>
            </div>
        </div>

        <div class="card mt-4">

            <div class="card-header">
                District data
            </div>
                <div class="form-group">
                    <label for="districtId">District:</label>
                    <form:select path="district" items="${districts}" itemLabel="name" itemValue="id"
                                 class="form-control" id="districtId"/>
                    <form:errors path="district" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="Owners"><Numbers>Estate Agency</Numbers></label>
                    <form:select path="owners" items="${owners}" itemLabel="fullName" itemValue="id"
                                 class="form-control" id="ownersId" />
                    <form:errors path="owners" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="descriptionId">Description:</label>
                    <form:textarea path="description" cols="60" rows="3" class="form-control" id="descriptionId"/>
                    <form:errors path="description" element="div" cssClass="error"/>
                </div>

                <input type="submit" value="Save">

            </div>


        </div>

    </div>

</form:form>

</body>
</html>