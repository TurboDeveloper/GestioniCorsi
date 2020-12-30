<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corsista Form</title>
<%@include file="CDN.html"%>
<script src="js/convalidaCorsista.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="header" style="margin-top:100px;">
			<h3>Corsista Form</h3>
		</div>
		<form action="/<%=application.getServletContextName()%>/corsistaForm"
			  class="form-horizontal" method="post" id="corsistaForm" style="margin-top:50px;">
			<div class="form-group">
				<label class="col-md-1 control-label" for="nome">
					Nome
				</label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">						
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="nome" id="nome" class="form-control" placeholder="Nome">
				</div>
			</div>
				<div class="col-md-7 control-label" id="infoNome"></div>	
			</div> 
			<div class="form-group">
				<label class="col-md-1 control-label" for="cognome">
					Cognome
				</label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">						
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Cognome">
				</div>
			</div>	
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>  
			<div class="form-group">
				<label class="col-md-1 control-label" for="select">
					Precedenti formativi
				</label>
				<div >
				<div class="input-group">
					<select name="select" class="form-control">
						<option value="1">Si</option>
						<option value="2">No</option>
					</select>
				</div>
			</div>	
			</div>  
			
			
			<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<button type="submit" class="btn btn-info">
					Inserisci&nbsp;<span class="glyphicon glyphicon-send"></span>
				</button>
				
			</div>	
			</div>
		</form>
	</div>

<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>