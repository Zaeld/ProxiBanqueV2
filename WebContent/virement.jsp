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
				<li><a
					href="ServletRetourAcceuil?idConseiller=${conseiller.getIdConseiller()}">Retour</a></li>
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
				<div class="jumbotron">
					<h2 class="text-center">Virement Compte � Compte</h2>
				</div>
				<form method=post action="ServletVirement">
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputCompteDebiteur">Choisissez le compte �
								d�biter</label> <select id="inputCompteDebit" class="form-control"
								name="compteDebit" required>
								<c:if test="${courant !=null }">
									<option>${courant.getTypeDeCompte()}
										${courant.getNumCompte()}</option>
								</c:if>
								<c:if test="${epargne !=null }">
									<option>${epargne.getTypeDeCompte()}
										${epargne.getNumCompte()}</option>
								</c:if>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="inputCompteDebiteur">Choisissez le compte �
								cr�diter</label> <select id="inputCompteCredit" class="form-control"
								name="compteCredit" required>
								<c:forEach items="${listeCompte}" var="compte">
									<option>${compte.getTypeDeCompte()}
										${compte.getNumCompte()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="inputSommeVirement">Entrer la somme du
								virement</label> <input type="number" class="form-control"
								id="inputSommeVirement" placeholder="Somme du virement"
								name="sommeVirement" required>
						</div>
					</div>
					<div class="form-row text-center">
						<input type="submit" value="Enregistrer"
							class="btn btn-success btn-lg">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>