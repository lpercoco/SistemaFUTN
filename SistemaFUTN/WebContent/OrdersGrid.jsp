<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<c:if test="${userAuthenticated!=null}">

			<div class="row row-offcanvas row-offcanvas-right active">

				<jsp:include page="/includes/Menu.jsp"></jsp:include>

				<div class="col-12 col-md-9">

					<c:if
						test="${(fn:length(orders) gt 0 && userAuthenticated.scholar ) || (!userAuthenticated.scholar)}">

						<h2>Pending orders</h2>

						<table class="table">
							<thead>
								<tr>
									<td width="10%">Order number</td>
									<td width="10%">Ready</td>
									<td width="15%">Order date</td>
									<td width="15%">Estimate delivery date</td>

									<c:if test="${!userAuthenticated.scholar}">
										<td width="15%">Finish date</td>
									</c:if>

									<td width="1%">Total amount</td>
									<td width="10%"></td>
								</tr>
							</thead>

							<tbody>

								<c:forEach items="${orders}" var="o">

									<!-- si es becario, muestra ordenes con algun item pendiente  -->
									<!-- si es estudiante, muestra ordenes que no se retiraron(terminadas o no) -->

									<c:if
										test="${(empty o.deliveryDate && ! userAuthenticated.scholar) || (userAuthenticated.scholar && !o.orderState)}">
										<tr>
											<td align="left">${o.orderNumber}</td>
											<td align="left">${o.orderState}</td>
											<td align="left">${o.orderDate}</td>
											<td align="left">${o.estimatedDeliveryDate}</td>

											<c:if test="${!userAuthenticated.scholar}">
												<td align="left">${o.finishDate}</td>
											</c:if>

											<td align="left">${o.totalAmount}</td>

											<td>
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

					<c:if
						test="${(fn:length(orders)==0 && userAuthenticated.scholar )}">

						<c:if test="${exceptionMessage !=null}">
							<jsp:include page="/includes/exceptionMessage.jsp"></jsp:include>
						</c:if>

						<form name="refreshForm" action="refreshOrdersToPrint"
							method="get">
							<div class="form-group">
								<input type="submit" class="btn btn-primary" name="Refresh"
									value="Refresh">
							</div>
						</form>
					</c:if>

				</div>

			</div>

		</c:if>

		<c:if test="${userAuthenticated==null}">
			<jsp:include page="/includes/permissionMessage.jsp"></jsp:include>
		</c:if>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>