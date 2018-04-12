package domaineCompte;

import domaine.Client;

//import java.text.SimpleDateFormat;
//import java.util.Date;



public class CCourant extends Compte {
	
	// propri�t�s
	private double decouvert;
	private Carte carte = new Carte();
	
	// construtors
	public CCourant() {
		super();
	}

	public CCourant(String formater, Client client) {
		super(formater, client);
		this.decouvert = 1000;
//		super.setNumeroCompte(001);
	}
	
	// getters et setters
	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double d) {
		this.decouvert = d;
	}
	
	// toString
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un d�couvert autoris� de " + this.decouvert + " et est associ� � une carte " +this.carte.getType();
	}
}
