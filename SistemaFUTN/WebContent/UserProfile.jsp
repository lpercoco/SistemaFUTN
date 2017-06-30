<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Update your profile</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

<jsp:include page="/JS/passwordValidation.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

			<div class="col-12 col-md-9">

				<h2>Update your profile</h2>

				<p><strong> Legajo: </strong> ${userAuthenticated.legajo}</p>
				
				<p><strong>First name: </strong> ${userAuthenticated.firstName}</p>
				
				<p><strong>Last name: </strong> ${userAuthenticated.lastName}</p>
				
				<p><strong>Credit: </strong> ${userAuthenticated.credit}</p>

				<form name="UserRudForm" action="UserUpdate" method="post">

					<div class="form-group">

						<label for="adress" class="sr-only">Adress</label> <input
							type="text" name="adress" id="adress"
							value="${userAuthenticated.adress}" placeholder="Adress" required>
					</div>

					<div class="form-group">
						<label for="phone1" class="sr-only">Phone1</label> <input
							type="text" name="phone1" id="phone1"
							value="${userAuthenticated.phone1}" placeholder="Phone 1"
							required>
					</div>

					<div class="form-group">
						<label for="phone2" class="sr-only">Phone2</label> <input
							type="text" name="phone2" id="phone2"
							value="${userAuthenticated.phone2}" placeholder="Phone 2">
					</div>

					<div class="form-group">
						<label for="mail" class="sr-only">Mail</label> <input type="text"
							name="mail" id="mail" value="${userAuthenticated.mail}"
							placeholder="Mail" required>
					</div>

					<h2>Change your password if you want</h2>

					<div class="form-group">
						<label for="password" class="sr-only">Password</label> <input
							type="password" name="password" id="password"
							placeholder="Password">
					</div>

					<div class="form-group">
						<label for="confirmPassword" class="sr-only">Password</label> <input
							type="password" name="confirmPassword" id="confirmPassword"
							placeholder="Confirm password">
					</div>

					<input type="submit" class="btn btn-primary" name="update"
						value="Update">

				</form>

			</div>
		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>




