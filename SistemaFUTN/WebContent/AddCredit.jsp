<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add credit to a student</title>
</head>
<body>

   <div class="container">

      <form class="form-signin" name="signin" action="AddCredit" method="post">
        <h2 class="form-signin-heading">Add credit</h2>
        
        <label for="inputLegajo" class="sr-only">Legajo</label>
        <input name="Legajo" id="inputLegajo" class="form-control" value="" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputCredit" class="sr-only">Credit</label>
        <input name="Credit" id="inputCredit" class="form-control" value="" placeholder="" required="" autofocus="" type=""> <br>

        <input type="submit" name="Add" value="Add">
        
      </form>

   </div> <!-- /container -->

</body>
</html>