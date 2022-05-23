<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page='template/header.jsp'>
	<jsp:param name='title' value='registro'/>
</jsp:include>


<body>

	<section class="h-100 mt-5">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">Register</h1>


							<c:if test="${Error!=null}">
								<div class="alert alert-danger" role="alert">
									<c:out value="${Error}"></c:out>
								</div>
							</c:if>


<!--ojo con la estructura del form en el label e input-->
							<form:form method="POST" action="/registro" modelAttribute="usuario">
								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="nombre">Name</form:label> 
									<form:input type="text" class="form-control" path="nombre" value=""
										/>
									<div class="invalid-feedback">Name is required</div>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="email">E-Mail
										Address</form:label> <form:input  type="email" class="form-control"
										path="email" value="" />
									<div class="invalid-feedback">Email is invalid</div>
								</div>

								<div class="mb-3">
									<form:label class="mb-2 text-muted" path="password">Password</form:label>
									<form:input  type="password" class="form-control"
										path="password" value=""/>
									<div class="invalid-feedback">Ingrese Password</div>
								</div>


								<p class="form-text text-muted mb-3">By registering you
									agree with our terms and condition.</p>

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto">
										Register</button>
								</div>
							</form:form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								Already have an account? <a href="/login" class="text-dark">Login</a>
							</div>
						</div>
					</div>
					<div class="text-center mt-5 text-muted">Copyright &copy;
						2017-2021 &mdash; Your Company</div>
				</div>
			</div>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>