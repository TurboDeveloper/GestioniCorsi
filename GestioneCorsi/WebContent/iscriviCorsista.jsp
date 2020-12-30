<%@page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Corsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Iscrivi Corsista</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/calendar.js"></script>
<script src="js/convalidaCorso.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>Iscrivi corsista ad un corso</h3>
		</div>
		<%if(session.getAttribute("messaggio")!=null){ %>
		<div>
			<h4><%=session.getAttribute("messaggio") %></h4>
		</div>
		<%} %>
		<form action="/<%=application.getServletContextName()%>/iscriviForm"
			class="form-horizontal" method="post" id="corsoForm">
				<div class="form-group">
				<input type="hidden" id="corsoId" name="corsoId" value="<%=request.getParameter("id")%>">
				<label class="col-md-1 control-label">Corsista</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span>  <select name="select"
						class="form-control" id="sel">
						<%
					Corsista studenti[]= ClientFacade.getInstance().corsistaGetAll();
					for(int i=0; i<studenti.length; i++ ){
						
					
					%>
						<option value="<%=studenti[i].getCod_corsista() %>"><%=studenti[i].getNome_corsista()%> <%= studenti[i].getCognome_corsista() %> </option>
					<%} %>	
					</select>
					</div>
				</div>
				</div>
				<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-primary btn-lg">
						Iscrivi&nbsp;<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
			</form>
	</div>
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>
<%
	}
	else {
		response.sendRedirect("accessonegato.jsp");}
%>
