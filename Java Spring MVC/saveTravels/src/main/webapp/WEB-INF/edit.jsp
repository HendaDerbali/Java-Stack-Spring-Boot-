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

<!-- Edit Form : add hidden // method = post or put -->
<h1>Edit Burger</h1>
<form:form action="/editExpense/${expense.id}" method="post" modelAttribute="expense"> 
		 <input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">Expense Name</form:label>
			<br />
			<form:errors path="name" class="text-danger" />
			<form:input path="name" style="width:250px;" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label><br />
			<form:errors path="vendor" class="text-danger" />
			<form:input path="vendor" style="width:250px;" />
		</p>
		<p>
			<form:label path="amount">Amount</form:label><br/>
			<form:errors path="amount" class="text-danger" />
			<form:input path="amount" style="width:250px;" />
		</p>
		<p>
			<form:label path="description">Description</form:label><br />
			<form:errors path="description" class="text-danger" />
			<form:input path="description" style="width:250px;" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>