<%@page import="it.betacom.milano.businesscomponent.model.Docente"%>
<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
			
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corso"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corsista"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Lista Docenti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>
				Lista dei docenti
			</h3>
		</div>
		<div class="col-md-6">
			
			<div class="table-responsive">
			<table class="table  table-hover" style="width: 100%;">
				<thead style="background-color: #b3d1ff;">
					<tr>
						<th style="width: 200px;">Codice</th>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Cognome</th>

					</tr>
				</thead>
				<tbody>
				<% Docente d[]=ClientFacade.getInstance().docenteGetAll();
					for(int i=0; i<d.length; i++){
				
				%>
				
				<tr>
					<td><%= d[i].getCod_docente() %></td>
					<td><a href="profilodocente.jsp?id=<%=d[i].getCod_docente()%>"><%= d[i].getNome_docente() %></a>  </td>
					<td><a href="profilodocente.jsp?id=<%=d[i].getCod_docente()%>"><%=d[i].getCognome_docente() %></a> </td>
					
				</tr>
				<%} %>
				</tbody>
				</table>
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