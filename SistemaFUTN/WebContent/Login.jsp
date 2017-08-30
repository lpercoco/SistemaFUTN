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

		<form class="form-signin" action="Login" method="post">

			<h2 class="form-signin-heading text-center">Please sing in</h2>

			<div class="form-group">
				<label for="legajoLogin" class="sr-only">Legajo</label> <input
					type="text" pattern="[0-9]{5}" name="legajoLogin"
					class="form-control" placeholder="Legajo" required autofocus>
			</div>


			<div class="form-group">
				<label for="passwordLogin" class="sr-only">Password</label> <input
					type="password" name="passwordLogin" class="form-control"
					placeholder="Password" required>
			</div>

			<div class="form-group ">
				<input type="submit" value="Login" name="login"
					class="btn btn-lg btn-primary btn-block">
			</div>

		</form>

	</div>

	<c:if test="${exceptionMessage !=null}">
		<jsp:include page="/includes/exceptionMessage.jsp"></jsp:include>
	</c:if>

	<jsp:include page="/includes/Footer.jsp"></jsp:include>


</body>
</html>