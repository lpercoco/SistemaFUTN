<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Update your profile</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

<jsp:include page="/JS/passwordValidation.jsp"></jsp:include>

<jsp:include page="/JS/showUserUpdate.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<c:if test="${userAuthenticated!=null}">

			<div class="row row-offcanvas row-offcanvas-right active">

				<jsp:include page="/includes/Menu.jsp"></jsp:include>

				<c:if test="${userAuthenticated.scholar==false}">

					<div class="col-12 col-md-9">

						<h2>${userAuthenticated.firstName}
							${userAuthenticated.lastName} profile</h2>

						<p>
							<strong> Legajo: </strong> ${userAuthenticated.legajo}
						</p>

						<p>
							<strong>Credit: </strong> ${userAuthenticated.credit}
						</p>

						<p>
							<strong>Adress: </strong> ${userAuthenticated.adress}
						</p>

						<p>
							<strong>Phone 1: </strong> ${userAuthenticated.phone1}
						</p>

						<c:if test="${not empty userAuthenticated.phone2}">
							<p>
								<strong>Phone 2: </strong> ${userAuthenticated.phone2}
							</p>
						</c:if>

						<p>
							<strong>Email: </strong> ${userAuthenticated.mail}
						</p>

						<div class="row">

							<div class=" col-xs-6">
								<input type="submit" class="btn btn-primary pull-left"
									value="Change personal data" name="personal"
									onclick="showPersonalForm()" />
							</div>


							<div class=" col-xs-6">
								<input type="submit" class="btn btn-primary pull-right"
									name="password" value="Change password"
									onclick="showPasswordForm()">
							</div>

						</div>

						<form name="UserRudForm" action="UserUpdate" method="post">

							<div id="personalDataDiv" style="display: none;">

								<h3>Update your data</h3>

								<div class="form-group">

									<label for="adress">Adress</label> <input type="text"
										name="adress" id="adress" value="${userAuthenticated.adress}"
										placeholder="Adress" required>
								</div>

								<div class="form-group">
									<label for="phone1">Phone 1</label> <input type="tel"
										name="phone1" id="phone1" value="${userAuthenticated.phone1}"
										placeholder="Phone 1" pattern="[- \d]*"
										title="Enter a phone number" required>
								</div>

								<div class="form-group">
									<label for="phone2">Phone 2</label> <input type="tel"
										name="phone2" id="phone2" value="${userAuthenticated.phone2}"
										placeholder="Phone 2" pattern="[- \d]*"
										title="Enter a phone number">
								</div>

								<div class="form-group">
									<label for="mail">Email</label> <input type="text" name="mail"
										id="mail" value="${userAuthenticated.mail}"
										placeholder="Email" required>
								</div>
							</div>

							<div id="passwordDiv" style="display: none;">
								<h3>Change your password</h3>

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

							</div>

							<div id="btnUpdate" style="display: none;">
								<input type="submit" class="btn btn-primary" name="update"
									value="Update">
							</div>
						</form>

					</div>

				</c:if>

			</div>

		</c:if>

		<c:if
			test="${userAuthenticated==null || userAuthenticated.scholar==true}">
			<jsp:include page="/includes/permissionMessage.jsp"></jsp:include>
		</c:if>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>




