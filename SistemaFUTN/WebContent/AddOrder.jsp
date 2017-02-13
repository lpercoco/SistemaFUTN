<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New order</title>

<script src="http://code.jquery.com/jquery-1.7.js"
    type="text/javascript"></script>
<script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
<link
    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
    rel="stylesheet" type="text/css" />
    
<STYLE TYPE="text/css" media="all">
.ui-autocomplete { 
    position: absolute; 
    cursor: default; 
    height: 200px; 
    overflow-y: scroll; 
    overflow-x: hidden;
    }
    
    table, th, td {
    border: 1px solid black;
}
</STYLE>
 
<script type="text/javascript">
$(document).ready(function() {
    $("input#subject").autocomplete({
//         width: 300,
//         max: 10,
//         delay: 100,
//         minLength: 1,
//         autoFocus: true,
//         cacheLength: 1,
//         scroll: true,
//         highlight: false,
        source: function(request, response) {
            $.ajax({
                url: "AjaxRequest",
                dataType: "json",
                data: request,
                success: function( data, textStatus, jqXHR) {
                    console.log( data);
                    var items = data;
                    response(items);
                },
                error: function(jqXHR, textStatus, errorThrown){
                     console.log( textStatus);
                }
            });
        }
 
    });
});
    
</script>

</head>
<body>

<h2>Make your order</h2>

   <div class="container">
   
         <form name="SearchTeachingMaterialForm" action="SearchTeachingMaterial" method="post">
         
               <label for="subject" >Subject</label>
               <input type="text" name="subject" id="subject" required> <br>
               
               
               <label for="title" >Title</label>
               <input type="text" name="title" id="title" required>      
              
               <input type="submit" value="Search" >
                
         </form>
   
   </div> <!-- /container -->
   


   <form name="AddTMForm" action="AddTeachingMaterialToOrder" method="post">
                <table>
                    <thead>
                        <tr>
                            <td width="10%">TITLE</td>
                            <td width="10%">DESCRIPTION</td>
                            <td width="10%">EDITION</td>
                            <td width="10%">EDITORIAL</td>
                            <td width="10%">AUTHOR</td>
                            <td width="10%">PAGES</td>
                            <td width="1%">SELECT</td>
                        </tr>
                    </thead>

                    <tbody>

        <c:forEach items="${tmArray}" var="tm">  
                 <tr>     
                   <td align="left">${tm.title}</td>
                   <td align="left">${tm.description}</td>
                   <td align="left">${tm.edition}</td>
                   <td align="left">${tm.editorial}</td>
                   <td align="left">${tm.author}</td>
                   <td align="left">${tm.numberOfPages}</td>
                   <td align="center">  
                   <input type="checkbox" name="checkboxgroup"  value="${tm.code}" /> </td>  
                  </tr>  
             </c:forEach>   
      </tbody>
                </table>
                <input type="submit" name="Add" value="Add to Order" >
   </form>
   
      <form name="CheckOutForm" action="AddOrder" method="post">
          <input type="submit" name="CheckOut" value="CheckOut" >
      </form>
   
   
    
</body>

<!--ABAJO DE ESTO SON PRUEBAS  -->

        0
        <c:forEach items="${tmCodes}" var="tc">
         ${tc}<br>
        </c:forEach>  
        
        <br>
        1        
        <c:forEach items="${items}" var="t">
         ${t.title}
        </c:forEach>
              
</html>