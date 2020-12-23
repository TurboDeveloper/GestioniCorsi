
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@page import="it.betacom.milano.architetture.dao.DAOException"%>
<%@page import="java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Error</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h2>Errore interno dell'applicazione</h2>
	</div>	
	<%
		if (exception instanceof ClassNotFoundException) {
	%>
	<div class="panel panel-danger">
		<div class="panel-heading"> 
			<p>Intercettata una ClassNotFound</p>
		</div>
		<div class="panel-body">
			<%=exception.getMessage()%>
		
			<p>Siamo spiacenti</p>
			<p>Per segnalare il problema contattare l'amministratore: <a href="mailto:admin@site.com">admin@site.com</a></p>
			<p>Per tornare alla pagina precedente:
			<input type="button" class="btn btn-default" value="indietro" onclick="window.history.back()">
			</p>
		</div>
	</div>
	<%
		} else if (exception instanceof DAOException) {
	%>
	<div class="panel panel-danger">
		<div class="panel-heading"> 
			<p>Intercettata una DAOException</p>
		</div>
		<div class="panel-body">
			<%=((DAOException)exception).getMessage()%>
		
			<p>Siamo spiacenti</p>
			<p>Per segnalare il problema contattare l'amministratore: <a href="mailto:admin@site.com">admin@site.com</a></p>
			<p>Per tornare alla pagina precedente:
			<input type="button" class="btn btn-default" value="indietro" onclick="window.history.back()">
			</p>
		</div>
	</div>
	<%
		} else if (exception instanceof IOException) {
	%>
	<div class="panel panel-danger">
		<div class="panel-heading"> 
			<p>Intercettata una IOException</p>
			<p>Problema con la connessione al DB</p>
		</div>
		<div class="panel-body">
			<%=exception.getMessage()%>
		
			<p>Siamo spiacenti</p>
			<p>Per segnalare il problema contattare l'amministratore: <a href="mailto:admin@site.com">admin@site.com</a></p>
			<p>Per tornare alla pagina precedente:
			<input type="button" class="btn btn-default" value="indietro" onclick="window.history.back()">
			</p>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="panel panel-danger">
		<div class="panel-heading"> 
			<p>Eccezione non prevista</p>
		</div>
		<div class="panel-body">
			<%=exception.getMessage()%>
			<% exception.printStackTrace(new PrintWriter(out)); %>
			<p>Siamo spiacenti</p>
			<p>Per segnalare il problema contattare l'amministratore: <a href="mailto:admin@site.com">admin@site.com</a></p>
			<p>Per tornare alla pagina precedente:
			<input type="button" class="btn btn-default" value="indietro" onclick="window.history.back()">
			</p>
		</div>
	</div>
	<%
		}
	%>
</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>