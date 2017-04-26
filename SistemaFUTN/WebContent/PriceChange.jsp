<%@page import="futn.CopyPrice"%>
<%@page import="negocio.CtrlFutn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Copy price change</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<%
		CtrlFutn ctrl = new CtrlFutn();
		CopyPrice actualCopyPrice = ctrl.getActualCopyPrice();
	%>

	<!-- realizar validacion front end de que haya cambiado los precios-->

<div class="container">

	<h1>Change copy price</h1>
	
	<h3>Actual copy price</h3>
	
	<p>Begin date: <% out.println(actualCopyPrice.getBeginDate());%></p>
		
	<p>Simple copy: <% out.println(actualCopyPrice.getSimplePrice());%></p>
	
	<p>Duplex copy: <% out.println(actualCopyPrice.getDuplexPrice());%> </p>

    <h3>New copy price</h3>

		<form name="PriceChangeForm" action="PriceChange" method="post">

            <div class="form-group">
			<label for="simple">Simple</label>
			<input type="number" name="simple" id="simple" step="0.01" min="0" value="<%=actualCopyPrice.getSimplePrice()%>">
            </div>
            
            <div class="form-group">
			<label for="duplex">Duplex</label>
			<input type="number" name="duplex" id="duplex" step="0.01" min="0" value="<%=actualCopyPrice.getDuplexPrice()%>">
			</div>
				
		    <input type="submit" name="Save" value="Save" class="btn btn-lg btn-primary btn-block">

		</form>

	</div>
	<!-- /container -->

</body>
</html>