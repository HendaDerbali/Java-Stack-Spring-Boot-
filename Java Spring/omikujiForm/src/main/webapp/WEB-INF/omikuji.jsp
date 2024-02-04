<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/send" method="POST">
		<div>
			<label>Pick any number from 5 to 25</label>
       		<select name="number">
       			<option>0</option>
       			<option>1</option>
       		</select>
		</div>
		<div>
			<label>Enter the name of any city </label>
       		<input type="text" name="city">
		</div>
		<div>
			<label>Enter the name of any real person </label>
       		<input type="text" name="person">
		</div>
		<div>
			<button type="submit">Send</button>

		</div>

	</form>
</body>
</html>