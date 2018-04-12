<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
<title>ProxiBanqueSI</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
</head>

<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-left"><img src="img/ProxiBanqueSI-Logo.png"
				class="img-fluid" alt=PBSI-logo></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Acceuil</a></li>
				<li><a href="creerClient.jsp">Cr�er un client</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="btn btn-danger btn-lg" href="index.html"
					role="button" target="quitter">Quitter</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-1 sidenav"></div>
			<div class="col-sm-10 text-left">
				<h4 class="text-center">
					Bienvenue dans votre espace ProxiBanqueSI
					<c:out value="${user.nom}" />
					<c:out value="${user.prenom}" />
				</h4>
				<hr>
				<h2>Liste des clients g�r�s :</h2>
				<br>
				<table class="table table-condensed table-striped text-center">
					<thead>
						<tr>
							<td><h4>Nom</h4></td>
							<td><h4>Pr�nom</h4></td>

							<td><h4>T�l�phone</h4></td>

							<td></td>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listeClient}" var="client">
							<tr>
								<td><c:out value="${client.nom}" /></td>
								<td><c:out value="${client.prenom}" /></td>
								<td><c:out value="${client.telephone}" /></td>
								<td><a class="btn btn-success"
									href="ServletAcceuilRedirection?idClient=${client.getIdClient()}&direction=gerer"
									role="button">G�rer le client</a> <a class="btn btn-warning"
									href="ServletAcceuilRedirection?idClient=${client.getIdClient()}&direction=modifier"
									role="button">Modifier</a> <a class="btn btn-danger"
									href="ServletAcceuilRedirection?idClient=${client.getIdClient()}&direction=supprimer"
									role="button">Supprimer</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col-sm-1 sidenav"></div>
		</div>
	</div>

	<footer class="container-fluid">
	<div class="text-center">ProxiBanqueSI the best for bank
		administration</div>
	<div class="text-right">B. Blondel & A. Demolis All right
		reserved</div>
	</footer>

</body>

</html>
