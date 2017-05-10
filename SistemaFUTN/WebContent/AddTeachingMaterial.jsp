<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-Add a new teaching material</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

<script src="http://code.jquery.com/jquery-1.7.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" required />

<STYLE TYPE="text/css" media="all">
.ui-autocomplete {
	position: absolute;
	cursor: default;
	height: 200px;
	overflow-y: scroll;
	overflow-x: hidden;
}
</STYLE>

<script type="text/javascript">
	$(document).ready(function() {
		$("input#subject").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "AjaxRequest",
					dataType : "json",
					data : request,
					success : function(data, textStatus, jqXHR) {
						console.log(data);
						var items = data;
						response(items);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(textStatus);
					}
				});
			}

		});
	});
</script>

</head>

<body>

	<jsp:include page="/includes/Header.jsp"></jsp:include>

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right active">

			<jsp:include page="/includes/Menu.jsp"></jsp:include>

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
						<label for="numberOfPages" class="sr-only">Number of pages</label>
						<input type="number" name="numberOfPages" min="1" step="1"
							placeholder="Number of pages" required />
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
							type="text" name="description" placeholder="Description" required />
					</div>

					<div class="form-group">
						<label for="author" class="sr-only">Author</label> <input
							type="text" name="author" placeholder="Author" />
					</div>

					<input type="submit" name="Add" value="Add" class="btn btn-primary">

				</form>

			</div>

			<jsp:include page="/includes/Footer.jsp"></jsp:include>

		</div>
	</div>
	<!-- /container -->
</body>
</html>