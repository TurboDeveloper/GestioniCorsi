<%@page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<%@page import="it.betacom.milano.businesscomponent.model.Docente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String id = (String) session.getAttribute("cod_admin");
if (id == null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/calendar.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">

		<div class="page-header">
			<h3>Aggiungi Nuovo Corso</h3>
		</div>
		<form action="/<%=application.getServletContextName()%>/salvacorso"
			class="form-horizontal" method="post" id="corsoForm">
			<%--Nome --%>
			<div class="form-group">
				<label class="col-md-1 control-label">Nome Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="nomecorso" id="nomecorso"
							placeholder="Nome..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Data Inizio</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="datainizio" id="datainizio"
							placeholder="DD-MM-YYYY..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Data Fine</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="datafine" id="datafine"
							placeholder="DD-MM-YYYY..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Costo Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="costocorso" id="costocorso"
							placeholder="Costo..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Commento</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span>
						<textarea name="commento" id="commento" class="form-control"
							style="resize: none"> </textarea>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label">Aula Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="costocorso" id="costocorso"
							placeholder="Costo..." class="form-control">
					</div>
				</div>
				</div>
			
				
			<div class="form-group">
				<label class="col-md-1 control-label">Docente</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span>  <select
						class="form-control" id="sel">
						<%
					Docente docenti[]=ClientFacade.getInstance().docenteGetAll();
					for(int i=0; i<docenti.length; i++ ){
						
					
					%>
						<option value="<%=docenti[i].getCod_docente() %>"><%=docenti[i].getNome_docente()%> <%= docenti[i].getCognome_docente() %> </option>
					<%} %>	
					</select>
					</div>
				</div>
				</div>
		</form>







	</div>

</body>
</html>
<%
	}
%>
