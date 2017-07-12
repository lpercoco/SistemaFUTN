<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-static-top">

	<div class="container">

		<div class="navbar-header">
			<a class="navbar-brand" href="Home.jsp">FUTN</a>
		</div>

		<div>

			<c:if test="${userAuthenticated!=null}">

				<div class="navbar-right">
					<div class="form">

						<form name="logOutForm" class="navbar-form" action="LogOut"
							method="post">
							<button type="submit" class="btn btn-danger">Logout</button>
						</form>

					</div>
				</div>

				<div class="navbar-right">
					<div class="navbar-text">
						<p>${userAuthenticated.lastName}

							${userAuthenticated.firstName}</p>
					</div>
				</div>

			</c:if>

			<c:if test="${userAuthenticated==null}">
				<div class="navbar-right">
					<div class="form">

						<form name="logInForm" class="navbar-form" action="Login.jsp"
							method="get">
							<button type="submit" class="btn btn-success">Login</button>
						</form>
						
					</div>
				</div>
			</c:if>

		</div>
	</div>
</nav>

