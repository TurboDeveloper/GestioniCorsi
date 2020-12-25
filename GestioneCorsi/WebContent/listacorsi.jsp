<%
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corso"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.betacom.milano.businesscomponent.BC.ClientFacade" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Lista corsi</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
		
		<div class="page-header">
			<h3>Lista dei Corsi</h3>
		</div>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px;">Nome Corso</th>
						<th style="width: 200px;">Docente</th>
						<th style="width: 200px;">Aula</th>
						<th style="width: 200px;">Data Inizio</th>
						<th style="width: 200px;">Data Fine</th>
						<th style="width: 200px;">Modifica</th>
						<th style="width: 200px;">Elimina</th>
						<th style="width: 200px">Iscrivi Corsista </th> 

					</tr>
				</thead>
				<tbody>
				<%
					Corso corsi[]=ClientFacade.getInstance().corsoGetCorsiAttivi();
					for(int i=0; i<corsi.length; i++ ){
				%>
					<tr>
						<td><%=corsi[i].getNome_corso()%></td>
						<td><%=ClientFacade.getInstance().docenteGetDocenteById(corsi[i].getCod_docente()).getCognome_docente() %></td>
						<td><%=corsi[i].getAula_corso() %></td>
						<td><%=formato.format(corsi[i].getData_iniziocorso())%></td>
						<td><%=formato.format(corsi[i].getData_finecorso())%></td>
						<td>
							<form action="/<%=application.getServletContextName()%>/modifica?id=<%=corsi[i].getCod_corso()%>" method="post">

								<button type="submit" class="btn btn-warning btn-xs">Modifica</button>
							</form>
						</td>
						<td><form action="/<%=application.getServletContextName()%>/eliminacorso?id=<%=corsi[i].getCod_corso()%>" method="post">

								<button type="submit" class="btn btn-danger btn-xs">Rimuovi</button>
							</form></td>
							<td><form action="/<%=application.getServletContextName()%>/iscriviCorsista?id=<%=corsi[i].getCod_corso()%>" method="post">

								<button type="submit" class="btn btn-primary btn-xs">Iscrivi Corsista</button>
							</form></td>
	
					</tr>
	<%
		}
	%>
				</tbody>
			</table>
			<div>
				<a href="corsoform.jsp" class="btn btn-primary">Aggiungi Corso</a>
			</div>
			
		</div>
		
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>