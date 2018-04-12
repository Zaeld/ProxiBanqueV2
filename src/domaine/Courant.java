package domaine;

/**
 * @author Stagiaire
 *
 */
public class Courant extends CompteBancaire {
	// La classe Courant h�rite de la classe abstraite CompteBancaire

	// D�claration des attributs caract�risant un objet de type Courant
	private double decouvertAutorise;
	private String TypeCarte;

	// Constructeur par d�faut
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

	// Red�finition de la m�thode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + ", a un d�couvert autoris� de " + this.decouvertAutorise
				+ " et est associ� � une carte " + this.getTypeCarte();
	}
}
