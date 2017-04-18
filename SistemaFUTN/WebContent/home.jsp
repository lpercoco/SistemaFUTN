<%@page import="entidades.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FUTN</title>
</head>
<body>


<%User user=(User)request.getAttribute("userAuthenticated");%>

<% out.println("impreso por java"); %>
<% out.println(user.getAdress()); %>

<p> esto es un parrafo de prueba </p>

</body>
</html>