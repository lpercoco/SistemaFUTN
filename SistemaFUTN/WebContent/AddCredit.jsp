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

      <form name="AddCreditForm" action="AddCredit" method="post">
        <h2>Add credit</h2>
        
        <label for="legajo" >Legajo</label>
        <input type="text" name="legajo" id="legajo"> <br>
        
        <label for="credit" ">Credit</label>
        <input type="number" name="credit" id="credit" step="1" min="10" value="10" > <br> <!-- minimo para agregar credito 10$? paso de 1$?  -->

        <input type="submit" name="Add" value="Add">
               
      </form>
      
   </div> <!-- /container -->

</body>
</html>