<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
<meta charset="utf-8">

<title>FUTN-New order</title>

<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/additional-methods.js"></script>


<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<STYLE TYPE="text/css" media="all">
.ui-autocomplete {
	position: absolute;
	cursor: default;
	height: 200px;
	overflow-y: scroll;
	overflow-x: hidden;
}
}
</STYLE>

<script>
	$(document).ready(function() {

		$('#form').validate({
			rules : {
				subject : {
					require_from_group : [ 1, '.group' ]
				},
				title : {
					require_from_group : [ 1, '.group' ]
				}
			},
			groups : {
				mygroup : "subject title"
			}
		});

	});
</script>

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

				<h1>Make your order</h1>

				<h2>Search a teaching material</h2>


				<form name="SearchTeachingMaterialForm" id="form"
					action="SearchTeachingMaterial" method="post">

					<div class="form-group">
						<label for="subject" class="sr-only">Subject</label> <input
							type="text" class="group" name="subject" id="subject"
							placeholder="Subject" autofocus>
					</div>

					<div class="form-group">
						<label for="title" class="sr-only">Title</label> <input
							type="text" class="group" name="title" id="title"
							placeholder="Title">
					</div>

					<input type="submit" class="btn btn-primary" value="Search">

				</form>


				<c:if test="${tmArray !=null}">

					<h2>Select what do you want to print</h2>


					<div>

						<form name="AddTMForm" action="AddTeachingMaterialToOrder"
							method="post">

							<table class="table">
								<thead>
									<tr>
										<td width="1%"></td>
										<td width="10%">Area</td>
										<td width="10%">Subject</td>
										<td width="10%">Title</td>
										<td width="10%">Description</td>
										<td width="10%">Edition</td>
										<td width="10%">Author</td>
										<td width="10%">Pages</td>
										<td width="1%">Quantity</td>
										<td width="1%">Duplex</td>
										<td width="1%">Simple</td>
									</tr>
								</thead>

								<tbody>

									<c:forEach items="${tmArray}" var="tm">
										<tr>
											<td align="center"><input type="checkbox"
												name="checkboxgroup" value="${tm.code}" /></td>
											<td align="left">${tm.materialSubject.area}</td>
											<td align="left">${tm.materialSubject.name}</td>
											<td align="left">${tm.title}</td>
											<td align="left">${tm.description}</td>
											<td align="left">${tm.edition}</td>
											<td align="left">${tm.author}</td>
											<td align="left">${tm.numberOfPages}</td>
											<td align="left"><input type="number"
												style="max-width: 5em;" name="qty${tm.code}" value="1"
												step="1" min="1"></td>
											<td align="left"><input type="radio"
												name="duplex${tm.code}" value="true" checked></td>
											<td align="left"><input type="radio"
												name="duplex${tm.code}" value="false"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<input type="submit" class="btn btn-primary" name="Add"
								value="Add to Order">
						</form>
				</c:if>

				<c:if test = "${fn:length(orderDetails) gt 0}">
					<div class="row">

						<div class="form-group col-xs-6">
							<form action="Cart.jsp" method="get">
								<input type="submit" class="btn btn-primary" value="Cart"
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


</body>
</html>