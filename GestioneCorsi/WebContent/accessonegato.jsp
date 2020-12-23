<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<%@ include file="CDN.html" %>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<title>Accesso Negato</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Non puoi accedere a questa pagina</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<p>Risorsa non disponibile</p>
			</div>
			<div class="panel-body">
				<p>Per accedere alla pagina richiesta:</p>
				<p>Effettura il login se gi&agrave; registrati- <a href="login.jsp">Login utente</a></p>
				<p>Oppure effettuare la registrazione-<a href="registra.jsp">Registrazione utente</a></p>

			</div>
		</div>
	</div>
	<footer class="footer"><%@include file="footer.html" %></footer>
</body>

</html>