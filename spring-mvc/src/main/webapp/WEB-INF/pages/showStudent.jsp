<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
border:2px solid blue;
margin-left:auto;
margin-right:auto;
border-collapse:collapse;
}
tr,td,th {
border:2px solid blue;
}
</style>
</head>
<body>
<table>
<tr>
<th>RollNumber</th>
<th>StudentName</th>
<th>DataOfBirth</th>
<th>MarkScored</th>
</tr>
<c:forEach items="${data}" var="eachItem">
<tr>
	<td>${eachItem.rollNumber}</td>
	<td>${eachItem.studentName}</td>
	<td>${eachItem.dateOfBirth}</td>
	<td>${eachItem.markScored}</td>
</tr>
</c:forEach>
</table>
</body>
</html>