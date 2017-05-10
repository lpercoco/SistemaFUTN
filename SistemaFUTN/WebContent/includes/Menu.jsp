<%@page import="entidades.User"%>
<%
	User user = (User) request.getSession().getAttribute("userAuthenticated");
%>
<!-- se puede evitar lo de arriba?  -->


<div id="sidebar" class="col-6 col-md-3 sidebar-offcanvas">

	<div class="list-group">
		<%
			if (user != null) {
		%>
		<%
			if (user.isScholar()) {
		%>
		<a class="list-group-item" href="../PriceChange.jsp">Copy price change</a> <a
			class="list-group-item" href="../UserAdd.jsp">Add a new student</a> <a
			class="list-group-item" href="../AddTeachingMaterial.jsp">Add a new teaching material</a> <a
			class="list-group-item" href="../AddCredit.jsp">Add credit to a student</a>
		<%
			}
		%>
		<%
			}
		%>
		<a class="list-group-item" href="#">Se muestra siempre</a>
	</div>

</div>

