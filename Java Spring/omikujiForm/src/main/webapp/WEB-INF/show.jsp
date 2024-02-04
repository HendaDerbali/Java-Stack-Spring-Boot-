<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<p>
		In
		<c:out value="${number}" />
		year, you will live in
		<c:out value="${city}" />
		with
		<c:out value="${person}" />
		...
	</p>
	<a href="/omikuji">Go Back</a>

</body>
</html>