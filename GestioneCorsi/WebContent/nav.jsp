<%@page import="it.betacom.milano.businesscomponent.BC.ClientFacade"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menuApp">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="menuApp">
			<%
				Long user = (Long) session.getAttribute("cod_admin");
			if (user == null) {
			%>							
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"> <span
						class="glyphicon glyphicon-log-in"></span>Sing-in
				</a></li>
			</ul>
			<%
				} else {
			%>
			<ul class="nav navbar-nav">
				<li><a href="listacorsi.jsp">Lista Corsi</a></li>
				<li><a href="listaCorsisti.jsp">Lista Corsisti</a></li>
				<li><a href="statistiche.jsp">Statistiche</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="profiloamministratore.jsp?id=<%=ClientFacade.getInstance().amministratoreGetById(user).getCod_admin() %>"> <span
						class="glyphicon glyphicon-user"></span> <%=ClientFacade.getInstance().amministratoreGetById(user).getNome_admin()%> <%=ClientFacade.getInstance().amministratoreGetById(user).getCognome_admin()%></a></li>
				<li><a href="logout.jsp"> <span
						class="glyphicon glyphicon-off"></span>Logout
				</a></li>
			</ul>


			<%
				}
			%>
		</div>
	</div>
</nav>
