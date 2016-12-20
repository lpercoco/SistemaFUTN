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
	      
<!-- Poner precios actuales fuera o dentro del form?  -->	      

Begin date from actual price: <%out.println(actualCopyPrice.getBeginDate());%> <br><br>

Simple copy:<%out.println(actualCopyPrice.getSimplePrice());%> <br>
Duplex copy:<%out.println(actualCopyPrice.getDuplexPrice());%> <br>	      

    <div class="container">

      <form class="form-PriceChange" name="PriceChange" action="PriceChange" method="post">
        <h2 class="form-PriceChange-heading"></h2>
        
        <label for="inputSimple" class="sr-only">Simple</label>
        <input type="number" name="Simple" id="inputSimple" class="form-control" step="0.01" min="0" value="0" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputDuplex" class="sr-only">Duplex</label>
        <input type="number" name="Duplex" id="inputDuplex" class="form-control" step="0.01" min="0" value="0" placeholder="" required="" autofocus="" type=""> <br>
        
        <label for="inputBeginDate" class="sr-only">Begin date for the future price:</label>  
        <input type="date" name="BeginDate" placeholder="yyyy-mm-dd"> <br>
               
        <input type="submit" name="save" value="Save">
       
      </form>

    </div> <!-- /container -->

</body>
</html>