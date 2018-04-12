package domaineCompte;

import domaine.Client;

//import java.text.SimpleDateFormat;
//import java.util.Date;



public abstract class Compte {

	// propriétés
	private int numeroCompte;
	private double solde;
	private String dateOuverture;
	private Client client;
	int idClient;
	int idCompte;

	
	// constructors
	public Compte() {
		this.numeroCompte = (int) (Math.random() * 10000);
		this.solde = 12;
		this.dateOuverture = "lundi";
		this.client = new Client();
	}

	public Compte(String date, Client client) {
		this.solde = 0;
		this.dateOuverture = date;
		this.client = client;
		this.numeroCompte = (int) (Math.random() * 10000);

	}

	// getters et setters
	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		return "Le compte de numéro " + this.numeroCompte + " a pour solde " + this.solde + " euros, a été créé le "
				+ this.dateOuverture;
	}
}
