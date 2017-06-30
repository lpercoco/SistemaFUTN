<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

						<c:forEach items="${order.details}" var="od">
							<tr>
								<td align="left">${od.item.title}</td>
								<td align="left">${od.numberOfCopies}</td>
								<td align="left">${od.duplex}</td>
								<td align="left">${od.parcialAmount}</td>
								<td align="left">
									<form name="CancelItemForm" action="CancelItem" method="post">

										<div class="form-group">
											<input type="hidden" name="orderDetailToDelate"
												value="${od.orderDetailNumber}" />
										</div>

										<div class="form-group">
											<input type="submit" class="btn btn-primary"
												name="CancelItem" value="Cancel item">
										</div>

									</form>
								</td>
							</tr>
						
						</c:forEach>
						    <tr>
						    <!-- ? -->
						        <td>TOTAL</td>
						        <td></td>
						        <td></td>
						        <td align="left">${order.totalAmount}</td>
						        <td></td> 
						    </tr>
					</tbody>
				</table>

				<c:if test = "${fn:length(order.details) gt 0}">
					<div class="row">

						<div class="form-group col-xs-6">
							<form action="AddTeachingMaterialToOrder.jsp" method="get">
								<input type="submit" class="btn btn-primary" value="Add other"
									name="Submit" />
							</form>
						</div>

						<div class="form-group col-xs-6">
							<form name="CheckOutForm" action="AddOrder" method="post">
								<input type="submit" class="btn btn-primary" name="CheckOut"
									value="CheckOut">
							</form>
						</div>

					</div>
				</c:if>

			</div>
		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>