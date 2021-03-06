<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Change the price of the copy</title>

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

						<h1>Change the price of the copy</h1>

						<h3>Current copy price</h3>

						<p>Begin date: ${currentCopyPrice.beginDate}</p>

						<p>Simple copy: ${currentCopyPrice.simplePrice}</p>

						<p>Duplex copy: ${currentCopyPrice.duplexPrice}</p>

						<h3>New copy price</h3>

						<form name="PriceChangeForm" action="PriceChange" method="post">

							<div class="form-group">
								<label for="simple">Simple</label> <input type="number"
									name="simple" id="simple" step="0.01" min="0"
									value="${currentCopyPrice.simplePrice}" required autofocus>
							</div>

							<div class="form-group">
								<label for="duplex">Duplex</label> <input type="number"
									name="duplex" id="duplex" step="0.01" min="0"
									value="${currentCopyPrice.duplexPrice}" required>
							</div>

							<input type="submit" name="Save" value="Save"
								class="btn btn-primary">

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