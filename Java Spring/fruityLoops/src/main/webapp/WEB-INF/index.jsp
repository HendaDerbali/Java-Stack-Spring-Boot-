<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
	<link rel="stylesheet" 	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>

test
	<table class="table">
	
			<tr>
				<th>name</th>
				<th>price</th>
			</tr>

			<c:forEach var="oneFruit" items="${fruits}">
				<tr>
					<td><c:out value="${oneFruit.name}"></c:out></td>
					<td><c:out value="${fruit.name}"></c:out></td>
				</tr>

			</c:forEach>
		

	</table>
</body>
</html>