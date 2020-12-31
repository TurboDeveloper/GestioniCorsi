<%

	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
%>
<%@page import="it.betacom.milano.businesscomponent.model.Corso"%>
<%@page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%
	Corso c= ClientFacade.getInstance().corsoGetById(Long.parseLong(request.getParameter("id")));
%>
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
			<h3>Eliminazione del corso<%=c.getNome_corso() %></h3>
		</div>
		<div class="panel panel-header">
			<h4 style="color:black;">
				Sei sicuro di voler eliminare questo corso?
			</h4>
		</div>
		<br>
		<a href="listacorsi.jsp" class="btn btn-success">Annulla</a>
		<a href="eliminaCorso?id=<%=c.getCod_corso() %>"
			 class="btn btn-danger"
			 id="alert">Procedi all'eliminazione</a>
		
	</div>
<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>