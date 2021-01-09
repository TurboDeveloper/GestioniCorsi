<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corso"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corsista"%>
<%@page import="java.text.SimpleDateFormat"%>
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
			<h2>Statistiche</h2>
		</div>
		
		<div class="container">
			<div class="col-sm-6">
				<h3>Numero di corsisti totali</h3>
				<p>Sono presenti <%=ClientFacade.getInstance().corsistaCountCorsisti() %> corsisti</p>
			</div>
			<div class="col-sm-6">
				<h3>Nome del corso più frequentato</h3>
				<%
					Long[] co=ClientFacade.getInstance().getMaxCorsisti(); 
					for(Long cod:co){
				%>
				<%=
					 ClientFacade.getInstance().corsoGetById(cod).getNome_corso()
				%>
				<%} %>
			</div>
			<div class="col-sm-6">
				<h3>Data di inizio ultimo corso</h3>
				<%Corso corso=ClientFacade.getInstance().corsoGetDataUltimoCorso(); %>
				<p>L'ultimo corso inserito è : <%=corso.getNome_corso() %>
				il cui inizio è fissato per : 
				<%=formato.format(corso.getData_iniziocorso()) %></p>
			</div>
			<div class="col-sm-6">
				<h3> Durata media dei corsi ( in giorni lavorativi )</h3>
			</div>
			<div class="col-sm-6">
				<h3>Numero di commenti presenti</h3>
			</div>
			<div class="col-sm-6">
				<h3>Elenco corsisti</h3>
				<%
					Corsista [] corsisti= ClientFacade.getInstance().corsistaGetAll();
					for(Corsista c : corsisti ){
				%>
				<p>
					<a href="profilo.jsp?id=<%=c.getCod_corsista() %>">
						<%=c.getNome_corsista() %> &nbsp; <%=c.getCognome_corsista() %></a>
				</p>
				<%} %>
			</div>
			<div class="col-sm-6">
				<h3>Docente che può tenere più tipologie di corso</h3>
			</div>
			<div class="col-sm-6">
				<h3>Corsi con posti disponibili</h3>
			</div>
		</div>
		
		
	</div>
</body>
</html>
<%
} else {
	response.sendRedirect("accessonegato.jsp");
}
%>