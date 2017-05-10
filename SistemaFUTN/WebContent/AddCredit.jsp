<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Add credit</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

			<div class="col-12 col-md-9">

				<div>
					<form name="AddCreditForm" action="AddCredit" method="post">

						<h2 class="form-heading">Add credit to a student</h2>

						<div class="form-group">
							<label for="legajo" class="sr-only">Legajo</label> <input
								type="text" name="legajo" id="legajo" placeholder="legajo"
								required autofocus>
						</div>

						<!-- buscar legajo y mostrar saldo actual tambien en esta pagina? -->

						<div class="form-group">
							<label for="credit" class="sr-only">Credit</label> <input
								type="number" name="credit" id="credit" step="1" min="0"
								placeholder="credit to add" required>
							<!-- minimo para agregar credito 10$? paso de 1$?  -->
						</div>

						<input class="btn btn-primary" type="submit" name="Add"
							value="Add">

					</form>
				</div>
			</div>

		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->
	
</body>
</html>