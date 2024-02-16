<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- New line below to use the JSP Standard Tag Library -->
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!-- Only in Form page to use data binding and to deal with Model error validation -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    	
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<!-- for Bootstrap CSS -->
	<link rel="stylesheet" 	href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<!-- Edit Form : add hidden // method = post or put -->
<h1>Edit Burger</h1>
<form:form action="/editBurger/${burger.id}" method="post" modelAttribute="burger"> 
		 <input type="hidden" name="_method" value="put">
		<p>
			<form:label path="burgerName">Burger Name</form:label><br/>
			<form:errors path="burgerName"  class="text-danger"/>
			<form:input path="burgerName" style="width:250px;" />
			
		</p>
		<p>
			<form:label path="restaurantName">Restaurant Name</form:label><br/>
			<form:errors path="restaurantName" class="text-danger" />
			<form:input path="restaurantName" style="width:250px;"/>
		</p>
		<p>
			<form:label path="rating">Rating</form:label><br/>
			<form:errors path="rating" class="text-danger" />
			<form:input type="number" path="rating"  style="width:250px;"/>
		</p>
		<p>
			<form:label path="notes">Notes</form:label><br/>
			<form:errors path="notes" class="text-danger"/>
			<form:textarea path="notes" style="width:250px;"/>
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>