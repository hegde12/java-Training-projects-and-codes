<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Donotion Camps</title>
</head>
<body>
<header>List Of All Blood Donation camps</header>
<table>
	<tr>
		<th>Camp ID</th>
		<th>Donor Name</th>
		<th> Address</th>
		<th>AreaCode</th>

	</tr>
	
<c:forEach  items="${data }"  var="eachItem">
     <tr>
          <th>${eachItem.campname }</th>
          <th>${eachItem.donorname }</th>
          <th>${eachItem.address }</th>
          <th>${eachItem.areacode }</th>

          
     </tr>
</c:forEach>
</table>

</body>
</html>