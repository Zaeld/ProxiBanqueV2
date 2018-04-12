package domaine;

/**
 * @author Stagiaire
 *
 */
public class Courant extends CompteBancaire {
	// La classe Courant h�rite de la classe abstraite CompteBancaire

	// D�claration des attributs caract�risant un objet de type Courant
	private double decouvertAutorise;
	private String typeCarte;

	// Constructeur par d�faut
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

	// Red�finition de la m�thode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un d�couvert autoris� de " + this.decouvertAutorise
				+ " et est associ� � une carte " + this.getTypeCarte();
	}
}
