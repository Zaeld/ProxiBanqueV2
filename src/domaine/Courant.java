package domaine;

import domaine.Client;

//import java.text.SimpleDateFormat;
//import java.util.Date;



public class Courant extends CompteBancaire {
	
	// propri�t�s
	private double decouvertAutorise;
	private String TypeCarte;
	
	// construtors
	public Courant() {
		super();
	}

	public Courant(String formater, Client client) {
		super(formater, client);
		this.decouvertAutorise = 1000;
//		super.setNumeroCompte(001);
	}
	
	// getters et setters


	public double getdecouvertAutorise() {
		return decouvertAutorise;
	}

	public String getTypeCarte() {
		return TypeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		TypeCarte = typeCarte;
	}

	public void setdecouvertAutorise(double d) {
		this.decouvertAutorise = d;
	}
	
	// toString
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un d�couvert autoris� de " + this.decouvertAutorise + " et est associ� � une carte " +this.getTypeCarte();
	}
}
