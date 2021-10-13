<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://www.springframework.org/tags/form"  prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Registration Form</title>
</head>
<body>
<header>Donate and Save Lives !</header>
<div>
<form:form action="/addDonor" modelAttribute="command" method="post"  >
        <div>
            <label for="">Donor ID</label>
            <form:input path="id"/>
        </div>
        
        <div>
            <label for="">Donor Name</label>
            <form:input path="donorname"/>
        </div>
        
        <div>
            <label for="">Donor Age</label>
            <form:input path="age"/>
        </div>
        <div>
        <label for="">Blood Group</label>
        <form:input path="bloodgroup"/>
        </div>
        
        <div>
        <label for="">Area Code</label>
        <form:input path="areacode"/>
        </div>
        
        
        <div>
            <input type = "submit" value = "Register !">
        </div>
</form:form>
</div>




</body>
</html>