<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Expense Details</h1>
	<p><a href="/">Go Back</a></p>
	<p>
		Expense Name :
		<c:out value="${expense.name}"></c:out>
	</p>
	<p>
		Description:
		<c:out value="${expense.description}"></c:out>
	</p>
	<p>
		Language:
		<c:out value="${expense.vendor}"></c:out>
	</p>
	<p>
		Number of Pages:
		<c:out value="${expense.amount}"></c:out>
	</p>

</body>
</html>