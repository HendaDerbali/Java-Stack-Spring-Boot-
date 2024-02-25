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




	<h1>
		Welcome,
		<c:out value="${user.name}" />
		!
	</h1>
	<p>Books from everyone's shelves</p>

	<!-- Logout -->
	<p>
		<a href="/logout">logout</a>
	</p>
	<a href="books/new">+ Add a to my shelf!</a>


	<!-- Table To Display All Books -->
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- Display All Books ( related to all users not only the actual user that whay we use books, because user.books will display only books for the logged user-->
			<c:forEach var="book" items="${books}">
				<c:if test="${user.id!=book.borrower.id}">
					<tr>
						<td><c:out value="${book.bookId}" /></td>
						<td><a href="books/${book.bookId}"> <c:out
									value="${book.title}" /></a></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.user.name}" /></td>
						<c:if test="${user!=book.user}">
							<td><a href="/books/${book.bookId}/borrow">borrow</a></td>
						</c:if>
						<c:if test="${user==book.user}">
							<td><a href="/books/${book.bookId}/edit"
								class="btn btn-primary">Edit</a> <!-- Delete -->
								<form action="/deleteBook/${book.bookId}" method="post"
									style="display: inline">
									<input type="hidden" name="_method" value="delete">
									<button type="submit" class="btn btn-danger">Delete</button>
								</form></td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>


	<!-- TableTo display Books Borrowed By the actual user -->

	<h3>Books I'm Borrowing</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- Display All Dojos ( related to all users not only the actual user that whay we use books, because user.books will display only books for the logged user-->
			<c:forEach var="book" items="${books}">
				<c:if test="${user.id==book.borrower.id}">

					<tr>
						<td><c:out value="${book.bookId}" /></td>
						<td><a href="books/${book.bookId}"> <c:out
									value="${book.title}" /></a></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.user.name}" /></td>
						<td><a href="books/${book.bookId}/return">Return</a></td>
					</tr>
				</c:if>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>