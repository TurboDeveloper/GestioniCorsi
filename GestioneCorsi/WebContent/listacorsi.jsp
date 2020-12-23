<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<jsp:include page="nav.jsp"/>
		<div class="page-header">
			<h3>Lista dei Corsi</h3>
		</div>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px;">Nome Corso</th>
						<th style="width: 200px;">Docente</th>
						<th style="width: 200px;"></th>
						<th style="width: 200px;"></th>

					</tr>
				</thead>
				<tbody>
				<tr>
				<td> </td>
				<td> </td>
				<td> <form
								action=""
								method="post">

								<button type="submit" class="btn btn-warning btn-xs">Modifica</button>
							</form> </td>
				<td><form
								action=""
								method="post">

								<button type="submit" class="btn btn-danger btn-xs">Rimuovi</button>
							</form> </td>
				<td> </td>
				 </tr>
				</tbody>
			</table>
		</div>
		<footer class="footer"><%@include file="footer.html" %></footer>
	</div>
</body>
</html>