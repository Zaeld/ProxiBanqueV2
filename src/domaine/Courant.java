package domaine;

/**
 * @author Stagiaire
 *
 */
public class Courant extends CompteBancaire {
	// La classe Courant hérite de la classe abstraite CompteBancaire

	// Déclaration des attributs caractérisant un objet de type Courant
	private double decouvertAutorise;
	private String TypeCarte;

	// Constructeur par défaut
	public Courant() {
		super();
		this.decouvertAutorise = 1000;
		this.setTypeDeCompte("courant");
	}

	// Getters et Setters
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

	// Redéfinition de la méthode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un découvert autorisé de " + this.decouvertAutorise
				+ " et est associé à une carte " + this.getTypeCarte();
	}
}
