<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
		Docente docente= ClientFacade.getInstance().docenteGetDocenteById(Long.parseLong( request.getParameter("id")));
			
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Docente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Profilo Docente <%=docente.getNome_docente() %></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>
				Profilo di
				<%=docente.getNome_docente() %>
			</h3>
		</div>
		<div class="col-md-6">
			
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
							<td><%=docente.getCod_docente() %></td>
						</tr>
						<tr>
							<td>
								<strong>
									 <span class="glyphicon glyphicon-user text-primary"></span> 
									 	Nome
								</strong>
							</td>
							<td ><%=docente.getNome_docente() %></td>
						</tr>
						<tr>
							<td>
								<strong> 
									<span class="glyphicon glyphicon-user text-primary"></span>
										Cognome
								</strong>
							</td>
							<td><%=docente.getCognome_docente() %>
							</td>
						</tr>
						<tr>
							<td>
								<strong>
									 <span class="glyphicon glyphicon-education text-primary"></span>
											Curriculum
								</strong>
							</td>
							<td>
								<a href="/doc/<%=docente.getCv_docente()%>"><%=docente.getCv_docente()%> </a>
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