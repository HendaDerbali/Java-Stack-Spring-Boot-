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
	<h1>Home Page</h1>
	<a href="products/new">New Product</a> | 
	<a href="categories/new">New Category</a>

	<!-- Display all Products -->
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>
					<!-- loop over all the products to show the  -->
					<c:forEach var="product" items="${products}">
						<ul>
							<li><a href="/products/${product.id}"><c:out value="${product.name}" /></a>
							</li>
						</ul>
					</c:forEach>
				</th>
				<th>
					<!-- loop over all the categories to show all -->
					<c:forEach var="category" items="${categories}">
						<ul>
							<li><a href="categories"><c:out value="${category.name}" /></a>
							</li>
						</ul>
					</c:forEach>
				</th>
			</tr>
		</tbody>
	</table>

</body>
</html>