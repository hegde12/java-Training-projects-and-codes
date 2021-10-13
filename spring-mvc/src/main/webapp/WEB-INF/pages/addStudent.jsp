<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add Student</title>
</head>
<body>

<div>
	<form:form action="/addStudent" modelAttribute="command"  method="post">
	<div>
	<label for="">Roll Number</label>
	<form:input path="rollNumber"/>
	<form:errors path="rollNumber" cssStyle="color:red;"></form:errors>
	</div>
	
	<div><label for="">Student Name</label>
	<form:input path="studentName"/>
	<form:errors path="studentName" cssStyle="color:red;"></form:errors>
	</div>
	<div>
	<label for="">Date of birth</label>
	<form:input type="date" path="dateOfBirth"/></div>
	
	<div>
	<label for="">Mark Scored</label>
	<form:input path="markScored"/></div>
	
	<div>
	<input type="submit" value="Add"></div>
	</form:form>
</div>
</body>
</html>