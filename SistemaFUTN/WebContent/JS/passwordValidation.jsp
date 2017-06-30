<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
		var password = document.getElementById("password"), confirmPassword = document
				.getElementById("confirmPassword");

		function validatePassword() {
			password.setCustomValidity('');

			if ($("#password").val().length < 6) {
				password
						.setCustomValidity("Password need at least 6 character long");
			} else {
				if (password.value != confirmPassword.value) {
					confirmPassword.setCustomValidity("Passwords Don't Match");
				} else {
					confirmPassword.setCustomValidity('');
				}
			}
		}

		password.onchange = validatePassword;
		confirmPassword.onkeyup = validatePassword;

	}
</script>
