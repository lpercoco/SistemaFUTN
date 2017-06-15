<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Login</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<div class="container">

		<div class="jumbotron">
			<h1>FUTN</h1>
			<p>UTN FRRO copy center</p>
		</div>

		<div class="login-body">
			<form class="form-signin" action="Login" method="post">

				<h2 class="form-signin-heading">Please sign in</h2>

				<label for="legajoLogin" class="sr-only">Legajo</label> <input
					type="text" name="legajoLogin" class="form-control"
					placeholder="Legajo" required autofocus> <label
					for="passwordLogin" class="sr-only">Password</label> <input
					type="password" name="passwordLogin" class="form-control"
					placeholder="Password" required> <input type="submit"
					name="login" class="btn btn-lg btn-primary btn-block">
			</form>
		</div>

		<c:if test="${exceptionMessage !=null}">

			<div class="alert alert-warning">
				<c:out value="${exceptionMessage}" />
			</div>

		</c:if>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>

</body>
</html>