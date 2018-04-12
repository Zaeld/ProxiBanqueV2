package domaine;

/**
 * @author Stagiaire
 *
 */
public class Courant extends CompteBancaire {
	// La classe Courant hérite de la classe abstraite CompteBancaire

	// Déclaration des attributs caractérisant un objet de type Courant
	private double decouvertAutorise;
	private String typeCarte;

	// Constructeur par défaut
	public Courant() {
		super();
		this.decouvertAutorise = 1000;
		this.setTypeDeCompte("courant");
	}

	// Getters et Setters
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public void setDecouvertAutorise(double d) {
		this.decouvertAutorise = d;
	}

	// Redéfinition de la méthode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un découvert autorisé de " + this.decouvertAutorise
				+ " et est associé à une carte " + this.getTypeCarte();
	}
}
