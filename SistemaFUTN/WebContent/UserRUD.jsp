<%@page import="entidades.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new Student</title>
  
<jsp:include page="/includes/bootstrapLinks.jsp"></jsp:include>
</head>
<body>

	<div class="container">

		<form name="UserSearchForm" action="UserRUD" method="post">

			<h2>Student personal information</h2>

            <div class="form-group">
			   <label for="legajo">Legajo</label>
			   <input type="text" name="legajo" id="legajo"> 
			</div>
			
			<input type="submit" class="btn btn-primary" name="search" value="Search">

		</form>

		<%
			User s = (User) session.getAttribute("student");
		%>

		<p>Legajo:</p>
		<%if(s!=null && s.getLegajo()!=null) out.println(s.getLegajo());%>
		
		Name:
		<%if(s!=null && s.getFirstName()!=null) out.println(s.getFirstName());%>
		
		<%if(s!=null && s.getLastName()!=null) out.println(s.getLastName());%>
		
		
		<form name="UserRudForm" action="UserRUD" method="post">

			<label for="adress">Adress</label> <input type="text" name="adress"
				id="adress"
				value="<%if(s!=null && s.getAdress()!=null) out.println(s.getAdress());%>">
			<br> <label for="phone1">Phone1</label> <input type="text"
				name="phone1" id="phone1"
				value="<%if(s!=null && s.getPhone1()!=null) out.println(s.getPhone1());%>">
			<br> <label for="phone2">Phone2</label> <input type="text"
				name="phone2" id="phone2"
				value="<%if(s!=null && s.getPhone2()!=null) out.println(s.getPhone2());%>">
			<br> <label for="mail">Mail</label> <input type="text"
				name="mail" id="mail"
				value="<%if(s!=null && s.getMail()!=null) out.println(s.getMail());%>">
			<br> <input type="submit" class="btn btn-primary" name="update" value="Update">
			<input type="submit" class="btn btn-primary" name="delete" value="Delete">

		</form>

	</div>
	<!-- /container -->
       
</body>
</html>
