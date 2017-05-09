<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FUTN</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
<div class="container">

	<form name="AddCreditForm" action="AddCredit" method="post">

		<h2 class="form-heading">Add credit to a student</h2>

		<div class="form-group">
			<label for="legajo" class="sr-only">Legajo</label> <input
				type="text" name="legajo" id="legajo" placeholder="legajo" required autofocus>
		</div>

		<!-- buscar legajo y mostrar saldo actual tambien en esta pagina? -->

		<div class="form-group">
			<label for="credit" class="sr-only">Credit</label> <input
				type="number" name="credit" id="credit" step="1" min="0"
				placeholder="credit to add" required>
			<!-- minimo para agregar credito 10$? paso de 1$?  -->
		</div>

		<input class="btn btn-primary" type="submit"
			name="Add" value="Add">

	</form>

</div>
<!-- /container -->
