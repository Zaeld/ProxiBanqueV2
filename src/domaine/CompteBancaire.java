package domaine;

import domaine.Client;

//import java.text.SimpleDateFormat;
//import java.util.Date;



public abstract class CompteBancaire {

	// propriétés
	int idCompte;
	private int numCompte;
	private double solde;
	private String dateOuverture;
	int idClient;

	
	// constructors
	public CompteBancaire() {
		this.numCompte = (int) (Math.random() * 10000);
		this.solde = 12;
		this.dateOuverture = "lundi";
		this.idCompte=1;
	}

	public CompteBancaire(String date, Client client) {
		this.solde = 0;
		this.dateOuverture = date;
		this.numCompte = (int) (Math.random() * 10000);

	}

	// getters et setters
	public int getNumeroCompte() {
		return numCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	// toString
	public String toString(int numeroCompte) {
		return "Le compte de numéro " + this.numCompte + " a pour solde " + this.solde + " euros, a été créé le "
				+ this.dateOuverture;
	}
}
