<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new teaching material</title>

    <link rel="icon" href="../../favicon.ico">
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="http://code.jquery.com/jquery-1.7.js"
    type="text/javascript"></script>
<script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
<link
    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
    rel="stylesheet" type="text/css" required />
    
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

   <h2>Add a new teaching material</h2>
   
   <div class="form-group">
   <label for="subject" class="sr-only" >Subject</label> 
   <input type="text" name="subject" id="subject" placeholder="Subject" required autofocus />
   </div>
   
   <div class="form-group">
   <label for="title" class="sr-only" >Title</label> 
   <input type="text" name="title" placeholder="Title" required />
   </div>
   
   <div class="form-group">
   <label for="numberOfPages" class="sr-only" >Number of pages</label> 
   <input type="number" name="numberOfPages" min="1" step="1" placeholder="Number of pages" required />
   </div>
   
   <div class="form-group">   
   <label for="editorial" class="sr-only" >Editorial</label> 
   <input type="text" name="editorial" placeholder="Editorial"  />
   </div>
   
   <div class="form-group">   
   <label for="edition" class="sr-only" >Edition</label> 
   <input type="text" name="edition" placeholder="Edition"  />
   </div>
  
   <div class="form-group">   
   <label for="description" class="sr-only" >Description</label> 
   <input type="text" name="description" placeholder="Description" required />
   </div>
   
   <div class="form-group">
   <label for="author" class="sr-only">Author</label> 
   <input type="text" name="author" placeholder="Author" />
   </div>
   
   <input type="submit" name="Add" value="Add" class="btn btn-primary">
   
 </form>

</div> <!-- /container -->
 

</body>
</html>