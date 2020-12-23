<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error</title>
<script src="js/convalida.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
	<div class="header"><!-- titolo pagina -->
		<h3>Login</h3>
	</div>
		<form action="/<%=application.getServletContextName() %>/login"
			  class="form-horizontal" method="post" id="loginForm">
			  <div class="form-group">
				<label class="col-md-1 control-label" for="cod_admin">
					Codice Admin
				</label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group " >
					<span class="input-group-addon">						
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="cod_admin" id="cod_admin" 
						   placeholder="Codice Amministratore..." 
						   class="form-control">				
				</div>
				</div>
					<div class="col-md-7 control-label" id="infoCod_admin"></div>
			</div>
			
			<div class="form-group">
				<label class="col-md-1 control-label" for="password">
					Password
				</label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group " >
					<span class="input-group-addon">						
						<i class="glyphicon glyphicon-lock"></i>
					</span>
					<input type="text" name="password" id="password" 
						   placeholder="Password..." 
						   class="form-control" required>				
				</div>
				</div>
			</div>
			<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<button type="submit" class="btn btn-info">
					login&nbsp;<span class="glyphicon glyphicon-send"></span>
				</button>
				
			</div>	
			
		</div>	
		</form>
	</div>

<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>