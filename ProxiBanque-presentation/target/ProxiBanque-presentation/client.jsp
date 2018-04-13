<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
				<li><a
					href="ServletRetourAcceuil">Acceuil</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="btn btn-danger btn-lg" href="index.html"
					role="button">Quitter</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-1 sidenav"></div>
			<div class="col-sm-10 text-left">
				<h2>Liste des comptes de ${client.getNom()}
					${client.getPrenom()} : </h2>
					<h3>Solde total des comptes : <c:out value="${client.getSoldeTotal()}" /></h3>
				<div class="col-sm-6 text-left">
					<h3>Compte courant</h3>
					<c:choose>
						<c:when test="${courant != null}">
							<div class="row">
								<p>
									Numéro de comtpe :
									<c:out value="${courant.getNumCompte()}" />
								</p>
								<p>
									Solde :
									<c:out value="${courant.getSolde()}" />
								</p>
								<p>
									Type de carte :
									<c:out value="${courant.getTypeCarte()}" />
								</p>
								<p>
									Decouvert Autorise :
									<c:out value="${courant.getDecouvertAutorise()}" />
								</p>
							</div>
						</c:when>
						<c:otherwise>
							<p>Ce client n'a pas de compte courant</p>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-sm-6 text-left">
					<h3>Compte Epargne</h3>
					<c:choose>
						<c:when test="${epargne != null}">
							<div class="row">
								<p>
									Numéro de comtpe :
									<c:out value="${epargne.getNumCompte()}" />
								</p>
								<p>
									Solde :
									<c:out value="${epargne.getSolde()}" />
								</p>
																<p>
									Taux d'intéret :
									<c:out value="${epargne.getTauxInteret()}" />
								</p>
							</div>
						</c:when>
						<c:otherwise>
							<p>Ce client n'a pas de compte epargne</p>
						</c:otherwise>
					</c:choose>

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
