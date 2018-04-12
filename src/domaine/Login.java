package domaine;

public class Login {
private int idLogin;
private String login;
private String motDePasse;
private int idConseiller;

public Login(String identifiant, String motDePasse) {
	super();
	this.idLogin = 0;
	this.login = identifiant;
	this.motDePasse = motDePasse;
	this.idConseiller = 0;
}

public int getIdLogin() {
	return idLogin;
}

public void setIdLogin(int idLogin) {
	this.idLogin = idLogin;
}

public String getIdentifiant() {
	return login;
}

public void setIdentifiant(String identifiant) {
	this.login = identifiant;
}

public String getMotDePasse() {
	return motDePasse;
}

public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
}

public int getIdConseiller() {
	return idConseiller;
}

public void setIdConseiller(int idEmploye) {
	this.idConseiller = idEmploye;
}



}
