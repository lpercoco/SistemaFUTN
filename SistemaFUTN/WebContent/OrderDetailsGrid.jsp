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

			<div class="col-12 col-md-9"></div>
		</div>

		<h2>Order: ${orderToShow.orderNumber}</h2>

		<p>
			<strong>Order state:</strong> ${orderToShow.orderState}
		</p>
		
		<p>
			<strong>Order date:</strong> ${orderToShow.orderDate}
		</p>
		
		<p>
			<strong>Estimate delivery date:</strong> ${orderToShow.deliveryDate}
		</p>
		
		<p>
			<strong>Finished date:</strong> ${orderToShow.finishDate}
		</p>
		
		<p>
			<strong>Delivey date:</strong> ${orderToShow.deliveryDate}
		</p>
		
		<p>
			<strong>Total amount:</strong> ${orderToShow.totalAmount}
		</p>
		
		<table class="table">
			<thead>
				<tr>
					<td width="10%">Title</td>
					<td width="10%">Number of copies</td>
					<td width="10%">Duplex</td>
					<td width="10%">Printed</td>
					<td width="10%">Parcial amount</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${orderToShow.details}" var="od">
					<tr>
						<td align="left">${od.item.title}</td>
						<td align="left">${od.numberOfCopies}</td>
						<td align="left">${od.duplex}</td>
						<td align="left">${od.state}</td>
						<td align="left">${od.parcialAmount}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>