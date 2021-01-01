
<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
		Corsista corsista= ClientFacade.getInstance().corsistaGetById(Long.parseLong(request.getParameter("id")));
			
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
<title>Profilo Corsista <%=corsista.getNome_corsista() %></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>
				Profilo di
				<%=corsista.getNome_corsista() %>
			</h3>
		</div>
		<div class="col-md-6">
			<strong>Information</strong><br>
			<div class="table-responsive">
				<table class="table table-user-information">
					<tbody>
						<tr>
							<td>
								<strong> 
									<span class="glyphicon glyphicon-home text-primary"></span> 
									Codice
								</strong>
							</td>
							<td><%=corsista.getCod_corsista() %></td>
						</tr>
						<tr>
							<td>
								<strong>
									 <span class="glyphicon glyphicon-user text-primary"></span> 
									 	Nome
								</strong>
							</td>
							<td ><%=corsista.getNome_corsista() %></td>
						</tr>
						<tr>
							<td>
								<strong> 
									<span class="glyphicon glyphicon-user text-primary"></span>
										Cognome
								</strong>
							</td>
							<td><%=corsista.getCognome_corsista() %>
							</td>
						</tr>
						<tr>
							<td>
								<strong>
									 <span class="glyphicon glyphicon-education text-primary"></span>
											 Precedenti formativi
								</strong>
							</td>
							<td>
								<%if(corsista.isPrecententi_formativi()==true){ %>
									 si
								<%}else{ %>
									 no
								<%} %>
							</td>						
						</tr>						
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