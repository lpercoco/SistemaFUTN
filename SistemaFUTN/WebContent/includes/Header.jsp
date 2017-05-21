<%@page import="entidades.User"%>

<% User user=(User)request.getSession().getAttribute("userAuthenticated");%>

 <nav class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home.jsp">FUTN</a> <!-- va al home -->
		</div>
		<div>
			<div class="navbar-right">
				<div class="form">
					<form class="navbar-form" action="Logout" method="get">
						<!-- falta implementar logout -->
						<button type="submit" class="btn btn-success">Sign out</button>
					</form>
				</div>
			</div>
			<div class="navbar-right">
				<div class="navbar-text">
					<p><%if(user!=null){out.println(user.getFirstName()+" "+user.getLastName());}%></p>
				</div>
			</div>
		</div>
	</div>
</nav> 

