<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="oneMore.jsp">search</a>
<c:set var="location" value="Korse" scope="request"/>
<c:set var="name" value="Gireesh" scope="request"/>
<c:out value="${name}"></c:out>

</body>
</html>