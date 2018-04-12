package domaine;

/**
 * @author Stagiaire
 *
 */
public class Epargne extends CompteBancaire {

	// La classe Epargne hérite de la classe abstraite CompteBancaire

	// Déclaration des attributs caractérisant un objet de type Epargne
	private double tauxInteret;

	// Constructeur par défaut
	public Epargne() {
		super();
		this.tauxInteret = 3.00;
		this.setTypeDeCompte("épargne");
	}

	// Getters et Setters
	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double taux) {
		this.tauxInteret = taux;
	}

	// Redéfinition de la méthode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + " et a un taux d'épargne de " + this.tauxInteret + "%";
	}
}
