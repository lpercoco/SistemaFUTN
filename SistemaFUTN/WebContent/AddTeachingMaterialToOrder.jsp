<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New order</title>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/additional-methods.js"></script>


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

<script>

$(document).ready(function() {
    
    $('#form').validate({
        rules: {
            subject: {
                require_from_group: [1, '.group']
            },
            title: {
                require_from_group: [1, '.group']
            }
        },
        groups: {
            mygroup: "subject title"
        }
    });
    
});

</script>
 
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
   
         <form name="SearchTeachingMaterialForm" id="form" action="SearchTeachingMaterial" method="post">
         
               <label for="subject" >Subject</label>
               <input type="text" class="group" name="subject" id="subject"> <br>
               
               
               <label for="title" >Title</label>
               <input type="text" class="group" name="title" id="title">      
              
               <input type="submit" value="Search" >
                
         </form>
   
   </div> <!-- /container -->
   


   <form name="AddTMForm" action="AddTeachingMaterialToOrder" method="post">
                <table>
                    <thead>
                        <tr>
                            <td width="1%">SELECT</td>
                            <td width="10%">AREA</td>
                            <td width="10%">SUBJECT</td>                            
                            <td width="10%">TITLE</td>
                            <td width="10%">DESCRIPTION</td>
                            <td width="10%">EDITION</td>
                            <td width="10%">AUTHOR</td>
                            <td width="10%">PAGES</td>
                            <td width="5%">QUANTITY</td>
                            <td width="1%">DUPLEX</td>
                            <td width="1%">SIMPLE</td>
                        </tr>
                    </thead>

                    <tbody>

        <c:forEach items="${tmArray}" var="tm">  
                 <tr>     
                   <td align="center"><input type="checkbox" name="checkboxgroup"  value="${tm.code}" /> </td>
                   <td align="left">${tm.materialSubject.area}</td>
                   <td align="left">${tm.materialSubject.name}</td>
                   <td align="left">${tm.title}</td>
                   <td align="left">${tm.description}</td>
                   <td align="left">${tm.edition}</td>
                   <td align="left">${tm.author}</td>
                   <td align="left">${tm.numberOfPages}</td>
                   <td align="left"><input type="number" name="qty${tm.code}" value="1" step="1" min="1"></td>
                   <td align="left"><input type="radio" name="duplex${tm.code}" value="true" checked></td>
                   <td align="left"><input type="radio" name="duplex${tm.code}" value="false"></td>
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
</html>