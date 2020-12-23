<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<%@ include file="CDN.html" %>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<title>Error 404</title>
</head>

<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Pagina non trovata</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<p>Impossibile ottenere la risorsa richiesta</p>
			</div>
			<div class="panel-body">
				<p>Siamo spiacenti</p>
				<p>Per segnalare il problema contattare l'amministratore-<a
						href="mailto:admin@site.com">admin@site.com</a></p>
				<p>Torna alla pagina precedente
					<input type="button" class="btn btn-default" value="indietro" onclick="window.history.back()">
				</p>
			</div>
		</div>
	</div>
	<footer class="footer"><%@include file="footer.html" %></footer>
</body>

</html>