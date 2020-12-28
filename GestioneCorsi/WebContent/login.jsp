<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="CDN.html" %>
<script src="js/convalida.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
	<div class="header" style="margin-top:100px;"><!-- titolo pagina -->
		<h3>Login</h3>
		<%if((int)session.getAttribute("tentativi")<5){ %>
			<h4>Sono rimasti <%=session.getAttribute("tentativi") %></h4>
		<%} %>
	</div>
		<form action="/<%=application.getServletContextName() %>/login"
			  class="form-horizontal" method="post" id="loginForm" style="margin-top:50px;">
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
					<input type="password" name="password" id="password" 
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

</body>
</html>