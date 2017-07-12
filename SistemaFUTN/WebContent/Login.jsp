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
			<h1 class="text-center">FUTN</h1>
			<p class="text-center">UTN FRRO copy center</p>
		</div>

		<div class="col-md-4 col-md-offset-4">
			<form class="form-login" action="Login" method="post">

				<h2 class="form-signin-heading">Please sign in</h2>

				<label for="legajoLogin" class="sr-only">Legajo</label> <input
					type="text" pattern="[0-9]{5}" name="legajoLogin" class="form-control"
					placeholder="Legajo" required autofocus> <label
					for="passwordLogin" class="sr-only">Password</label> <input
					type="password" name="passwordLogin" class="form-control"
					placeholder="Password" required> <input type="submit"
					value="Login" name="login" class="btn btn-lg btn-primary btn-block">
			</form>

			<c:if test="${exceptionMessage !=null}">
				<jsp:include page="/includes/exceptionMessage.jsp"></jsp:include>
			</c:if>

		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>

</body>
</html>