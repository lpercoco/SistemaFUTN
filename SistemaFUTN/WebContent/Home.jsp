<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Home</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

			<div class="col-12 col-md-9">

				<div class="jumbotron">
					<h1>FUTN</h1>
					<p>UTN FRRO copy center</p>
				</div>

				<c:if test = "${exceptionMessage !=null}">
				 
				   <div class="alert alert-warning">
                      <c:out value="${exceptionMessage}" />
                   </div>
				 
				</c:if>
				
				<c:if test = "${message !=null}">
				 
				   <div class="alert alert-success">
                      <c:out value="${message}" />
                   </div>
				 
				</c:if>

			</div>

		</div>

		<jsp:include page="/includes/Footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>