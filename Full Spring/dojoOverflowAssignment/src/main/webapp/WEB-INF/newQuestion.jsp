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
<title>New Question</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- Add Question -->
	<h1>New Question</h1>
	<form:form action="/addQuestion" method="post"
		modelAttribute="question">
		<div class="form-group row">
			<form:label path="name">Name:</form:label>
			<br />
			<form:errors path="name" class="text-danger" />
			<form:input path="name" style="width:250px;" />
		</div>
		<div>
			<label for="listOfTags">Tags:</label> <input class="input"
				name="listOfTags" id="listOfTags" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
</body>
</html>