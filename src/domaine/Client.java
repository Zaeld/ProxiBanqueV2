package domaine;

public class Client {
int idClient;
private String nom;
private String prenom;
private String adresse;
private String codePostal;
private String ville;
private String telephone;
private String email;
private String situationProfessionnel;
private String situationFinanciere;
private double soldeTotal;
private int idConseiller;


public Client() {

}

public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
		String email, String situationProfessionnel) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.codePostal = codePostal;
	this.ville = ville;
	this.telephone = telephone;
	this.email = email;
	this.situationProfessionnel = situationProfessionnel;
}

public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone,
		String email, String situationProfessionnel, int idConseiller) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.codePostal = codePostal;
	this.ville = ville;
	this.telephone = telephone;
	this.email = email;
	this.situationProfessionnel = situationProfessionnel;
	this.idConseiller = idConseiller;
}


public double getSoldeTotal() {
	return soldeTotal;
}



public void setSoldeTotal(double soldeTotal) {
	this.soldeTotal = soldeTotal;
}



public void setIdClient(int idClient) {
	this.idClient = idClient;
}



public String getAdresse() {
	return adresse;
}



public void setAdresse(String adresse) {
	this.adresse = adresse;
}



public String getCodePostal() {
	return codePostal;
}



public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
}



public String getVille() {
	return ville;
}



public void setVille(String ville) {
	this.ville = ville;
}



public String getSituationFinanciere() {
	return situationFinanciere;
}



public void setSituationFinanciere(String situationFinanciere) {
	this.situationFinanciere = situationFinanciere;
}



public String getSituationProfessionnel() {
	return situationProfessionnel;
}



public void setSituationProfessionnel(String situationProfessionnel) {
	this.situationProfessionnel = situationProfessionnel;
}



public String getTelephone() {
	return telephone;
}



public void setTelephone(String telephone) {
	this.telephone = telephone;
}



public int getidConseiller() {
	return idConseiller;
}



public void setidConseiller(int idConseiller) {
	this.idConseiller = idConseiller;
}



public int getIdClient() {
	return idClient;
}




public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrenom() {
	return prenom;
}



public void setPrenom(String prenom) {
	this.prenom = prenom;
}





public String toString() {
	return  this.nom + " " + this.prenom + " est le client n°" + this.getIdClient() + " avec comme conseiller le conseiller n°" + this.idConseiller + " ";
}
}
