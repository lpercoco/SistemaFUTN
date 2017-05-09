<%@page import="entidades.User"%>
<% User user=(User)request.getSession().getAttribute("userAuthenticated");%>
<!-- se puede evitar lo de arriba?  -->


<div class="span3 bs-docs-sidebar">
    <ul class="nav nav-list bs-docs-sidenav affix">
      <li class="active"><a href="#dropdowns"><i class="icon-chevron-right"></i> Dashboard</a></li>
      <li class=""><a href=""><i class="icon-chevron-right"></i></a></li> <!-- mejorar esto  -->
      <%if(user.isScholar()){%> 
         <li class=""><a href="../PriceChange.jsp"><i class="icon-chevron-right"></i>Price change</a></li>
         <li class=""><a href="../UserAdd.jsp"><i class="icon-chevron-right"></i>Add new user </a></li>
         <li class=""><a href="../AddTeachingMaterial.jsp"><i class="icon-chevron-right"></i>Add new teaching material </a></li>
         <li class=""><a href="/SistemaFUTN/AddCredit.jsp"><i class="icon-chevron-right"></i>Add credit </a></li>
      <% }%>
      <!--  else? -->
      <li class=""><a href=""><i class="icon-chevron-right"></i>Prueba </a></li>
      
    </ul>
  </div>
  
 ////