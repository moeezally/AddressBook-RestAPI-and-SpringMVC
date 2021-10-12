<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        h1 {
            color: white;
        }
    </style>
</head>
<body  style="background-image: url('resources/bg.jpeg'); padding: 15px">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">

                <div class="col-md-12">
                    <h1>Login to Access Address Book</h1>
                    <form:form action="loginCheck" modelAttribute="user"  cssStyle="background: rgba(255,255,255,0.8);padding: 10px ">
                        <hr>
                        <h5 role="alert" class="alert alert-info"> ${msg}
                        </h5>
                        <hr>
                        <div class="form-group">

                            <form:label path="email">
                                Email address
                            </form:label>
                            <form:input type="email" cssClass="form-control" id="email" path="email"
                                        placeholder="Enter your e-mail"/>
                        </div>
                        <hr>
                        <div class="form-group">

                            <form:label path="password">
                                Password
                            </form:label>
                            <form:input type="password" cssClass="form-control" id="password" path="password"
                                        placeholder="Enter password"/>
                        </div>
                        <hr>

                        <button type="submit" class="btn btn-primary btn-block" name="submit">
                            Login
                        </button>
                        <hr>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</body>
</html>