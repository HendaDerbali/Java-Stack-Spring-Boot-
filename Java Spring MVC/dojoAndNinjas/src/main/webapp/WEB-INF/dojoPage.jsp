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
<title></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>
		<c:out value="${dojo.name}"></c:out>
	</h1>


	<table class="table table-bordered">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<!-- loop over all the books to show the details as in the wireframe! -->
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${ninja.firstName}" /></td>
					<td><c:out value="${ninja.lastName}" /></td>
					<td><c:out value="${ninja.age}" /></td>
					<td>
						<!-- Delete Ninja-->
						<form action="/deleteNinja/${ninja.id}" method="post"
							style="display: inline">
							<input type="hidden" name="_method" value="delete">
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			<!-- Number of Ninjas that are related to one Dojo -->
			<p>
				There is
				<c:out value="${dojo.ninjas.size()}" />
				ninja(s) for the
				<c:out value="${dojo.name}" />
				dojo
			</p>


		</tbody>
	</table>


</body>
</html>