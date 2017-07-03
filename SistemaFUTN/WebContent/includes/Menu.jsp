<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="sidebar" class="col-6 col-md-3 sidebar-offcanvas">

	<c:if test="${userAuthenticated!=null}">

		<div class="list-group">

			<c:if test="${userAuthenticated.scholar }">
				<!-- si es admin -->
				<a class="list-group-item" href="LinkToPage?url=PriceChange.jsp">Copy price change</a>
				<a class="list-group-item" href="LinkToPage?url=AddUser.jsp">Add a new student</a>
				<a class="list-group-item" href="LinkToPage?url=AddTeachingMaterial.jsp">Add a
					new teaching material</a>
				<a class="list-group-item" href="LinkToPage?url=AddCredit.jsp">Add credit to a
					student</a>
				<a class="list-group-item" href="LinkToPage?url=OrdersGrid.jsp">Orders to print</a>
				<a class="list-group-item" href="LinkToPage?url=DeliverOrder.jsp">Deliver orders</a>
			</c:if>

			<c:if test="${!userAuthenticated.scholar }">
				<!-- si no es admin  -->

				<a class="list-group-item" href="LinkToPage?url=AddTeachingMaterialToOrder.jsp">Add
					teaching material to order</a>
				<a class="list-group-item" href="LinkToPage?url=UserProfile.jsp">My profile</a>

				<c:if test="${fn:length(orders) gt 0}">
					<a class="list-group-item" href="LinkToPage?url=OrdersGrid.jsp">My orders</a>
				</c:if>

				<c:if test="${fn:length(order.details) gt 0}">
					<a class="list-group-item" href="LinkToPage?url=Cart.jsp">Cart</a>
				</c:if>
			</c:if>

		</div>
	</c:if>

</div>

