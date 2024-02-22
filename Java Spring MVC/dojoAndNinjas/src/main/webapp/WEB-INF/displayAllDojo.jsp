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
	<h1>Diplay All Dojos</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Dojo Name</th>
				<th>Actions</th>	
			</tr>
		</thead>
		<tbody>
			<!-- loop over all the dojos to show the details as in the wireframe! -->
			<c:forEach var="dojo" items="${dojos}">
				<tr>
					<td><c:out value="${dojo.name}" /></td>
					<td>
						<!-- Delete -->
						<form action="/deleteDojo/${dojo.id}" method="post"
							style="display: inline">
							<input type="hidden" name="_method" value="delete">
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>


			</c:forEach>
		</tbody>
	</table>
</body>
</html>