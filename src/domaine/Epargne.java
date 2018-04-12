package domaine;

/**
 * @author Stagiaire
 *
 */
public class Epargne extends CompteBancaire {

	// La classe Epargne h�rite de la classe abstraite CompteBancaire

	// D�claration des attributs caract�risant un objet de type Epargne
	private double tauxInteret;

	// Constructeur par d�faut
	public Epargne() {
		super();
		this.tauxInteret = 3.00;
		this.setTypeDeCompte("�pargne");
	}

	// Getters et Setters
	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double taux) {
		this.tauxInteret = taux;
	}

	// Red�finition de la m�thode toString()
	public String toString() {
		return super.toString(this.getNumeroCompte()) + " et a un taux d'�pargne de " + this.tauxInteret + "%";
	}
}
