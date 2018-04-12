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
				<li><a href="acceuilV2.jsp">Acceuil</a></li>
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
				<form class="text-center" target="ligneDeCommande">
					<input type="submit" value="Gestion du patrimoine"
						class="btn btn-primary"> <input type="submit"
						value="Simulation de crédit immobilier" class="btn btn-primary">
					<input type="submit" value="Simulation de crédit consommation"
						class="btn btn-primary">
				</form>
				<h2>Informations sur le client :</h2>
				<div class="col-sm-1"></div>
				<div class="col-sm-10 text-left">
					<div class="row">
						<div class="col-sm-6">
							<p>
								Nom :
								<c:out value="${client.getNom()}" />
							</p>
							<p>
								Prénom :
								<c:out value="${client.getPrenom()}" />
							</p>
							<p>
								Situation Professionnelle :
								<c:out value="${client.getSituationProfessionnel()}" />
							</p>
							<p>
								Numéro de téléphone :
								<c:out value="${client.getTelephone()}" />
							</p>
						</div>
						<div class="col-sm-6">
							<p>Adresse :</p>
							<p class="retrait">
								<c:out value="${client.getAdresse()}" />
							</p>
							<p class="retrait">
								<c:out value="${client.getCodePostal()}" />
							</p>
							<p class="retrait">
								<c:out value="${client.getVille()}" />
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-1"></div>
				<hr>
				<div class="col-sm-6 text-left">
					<h3>Compte courant</h3>
					<div class="row">
						<div class="col-sm-6">
							<p>
								Numéro de comtpe :
								<c:out value="${courant.getNumCompte}" />
							</p>
							<p>
								Solde :
								<c:out value="${courant.getSolde}" />
							</p>
						</div>
						<div class="col-sm-6 text-center">
							<form method="POST" action="ServletCredit">
								<input type="submit" value="Effectuer un Crédit"
									class="btn btn-success" target="actions">
							</form>
							<form method="POST" action="ServletDebit">
								<input type="submit" value="Effectuer un Débit"
									class="btn btn-danger" target="actions">
							</form>
							<form method="POST" action="ServletVirement">
								<input type="submit" value="Effectuer un Virement"
									class="btn btn-secondary" target="actions">
							</form>
						</div>
					</div>
				</div>
				<div class="col-sm-6 text-left">
					<h3>Compte Epargne</h3>
					<div class="row">
						<div class="col-sm-6">
							<p>
								Numéro de comtpe :
								<c:out value="${epargne.getNumCompte}" />
							</p>
							<p>
								Solde :
								<c:out value="${epargne.getSolde}" />
							</p>
						</div>
						<div class="col-sm-6 text-center">
							<form method="POST" action="ServletCredit">
								<input type="submit" value="Effectuer un Crédit"
									class="btn btn-success" target="actions">
							</form>
							<form method="POST" action="ServletDebit">
								<input type="submit" value="Effectuer un Débit"
									class="btn btn-danger" target="actions">
							</form>
							<form method="POST" action="ServletVirement">
								<input type="submit" value="Effectuer un Virement"
									class="btn btn-secondary" target="actions">
							</form>
							<form method="POST" action="ServletRemuneration">
								<input type="submit" value="Afficher la rémunération de cette année"
									class="btn btn-info" target="actions">
							</form>
						</div>
					</div>
				</div>
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
