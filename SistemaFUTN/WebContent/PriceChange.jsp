<%@page import="futn.CopyPrice"%>
<%@page import="negocio.CtrlFutn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Price changes</title>
</head>
<body>

        <%CtrlFutn ctrl=new CtrlFutn();
          CopyPrice actualCopyPrice=new CopyPrice();
	      actualCopyPrice=ctrl.getActualCopyPrice();%>
	      
<!-- quitar parte fechas, revisar si es necesario  el codigo en java  -->	      

Begin date from actual price: <%out.println(actualCopyPrice.getBeginDate());%> <br><br>

Simple copy:<%out.println(actualCopyPrice.getSimplePrice());%> <br>
Duplex copy:<%out.println(actualCopyPrice.getDuplexPrice());%> <br>	      

    <div class="container">

      <form name="PriceChangeForm" action="PriceChange" method="post">
        
        <label for="simple" >Simple</label>
        <input type="number" name="simple" id="simple" step="0.01" min="0" value="0"> <br>
        
        <label for="duplex" >Duplex</label>
        <input type="number" name="Duplex" id="duplex" class="form-control" step="0.01" min="0" value="0"> <br>
        
        <label for="date" >Begin date for the future price:</label>  
        <input type="date" name="date" placeholder="yyyy-mm-dd"> <br>
               
        <input type="submit" name="Save" value="Save">
       
      </form>

    </div> <!-- /container -->

</body>
</html>