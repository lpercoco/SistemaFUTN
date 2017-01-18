<%@page import="entidades.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Student personal information</title>

</head>
<body>
        
     
    <div class="container">


      <form name="UserSearchForm" action="UserRUD" method="post">
      
        <h2>Student personal information</h2>
        
        <label for="legajo" >Legajo</label>
        <input type="text" name="legajo" id="legajo" required >
        
        <input type="submit" name="search" value="Search">
        
      </form>

    </div> <!-- /container -->
    
    <% Student s=(Student)session.getAttribute("student");%>
  
     Legajo: <%if(s!=null && s.getLegajo()!=null) out.println(s.getLegajo());%> <br>
     First name: <%if(s!=null && s.getFirstName()!=null) out.println(s.getFirstName());%> <br>
     Last name: <%if(s!=null && s.getLastName()!=null) out.println(s.getLastName());%> <br> 

     <div class="container">


      <form name="UserRudForm" action="UserRUD" method="post">
                   
        <label for="adress" >Adress</label>
        <input type="text" name="adress" id="adress" value="<%if(s!=null && s.getAdress()!=null) out.println(s.getAdress());%>"> <br>
        
        <label for="phone1" >Phone1</label>
        <input type="text" name="phone1" id="phone1" value="<%if(s!=null && s.getPhone1()!=null) out.println(s.getPhone1());%>"> <br>
        
        <label for="phone2" >Phone2</label>
        <input type="text" name="phone2" id="phone2" value="<%if(s!=null && s.getPhone2()!=null) out.println(s.getPhone2());%>"> <br>
        
        <label for="mail" >Mail</label>
        <input type="email" name="mail" id="mail" value="<%if(s!=null && s.getMail()!=null) out.println(s.getMail());%>"> <br>
        
        <input type="submit" name="update" value="Update">
        <input type="submit" name="delete" value="Delete">
        
       
      </form>

     </div> <!-- /container -->
    
</body>
</html>
