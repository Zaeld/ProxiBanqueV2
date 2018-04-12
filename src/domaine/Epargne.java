package domaine;

import domaine.Client;

public class Epargne extends CompteBancaire {
	
	// propriété
	private double tauxInteret;
	
	// constructor
	public Epargne() {
		super();
	}

	public Epargne(String formater, Client client) {
		super(formater, client);
		this.tauxInteret = 3.00;
//		super.setNumeroCompte(001);
	}
	
	// getter et setter
	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double taux) {
		this.tauxInteret = taux;
	}
	
	// toString
	public String toString() {
		return super.toString(this.getNumeroCompte()) + " et a un taux d'épargne de " + this.tauxInteret +"%";
	}
}
