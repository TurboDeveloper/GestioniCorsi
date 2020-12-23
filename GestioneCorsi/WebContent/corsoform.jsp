<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String id = (String) session.getAttribute("cod_admin");
if (id != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
		
		<div class="page-header">
			<h3>Lista dei Corsi</h3>
		</div>
		<form action="/<%=application.getServletContextName()%>/salvacorso" class="form-horizontal" method="post"
			id="corsoForm">
			<%--Nome --%>
			<div class="form-group">
				<label class="col-md-1 control-label">Nome Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>

						<input type="text" name="nome" id="nomecorso" placeholder="Nome..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
		<div class="form-group">
				<label class="col-md-1 control-label">Nome Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>

						<input type="text" name="nome" id="nomecorso" placeholder="Nome..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
		
		
		</form>
		
		
		
		
		
		
		
		</div>

</body>
</html>
<%
}%>