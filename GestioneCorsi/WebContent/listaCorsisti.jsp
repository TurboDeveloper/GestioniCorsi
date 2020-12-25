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
<title>Lista corsisti</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>Lista dei corsisti per ogni corso</h3>
		</div>
		<div class="row">
			<a href="corsistaForm.jsp" class="btn btn-primary">Inserisci corsista</a>
			<a href="statistiche.jsp" class="btn btn-primary">Statistiche</a>
			<a href="listacorsi.jsp" class="btn btn-primary">Elimina corsi</a>
		</div>
		<hr>
		<%
			Corso[] listaCorsi = ClientFacade.getInstance().corsoGetCorsiAttiviAttualmente();
			for (Corso c : listaCorsi) {
		%>
	<div class="panel">
		<div class="panel panel-header" style="text-align:center; background-color:#596980;">
			<h4 style="color:black;">
				<%=c.getNome_corso()%>
			</h4>
		</div>
		<div class="table-responsive " style="padding: 20px;">
			<table class="table table-striped table-hover" style="width: 100%;">
				<thead style="background-color: #b3d1ff;">
					<tr>
						<th style="width: 200px;">Codice</th>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Cognome</th>
						<th style="width: 200px;">Precedenti Formativi</th>
						
					</tr>
				</thead>
				<tbody>
				<%
					Corsista[] listaCorsisti = ClientFacade.getInstance().corsoGetCorsistiIscrittiCorso(c.getCod_corso());	
					for(Corsista corsista : listaCorsisti){
				%>
					<tr>
						<td><%=corsista.getCod_corsista()%></td>
						<td><%=corsista.getNome_corsista()%></td>
						<td><%=corsista.getCognome_corsista()%></td>
						<td><%=corsista.isPrecententi_formativi()%></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
		<%
			}			
		%>
	
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
	response.sendRedirect("accessonegato.jsp");
}
%>