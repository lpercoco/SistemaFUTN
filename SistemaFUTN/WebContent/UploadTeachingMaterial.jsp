<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update a new teaching material</title>

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

 <form name="as400samplecode" action="" method="get">

   <label for="subject" class="sr-only">Subject</label> 
   <input type="text" id="subject" required /> </br>
   
   <label for="title" class="sr-only">Title</label> 
   <input type="text" id="title" required /> </br>
   
   <label for="numberOfPages" class="sr-only">Number of pages</label> 
   <input type="number" id="numberOfPages" step="1" min="1" value="1" required /> </br>
      
   <label for="editorial" class="sr-only">Editorial</label> 
   <input type="text" id="editorial" /> </br>
      
   <label for="edition" class="sr-only">Edition</label> 
   <input type="text" id="edition" maxlength="20" /> </br>
      
   <label for="description" class="sr-only">Description</label> 
   <input type="text" id="description" required/> </br>
   
   <!-- falta carrera? -->
   
   
   <input type="submit" name="Add" value="Add">
   
 </form>

</body>
</html>