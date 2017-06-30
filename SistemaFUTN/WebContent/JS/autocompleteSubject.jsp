<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

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