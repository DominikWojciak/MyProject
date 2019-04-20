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

<form:form method="post" modelAttribute="flat">

    <div class="container">

        <header>Add flat</header>

        <div class="card">
            <div class="card-body">
                <a href="/flats/list" class="btn btn-primary">Back</a>
            </div>
        </div>

        <div class="card mt-4">

            <div class="card-header">
                Flat data
            </div>

            <div class="card-body">

                <div class="row">
                    <div class="form-group col-md-4">
                        <label for="priceId">Price:</label>
                        <form:input path="price" class="form-control" id="priceId"/>
                        <form:errors path="price" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-2">
                        <label for="yearId">Year:</label>
                        <form:input type="number" path="year" min="1900" max="2030" class="form-control" id="yearId"/>
                        <form:errors path="year" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="m2Id">M2:</label>
                        <form:input type="number" path="m2" class="form-control" id="m2Id"/>
                        <form:errors path="m2" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="numberOfRoomsId">Numbers of rooms</label>
                        <form:input type="number" path="numberOfRooms" class="form-control" id="numberOfRoomsId"/>
                        <form:errors path="numberOfRooms" element="div" cssClass="error"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="floorId">Floor</label>
                        <form:input type="number" path="floor" class="form-control" id="floorId"/>
                        <form:errors path="floor" element="div" cssClass="error"/>
                    </div>

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