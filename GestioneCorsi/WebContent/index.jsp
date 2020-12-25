<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id == null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error</title>
</head>
<body>

<% 
	session.setAttribute("tentativi",5);
	response.sendRedirect("login.jsp");
%>

</body>
</html>
<%
} else {
	response.sendRedirect("listaCorsisti.jsp");
}
%>