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
					<h2 class="text-center">Virement Compte à Compte</h2>
				</div>
				<form method=post action="ServletVirement">
					<div class="form-row">
						<label for="inputCompteDebiteur">Choisissez le compte à
							débiter</label> <select id="inputCompteDebit" class="form-control" name="compteDebit">
							<option>${courant.getTypeDeCompte()} ${courant.getNumCompte()}</option>
							<option>${epargne.getTypeDeCompte()} ${epargne.getNumCompte()}</option>
						</select>
						<div class="form-row">
							<label for="inputCompteDebiteur">Choisissez le compte à
								créditer</label> <select id="inputCompteCredit" class="form-control" name="compteCredit">
								<c:foreach items="${listeCompte}" var="compte">
									<option>${compte.getTypeDeCompte()} ${compte.getNumCompte()}</option>								
								</c:foreach>
							</select>
						</div>
						<div class="form-row">
							<label for="inputSommeVirement">Entrer la somme du
								virement</label> <input type="number" class="form-control"
								id="inputSommeVirement" placeholder="Somme du virement"
								name="sommeVirement">
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