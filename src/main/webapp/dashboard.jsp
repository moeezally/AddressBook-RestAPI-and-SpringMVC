
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>DashBoard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="background-image: url('resources/bg.jpeg'); padding: 15px">
<%
    if(request.getSession().getAttribute("email")==null){
        response.sendRedirect("/?login=false");
        return;
    }
%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8" style="background: rgba(255,255,255,0.8);padding: 10px ">
            <div style="display: flex;justify-content: space-between;">
                <div>
                    <h1>DASHBOARD</h1>
                </div>

                <div style="display: inline">
                    <span class="btn btn-secondary">Current User: <%=request.getSession().getAttribute("email")%></span>
                    <a role="button" class="btn btn-secondary" href="addNewAddress" style=" height: fit-content">Add new
                        Address </a>
                    <a role="button" class="btn btn-secondary" href="logout" style=" height: fit-content">Logout</a>
                </div>


            </div>
            <hr>
            <div role="alert" class="alert alert-info"> ${msg} </div>

                <table class="table table-striped table-hover">

                    <thead>
                    <tr>
                        <th> ID</th>
                        <th> Name</th>
                        <th> Gender</th>
                        <th> City</th>
                        <th> Country</th>
                        <th> Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="address" items="${allAddresses}" varStatus="counter">
                            <tr>
                                <td><c:out value="${address.id}"/></td>
                                <td><c:out value="${address.name}"/></td>
                                <td><c:out value="${address.gender}"/></td>
                                <td><c:out value="${address.city}"/></td>
                                <td><c:out value="${address.country}"/></td>
                                <td><a href='updateAddress?id=${address.id}'>Update</a> | <a href='deleteAddress?id=${address.id}'>Delete</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</body>
</html>
