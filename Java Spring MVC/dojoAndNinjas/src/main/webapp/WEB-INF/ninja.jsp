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
 <!-- Add Ninja -->
	<h1>New Ninja</h1>
	<form:form action="/addNinja" method="post" modelAttribute="ninja">
		<div class="form-group row">
			<form:label path="firstName">First Name:</form:label><br />
			<form:errors path="firstName" class="text-danger" />
			<form:input path="firstName" style="width:250px;" />
		</div>
		<div class="form-group row">
			<form:label path="lastName">Last Name:</form:label><br />
			<form:errors path="lastName" class="text-danger" />
			<form:input path="lastName" style="width:250px;" />
		</div>
		<div class="form-group row">
			<form:label path="age">Age:</form:label><br />
			<form:errors path="age" class="text-danger" />
			<form:input path="age" style="width:250px;" />
		</div>
		<div class="form-group row">
        <form:select path="dojo" >
        
        	<c:forEach var="oneDojo" items="${dojos}"> 
	        	<option value="${oneDojo.id}">
	        		<c:out value="${oneDojo.name}"/>
	        	</option>
	        </c:forEach>
        	
        </form:select>
        </div>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>
</body>
</html>