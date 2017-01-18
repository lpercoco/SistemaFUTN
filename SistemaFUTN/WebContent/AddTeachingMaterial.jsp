<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new teaching material</title>

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
    overflow-x: hidden;}
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

<div class="container">

 <form name="AddTeachingMaterialForm" action="AddTeachingMaterial" method="post">

   <label for="subject" >Subject</label> 
   <input type="text" name="subject" id="subject" required/><br>
   
   <label for="title" >Title</label> 
   <input type="text" name="title" required /><br>
   
   <label for="numberOfPages" >Number of pages</label> 
   <input type="number" name="numberOfPages" min="1" step="1" value="1" required/><br>
      
   <label for="editorial" >Editorial</label> 
   <input type="text" name="editorial" /><br>
      
   <label for="edition" >Edition</label> 
   <input type="text" name="edition" /><br>
      
   <label for="description" >Description</label> 
   <input type="text" name="description" required/><br>
   
   <label for="author" >Author</label> 
   <input ype="text" name="author" required/><br>
   
   <!-- falta carrera?  -->
   
   
   
   
   
   <input type="submit" name="Add" value="Add">
   
 </form>

</div> <!-- /container -->
 

</body>
</html>