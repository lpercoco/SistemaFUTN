<%@page import="entidades.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User </title>
</head>
<body>
        
     
    <div class="container">

      <form class="form-signin" name="signin" action="UserRUD" method="post">
        <h2 class="form-signin-heading">hola</h2>
        <label for="inputLegajo" class="sr-only">Legajo</label>
        <input name="Legajo" id="inputLegajo" class="form-control" placeholder="" required="" autofocus="" type="">

        <input type="submit" name="read" value="Search">
        
      </form>

    </div> <!-- /container -->
    
    <% Student s=(Student)session.getAttribute("student");%>
  
     Legajo: <%if(s!=null && s.getLegajo()!=null) out.println(s.getLegajo());%> <br>
     First name: <%if(s!=null && s.getFirstName()!=null) out.println(s.getFirstName());%> <br>
     Last name: <%if(s!=null && s.getLastName()!=null) out.println(s.getLastName());%> <br> 
    
     <div class="container">

      <form class="form-signin" name="signin" action="UserRUD" method="post">
        <h2 class="form-signin-heading"></h2>
                   
        <label for="adress" class="sr-only">Adress</label>
        <input type="text" name="adress" id="adress" value="<%if(s!=null && s.getAdress()!=null) out.println(s.getAdress());%>"> <br>
        
        <label for="phone1" class="sr-only">Phone1</label>
        <input type="text" name="phone1" id="phone1" value="<%if(s!=null && s.getPhone1()!=null) out.println(s.getPhone1());%>"> <br>
        
        <label for="phone2" class="sr-only">Phone2</label>
        <input type="text" name="phone2" id="phone2" value="<%if(s!=null && s.getPhone2()!=null) out.println(s.getPhone2());%>"> <br>
        
        <label for="mail" class="sr-only">Mail</label>
        <input type="text" name="Mail" id="mail" value="<%if(s!=null && s.getMail()!=null) out.println(s.getMail());%>"> <br>
        
        <input type="submit" name="Update" value="Update">
        <input type="submit" name="Delete" value="Delete">
        
       
      </form>

     </div> <!-- /container -->
    
</body>
</html>