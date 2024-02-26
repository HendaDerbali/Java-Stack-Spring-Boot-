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
<title>New Product</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1><c:out value="${product.name}" /></h1>

	<!-- Categories that are selected by one Product -->
	<c:forEach var="category" items="${product.categories}">
		<ul>
			<li><c:out value="${category.name}" /></li>
		</ul>
	</c:forEach>

	<!-- Associate categories to Product -->
	<h4>Add Category</h4>

	<form action="/editProduct/${product.id}" method="post">
		<select name="categoryId" id="categoryId" class="input">
			<c:forEach var="category" items="${unassignedCategories}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select> <input class="input" class="button" type="submit" value="Add" />
	</form>

</body>
</html>