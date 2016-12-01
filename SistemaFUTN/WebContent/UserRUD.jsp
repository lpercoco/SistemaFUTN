<%@page import="entidades.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar Datos de Usuarios Alumnos</title>
</head>
<body>
        
     
    <div class="container">

      <form class="form-signin" name="signin" action="UserRUD" method="post">
        <h2 class="form-signin-heading">Datos de Usuarios Alumnos</h2>
        <label for="inputLegajo" class="sr-only">Legajo</label>
        <input name="Legajo" id="inputLegajo" class="form-control" placeholder="" required="" autofocus="" type="">

        <input type="submit" name="read" value="Search">
        
      </form>

    </div> <!-- /container -->
    
    <% Student s=(Student)session.getAttribute("student");%>
  
     Legajo: <%if(s!=null && s.getLegajo()!=null) out.println(s.getLegajo());%> <br>
     First name: <%if(s!=null && s.getFirstName()!=null) out.println(s.getFirstName());%> <br>
     Last name: <%if(s!=null && s.getLastName()!=null) out.println(s.getLastName());%> <br> 
<%--     	<input name="legajo" type="text" value="${s.getLegajo()}"/> --%>
        <div class="container">

      <form class="form-signin" name="signin" action="UserRUD" method="post">
        <h2 class="form-signin-heading"></h2>
                   
        <label for="inputAdress" class="sr-only">Adress</label>
        <input name="adress" id="inputAdress" class="form-control" value="<%if(s!=null && s.getAdress()!=null) out.println(s.getAdress());%>" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputPhone1" class="sr-only">Phone1</label>
        <input name="phone1" id="inputPhone1" class="form-control" value="<%if(s!=null && s.getPhone1()!=null) out.println(s.getPhone1());%>" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputPhone2" class="sr-only">Phone2</label>
        <input name="phone2" id="inputPhone2" class="form-control" value="<%if(s!=null && s.getPhone2()!=null) out.println(s.getPhone2());%>" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputMail" class="sr-only">Mail</label>
        <input name="Mail" id="inputMail" class="form-control" value="<%if(s!=null && s.getMail()!=null) out.println(s.getMail());%>" placeholder="" required="" autofocus="" type=""> <br>
        
        <input type="submit" name="update" value="Update">
        <input type="submit" name="delete" value="Delete">
        
       
      </form>

    </div> <!-- /container -->
    
</body>
</html>