<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Add a new teaching material</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

<jsp:include page="/JS/autocompleteSubject.jsp"></jsp:include>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<c:if test="${userAuthenticated!=null}">

			<div class="row row-offcanvas row-offcanvas-right active">

				<jsp:include page="/includes/Menu.jsp"></jsp:include>

				<c:if test="${userAuthenticated.scholar==true}">


					<div class="col-12 col-md-9">

						<form name="AddTeachingMaterialForm" action="AddTeachingMaterial"
							method="post">

							<h2>Add a new teaching material</h2>

							<div class="form-group">
								<label for="subject" class="sr-only">Subject</label> <input
									type="text" name="subject" id="subject" placeholder="Subject"
									required autofocus />
							</div>

							<div class="form-group">
								<label for="title" class="sr-only">Title</label> <input
									type="text" name="title" placeholder="Title" required />
							</div>

							<div class="form-group">
								<label for="numberOfPages" class="sr-only">Number of
									pages</label> <input type="number" name="numberOfPages" min="1"
									step="1" placeholder="Number of pages" required />
							</div>

							<div class="form-group">
								<label for="editorial" class="sr-only">Editorial</label> <input
									type="text" name="editorial" placeholder="Editorial" />
							</div>

							<div class="form-group">
								<label for="edition" class="sr-only">Edition</label> <input
									type="text" name="edition" placeholder="Edition" />
							</div>

							<div class="form-group">
								<label for="description" class="sr-only">Description</label> <input
									type="text" name="description" placeholder="Description"
									required />
							</div>

							<div class="form-group">
								<label for="author" class="sr-only">Author</label> <input
									type="text" name="author" placeholder="Author" />
							</div>

							<input type="submit" name="Add" value="Add"
								class="btn btn-primary">

						</form>

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