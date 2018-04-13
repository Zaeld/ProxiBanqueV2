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
				<li><a
					href="ServletRetourAcceuil">Retour</a></li>
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
					<h2 class="text-center">Modification du client</h2>
				</div>
				<form method=post " action="ServletModifierClient">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputName">Nom</label> <input type="text"
								class="form-control" id="inputNom" value="${client.getNom()}"
								name="nom" required>
						</div>
						<div class="form-group col-md-6">
							<label for="inputPrenom">Prénom</label> <input type="text"
								class="form-control" id="inputPrenom"
								value="${client.getPrenom()}" name="prenom" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-3">
									<label for="situationProfessionnel">Situation
										Professionnelle : </label> <select id="situationProfessionnel"
										class="form-control" name="situationProfessionnel" value="${client.getSituationProfessionnel()}" required>
										<option value="particulier">Particulier</option>
										<option value="entreprise">Entreprise</option>
									</select>
						</div>
						<div class="form-group col-md-5">
							<label for="inputMail">Email</label> <input type="email"
								class="form-control" id="inputMail" value="${client.getEmail()}"
								name="email" required>
						</div>
						<div class="form-group col-md-4">
							<label for="inputPhone">Numéro de téléphone</label> <input
								type="tel" class="form-control" id="inputPhone"
								value="${client.getTelephone()}" name="numeroTelephone" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="inputAddresse">Addresse</label> <input type="text"
								class="form-control" id="inputAddresse"
								value="${client.getAdresse()}" name="adresse" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputCp">Code Postale</label> <input type="number"
								class="form-control" id="inputCp"
								value="${client.getCodePostal()}" name="codePostal" required>
						</div>
						<div class="form-group col-md-8">
							<label for="inputVille">Ville</label> <input type="text"
								class="form-control" id="inputVille"
								value="${client.getVille()}" name="ville" required>
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