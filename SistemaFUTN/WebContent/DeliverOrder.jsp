<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Deliver order</title>

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

						<form name="searchOrdersToDeliveryForm"
							action="SearchOrdersToDelivery" method="get">

							<h2 class="form-heading">Get orders to delivery</h2>

							<div class="form-group">
								<label for="legajo" class="sr-only">Legajo</label> <input
									type="text" pattern="[0-9]{5}" name="legajo" id="legajo"
									placeholder="legajo" required autofocus>
							</div>

							<input class="btn btn-primary" type="submit" name="Search"
								value="Search">

						</form>

						<c:if test="${fn:length(ordersToDeliver) gt 0}">

							<h2>Orders to deliver</h2>

							<table class="table">
								<thead>
									<tr>
										<td width="10%">Order number</td>
										<td width="10%">Order date</td>
										<td width="15%">Finish date</td>
										<td width="1%">Total amount</td>
										<td width="10%"></td>
										<!-- para buttom check order -->
										<td width="10%"></td>
										<!-- para buttom retire -->
									</tr>
								</thead>

								<tbody>

									<c:forEach items="${ordersToDeliver}" var="o">

										<tr>
											<td align="left">${o.orderNumber}</td>
											<td align="left">${o.orderDate}</td>
											<td align="left">${o.finishDate}</td>
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

											<td>

												<form name="deliveredForm" action="DeliverOrder"
													method="post">
													<div class="form-group">
														<input type="hidden" name="orderNumber"
															value="${o.orderNumber}" />
													</div>

													<div class="form-group">
														<input type="submit" class="btn btn-primary"
															name="deliveredBtn" value="Delivered">
													</div>
												</form>

											</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</c:if>

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