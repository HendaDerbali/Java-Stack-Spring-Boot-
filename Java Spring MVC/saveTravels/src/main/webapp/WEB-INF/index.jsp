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
	<h1>Save Travels</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!-- loop over all the books to show the details as in the wireframe! -->
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/expenses/${expense.id}"><c:out
								value="${expense.name}"></c:out> </a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td>$<fmt:formatNumber type="number" minFractionDigits="2"
							value="${expense.amount}" />
						<c:out value="${expense.amount}"></c:out>
					</td>
					<td><c:out value="${expense.description}"></c:out></td>
					<td>
						<!-- Edit :  --> 
						<a href="/edit/${expense.id}">edit</a>
						<!-- For deletion, we should add this :  -->
    					<form action="/deleteExpense/${expense.id}" method="post" style="display: inline"> 
							<input type="hidden" name="_method" value="delete">
							<button type="submit" class="btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<!-- Add Expense -->
	<h2>Add a Burger</h2>
	<form:form action="/addExpense" method="post" modelAttribute="expense">
		<p>
			<form:label path="name">Expense Name</form:label>
			<br />
			<form:errors path="name" class="text-danger" />
			<form:input path="name" style="width:250px;" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<br />
			<form:errors path="vendor" class="text-danger" />
			<form:input path="vendor" style="width:250px;" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
			<br />
			<form:errors path="amount" class="text-danger" />
			<form:input path="amount" style="width:250px;" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<br />
			<form:errors path="description" class="text-danger" />
			<form:input path="description" style="width:250px;" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>