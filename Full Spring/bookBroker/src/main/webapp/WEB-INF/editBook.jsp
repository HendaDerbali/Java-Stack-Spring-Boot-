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
<title>Book Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- Edit Form : add hidden // method = post or put -->
	<h1>Edit Book</h1>
	<form:form action="/editBook/${book.bookId}" method="post"
		modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		<div class="form-group row">
			<form:label path="title">Title:</form:label>
			<br />
			<form:errors path="title" class="text-danger" />
			<form:input path="title" style="width:250px;" />
		</div>
		<div class="form-group row">
			<form:label path="author">Author:</form:label>
			<br />
			<form:errors path="author" class="text-danger" />
			<form:input path="author" style="width:250px;" />
		</div>
		<div class="form-group row">
			<form:label path="thoughts">My thoughts:</form:label>
			<br />
			<form:errors path="thoughts" class="text-danger" />
			<form:textarea path="thoughts" style="width:250px;" rows="3"></form:textarea>
		</div>
		<!-- This is a hidden row to submit user id when creating a new Book -->
		<div class="form-group row">
			<form:errors path="user" class="error" />
			<form:input type="hidden" path="user" value="${user.id}"
				class="form-control" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>

	<!-- Delete Book-->
	<form action="/deleteBook/${book.bookId}" method="post"
		style="display: inline">
		<input type="hidden" name="_method" value="delete">
		<button type="submit" class="btn btn-danger">Delete</button>
	</form>

</body>
</html>