<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Add Address</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body style="background-image: url('resources/bg.jpeg');padding: 15px">
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
      <h1>
        Update Address
      </h1>
      <form:form action="processUpdate" modelAttribute="updateAddress">
        <form:hidden path="id"/>
        <div class="form-group">

          <form:label path="name">
            Name
          </form:label>
          <form:input cssClass="form-control" id="name" path="name"/>
        </div>
        <div class="form-group">

          <form:label path="city">
            City
          </form:label>
          <form:input cssClass="form-control" id="city" path="city"/>
        </div>
        <div class="form-group">

          <form:label path="country">
            Country
          </form:label>
          <form:input  cssClass="form-control" id="country" path="country"/>
        </div>
        <div class="form-group">
          <label for="gender">
            Gender
          </label>
          <div id="gender">
            <div class="form-check form-check-inline">
              <form:radiobutton cssClass="form-check-input"  path="gender" id="male" value="male"/>
              <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
              <form:radiobutton cssClass="form-check-input" path="gender" id="female" value="female"/>
              <label class="form-check-label" for="female">Female</label>
            </div>
          </div>
        </div>
        <button type="submit" class="btn btn-secondary" name="submit">
          Update Address
        </button>
      </form:form>
    </div>
    <div class="col-md-2">
    </div>

  </div>
</div>

</body>
</html>
