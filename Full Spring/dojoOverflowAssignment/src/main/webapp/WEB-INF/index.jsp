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
<title>Questions Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<a href="questions/new"><Button>Add New Question</Button></a>


	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Questions</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<!-- loop over all the dojos to show the details as in the wireframe! -->
			<c:forEach var="question" items="${questions}">
				<tr>
					<td><c:out value="${question.name}" /></td>
					<td><c:forEach var="tag" items="${question.tags}">
							<span class="tag"><c:out value="${tag.name}" /></span>; 
               			</c:forEach></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>