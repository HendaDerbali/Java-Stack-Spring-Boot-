<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Only in Form page to use data binding and to deal with Model error validation -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- The Logged User is -->
	<h1>
		The logged User is :
		<c:out value="${user.name}" />
	</h1>

	<h2>
		<c:out value="${book.title}" />
		on the Shore
	</h2>
	<h3>
		<c:out value="${book.user.name}" />
		read
		<c:out value="${book.title}" />
		by
		<c:out value="${book.author}" />
	</h3>
	<h4>
		Here are
		<c:out value="${book.user.name}" />
		's thoughts:
	</h4>
	<p>
		<c:out value="${book.thoughts}" />
	</p>


	<!-- Ninja Bonus: Allow users to edit/delete the books they have added.  -->
	<c:choose>
		<c:when test="${user.id == book.user.id}">
			<!-- Display editable button -->
			<a href="/books/${book.bookId}/edit" class="btn btn-primary">Edit</a>
			<!-- Delete -->
			<form action="/deleteBook/${book.bookId}" method="post"
				style="display: inline">
				<input type="hidden" name="_method" value="delete">
				<button type="submit" class="btn btn-danger">Delete</button>
			</form>
		</c:when>
		<c:otherwise>
			<!-- Display non-editable button -->
			<button class="btn btn-primary" disabled>Edit</button>
		</c:otherwise>
	</c:choose>






</body>
</html>