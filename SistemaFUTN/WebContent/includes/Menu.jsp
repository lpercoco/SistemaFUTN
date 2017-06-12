<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="entidades.OrderDetail"%>
<%@page import="entidades.User"%>
<%
	User user = (User) request.getSession().getAttribute("userAuthenticated");
%>


<div id="sidebar" class="col-6 col-md-3 sidebar-offcanvas">

	<div class="list-group">
		<%
			if (user != null) {
		%>
		<%
			if (user.isScholar()) {
		%>
		<!-- si es admin --> 
		<a class="list-group-item" href="PriceChange.jsp">Copy price
			change</a> <a class="list-group-item" href="UserAdd.jsp">Add a new
			student</a> <a class="list-group-item" href="AddTeachingMaterial.jsp">Add
			a new teaching material</a> <a class="list-group-item"
			href="AddCredit.jsp">Add credit to a student</a>
		<%
			}else {
		%>
	    <!-- si no es admin  -->
	         	
	      <a class="list-group-item" href="AddTeachingMaterialToOrder.jsp">Add teaching material to order</a>	      
	      <a class="list-group-item" href="#">Profile</a> <!-- student crud -->
	    
		<c:if test = "${fn:length(order.details) gt 0}">
	      <a class="list-group-item" href="Cart.jsp">Cart</a>   	
		</c:if>  
		<%
			}
		%>
		<% 
			}
		%>
		<a class="list-group-item" href="#">Se muestra siempre</a>
	</div>

</div>

