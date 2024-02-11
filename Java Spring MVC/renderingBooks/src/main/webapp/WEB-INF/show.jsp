
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- //test -->

	<h1>Title:
		<c:out value="${book.title}"></c:out>
	</h1>
	<p>Description:
		<c:out value="${book.description}"></c:out>
	</p>
	<p>Language:
		<c:out value="${book.numberOfPages}"></c:out>
	</p>
	<p>Number of Pages:
		<c:out value="${book.title}"></c:out>
	</p>

</body>
</html>