<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${userAuthenticated==null}">
	<div class="alert alert-danger">
		<p class="text-center">You are not loged, please loggin!</p>
	</div>
</c:if>

<c:if
	test="${userAuthenticated!=null && userAuthenticated.scholar==true}">
	<div class="alert alert-danger">
		<p class="text-center">As scholar,you don't have permission for
			this site!</p>
	</div>
</c:if>

<c:if
	test="${userAuthenticated!=null && userAuthenticated.scholar==false}">
	<div class="alert alert-danger">
		<p class="text-center">As student,you don't have permission for this site!</p>
	</div>
</c:if>