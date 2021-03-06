<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Add credit to a student</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<c:if test="${userAuthenticated!=null}">

			<div class="row row-offcanvas row-offcanvas-right active">

				<jsp:include page="/includes/Menu.jsp"></jsp:include>

				<c:if test="${userAuthenticated.scholar==true}">

					<div class="col-12 col-md-9">

						<form name="AddCreditForm" action="AddCredit" method="post">

							<h2 class="form-heading">Add credit to a student</h2>

							<div class="form-group">
								<label for="legajo" class="sr-only">Legajo</label> <input
									type="text" pattern="[0-9]{5}" name="legajo" id="legajo"
									placeholder="legajo" required autofocus>
							</div>

							<div class="form-group">
								<label for="credit" class="sr-only">Credit</label> <input
									type="number" name="credit" id="credit" step="1" min="0"
									placeholder="credit to add" required>
							</div>

							<input class="btn btn-primary" type="submit" name="Add"
								value="Add">

						</form>

						<c:if test="${exceptionMessage !=null}">
							<jsp:include page="/includes/exceptionMessage.jsp"></jsp:include>
						</c:if>

					</div>

				</c:if>

			</div>

		</c:if>

		<c:if
			test="${userAuthenticated==null || userAuthenticated.scholar==false}">
			<jsp:include page="/includes/permissionMessage.jsp"></jsp:include>
		</c:if>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>