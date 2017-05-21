<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Cart</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

			<div class="col-12 col-md-9">

				<!-- modificable -->

				<h2>order in process</h2>

				<table class="table">
					<thead>
						<tr>
							<td width="10%">Title</td>
							<td width="10%">Number of copies</td>
							<td width="10%">Duplex</td>
							<td width="10%">Subtotal</td>
							<td width="10%"></td>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${orderDetails}" var="od">
							<tr>
								<td align="left">${od.item.title}</td>
								<td align="left">${od.numberOfCopies}</td>
								<td align="left">${od.duplex}</td>
								<td align="left">${od.parcialAmount}</td>
								<td align="left">
									<form name="CancelItemForm" action="CancelItem" method="post">
										
										<div class="form-group">
										<input type="hidden" name="orderDetailToDelate" value="${od}" />
										</div>
										
										<div class="form-group">
										<input type="submit" class="btn btn-primary"
											name="Cancel order" value="cancelOrder">
									    </div>
									    
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<form name="CancelForm" action="CancelOrder" method="post">
					<input type="submit" class="btn btn-primary" name="Cancel order"
						value="Cancel order">
				</form>

				<form name="CheckOutForm" action="AddOrder" method="post">
					<input type="submit" class="btn btn-primary" name="CheckOut"
						value="CheckOut">
				</form>

			</div>
		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>