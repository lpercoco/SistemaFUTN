<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

			<div class="col-12 col-md-9">

				<c:if test="${not empty orders }">

					<h2>Pending orders</h2>

					<table class="table">
						<thead>
							<tr>
								<td width="10%">Order number</td>
								<td width="10%">Ready</td>
								<td width="15%">Order date</td>
								<td width="15%">Estimate delivery date</td>
								<td width="15%">Finish date</td>
								<td width="1%">Total amount</td>
								<td width="10%"></td>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${orders}" var="o">
								<c:if
									test="${(empty o.deliveryDate && ! userAuthenticated.scholar)}">
									<tr>
										<td align="left">${o.orderNumber}</td>
										<td align="left">${o.orderState}</td>
										<td align="left">${o.orderDate}</td>
										<td align="left">${o.estimatedDeliveryDate}</td>
										<td align="left">${o.finishDate}</td>
										<td align="left">${o.totalAmount}</td>
										<td align="left">
											<form name="orderDetailsGridForm" action="OrderDetailGrid"
												method="get">
												<div class="form-group">
													<input type="hidden" name="orderNumber"
														value="${o.orderNumber}" />
												</div>

												<div class="form-group">
													<input type="submit" class="btn btn-primary"
														name="checkOrder" value="Check order">
												</div>
											</form>
										</td>
									</tr>
								</c:if>
							</c:forEach>

						</tbody>
					</table>
				</c:if>

				<c:if test="${empty orders}">

					<div class="alert alert-warning">
						<c:out value="There are no pending orders"/>
					</div>

				</c:if>

			</div>
		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>