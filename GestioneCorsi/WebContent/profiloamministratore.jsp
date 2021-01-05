<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Amministratore"%>
<%
	Long id = (Long) session.getAttribute("cod_admin");
	if (id != null) {
		Amministratore admin= ClientFacade.getInstance().amministratoreGetById(Long.parseLong( request.getParameter("id")));
			
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Profilo Admin <%=admin.getNome_admin() %></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>
				Profilo di
				<%=admin.getNome_admin() %>
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
							<td><%=admin.getCod_admin() %></td>
						</tr>
						<tr>
							<td>
								<strong>
									 <span class="glyphicon glyphicon-user text-primary"></span> 
									 	Nome
								</strong>
							</td>
							<td ><%=admin.getNome_admin() %></td>
						</tr>
						<tr>
							<td>
								<strong> 
									<span class="glyphicon glyphicon-user text-primary"></span>
										Cognome
								</strong>
							</td>
							<td><%=admin.getCognome_admin() %>
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