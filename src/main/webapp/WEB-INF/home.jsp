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
<title>Home IMDb</title>
</head>
<body>

<jsp:include page="template/navbar.jsp">
		<jsp:param value="Dirección" name="title" />
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
	
	<div class="text-center mt-4">
	<h1>Show List Added by You and Other Users</h1>
	</div>
<div class="d-flex justify-content-center mt-2">
	<section class="h-100 mx-5 my-2 w-50">
			<div class="h-100">
				<div class="row  h-100">
					<div class="col-12">
						<div class="card shadow-lg">
							<div class="card-body p-5">


								<div class="row text-center">
									<div class="col">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">Register Date</th>
													<th scope="col">Show Name</th>
													<th scope="col">NetWork</th>
													<th scope="col">Audience Rating</th>													
												</tr>
											</thead>
											<tbody>
												<c:forEach var="show" items="${ShowList}">
													
													<tr>
														<td><c:out value="${show.createdAt}"></c:out></td>
														<td><a href="/editShow/${show.id}" role="button">${show.name}</a></td>
														<td><c:out value="${show.cadena}"></c:out></td>
														<td><c:out value="${show.calificacion}"></c:out></td>
													</tr>
													
												</c:forEach>
												
											</tbody>
										</table>
									</div>

								</div>

							</div>

						</div>

					</div>
				</div>
			</div>
		</section>
</div>
</body>
</html>