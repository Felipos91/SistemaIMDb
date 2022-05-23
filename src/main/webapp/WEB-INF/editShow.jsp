<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Add Show</title>
</head>
<body>

	<jsp:include page="template/navbar.jsp">
		<jsp:param value="" name="title" />
	</jsp:include>

	<c:if test="${Correcto!=null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${Correcto}"></c:out>
		</div>
	</c:if>

	<c:if test="${Error!=null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${Error}"></c:out>
		</div>
	</c:if>

	<div class="container my-3">
		<h3>Create A New Show</h3>
	</div>


	<form:form method="post" action="/updateShow" class="container w-75"  modelAttribute="show">
		<form:input type="hidden" class="form-control" path="id" value="" />
		
		<div class="mb-3 row">
			<form:label for="name" path="name" class="form-label col-sm-2 col-form-label fw-bold"> Show title:</form:label>
		<div class="col-sm-10">
				<form:input type="text" path="name" class="form-control" id="name"/>
		</div>
		</div>
		
		<div class="mb-3 row">
			<form:label for="cadena" path="cadena" class="form-label col-sm-2 col-form-label fw-bold"> Network:</form:label>
			<div class="col-sm-10">
				<form:input type="text" path="cadena" class="form-control" id="cadena"/>
			</div>
		</div>
		<div class="text-center">
			<button type="submit" class="btn btn-primary">Edit</button>
		</div>
		</form:form>
		
		<div class="container mb-2">
		<a href="/deleteShow/${show.id}" class="btn btn-danger">Delete</a>

		</div>
		
		<div class="container">
		<a href="/home" class="btn btn-info">Go Back</a>

		</div>

</body>
</html>