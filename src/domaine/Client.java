package domaine;

public class Client {
int idClient;
String nom;
String prenom;
int age;
int idConseiller;



public Client() {
	this.idClient = 7;
	this.nom = "babar";
	this.prenom = "bob";
	this.age = 21;
	this.idConseiller = 1;}



public Client(int idClient, String nom, String prenom, int age, int idConseiller) {
	this.idClient = idClient;
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.idConseiller = idConseiller;
}

public int getIdClient() {
	return idClient;
}



public void setIdClient(int idClient) {
	this.idClient = idClient;
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



public int getAge() {
	return age;
}



public void setAge(int age) {
	this.age = age;
}



public int getIdConseiller() {
	return idConseiller;
}



public void setIdConseiller(int idConseiller) {
	this.idConseiller = idConseiller;
}
public String toString() {
	return  this.nom + " " + this.prenom + " a "+ this.age + " ans et est le client n°" + this.getIdClient() + " avec comme conseiller le conseiller n°" + this.idConseiller + " ";
}
}
