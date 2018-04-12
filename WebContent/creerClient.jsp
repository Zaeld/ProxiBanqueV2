<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<li class="active"><a href="#">Créer un client</a></li>
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
					<h2 class="text-center">Création du client</h2>
				</div>
				<form method=post " action="ServletCreerClient?idConseiller=${conseiller.getIdConseiller}">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputName">Nom</label> <input type="text"
								class="form-control" id="inputNom" placeholder="Nom" name="nom">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPrenom">Prénom</label> <input type="text"
								class="form-control" id="inputPrenom" placeholder="Prénom"
								name="prenom">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<div class="form-check">
								<label for="situationProfessionnel">Situation
									Professionnelle : </label>
								<div class="form-inline text-center">
									<input class="form-check-input" name="situationProfessionelle"
										type="radio" id="radio" checked="checked"> <label
										class="form-check-label" for="particulier" target="check">Particulier</label>
									<input class="form-check-input" name="situationProfessionelle"
										type="radio" id="radio"> <label
										class="form-check-label" for="entreprise">Entreprise</label>
								</div>
							</div>
						</div>
						<div class="form-group col-md-4">
							<label for="inputMail">Email</label> <input
								type="email" class="form-control" id="inputMail"
								placeholder="Email" name="email">
						</div>
						<div class="form-group col-md-4">
							<label for="inputPhone">Numéro de téléphone</label> <input
								type="number" class="form-control" id="inputPhone"
								placeholder="Numéro de télpéhone" name="numeroTelephone">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="inputAddresse">Addresse</label> <input type="text"
								class="form-control" id="inputAddresse"
								placeholder="Numéro et nom de rue" name="adresse1">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputCp">Code Postale</label> <input type="number"
								class="form-control" id="inputCp" name="codePostal">
						</div>
						<div class="form-group col-md-8">
							<label for="inputVille">Ville</label> <input type="text"
								class="form-control" id="inputVille" name="ville">
						</div>
					</div>
					<div class="form-row text-center">
						<input type="submit" value="Enregistrer"
							class="btn btn-success btn-lg">
					</div>
				</form>
			</div>
			<div class="col-sm-1 sidenav"></div>
		</div>
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