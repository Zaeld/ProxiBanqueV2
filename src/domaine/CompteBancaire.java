package domaine;

/**
 * @author Stagiaire
 *
 */
public abstract class CompteBancaire {
	// Compte Bancaire est une classe abstraite dont vont h�rit�s les classes
	// Courant et Epargne

	// D�claration des attributs caract�risant un objet h�ritant de la classe
	// CompteBancaire
	private int idCompte;
	private int numCompte;
	private double solde;
	private int idClient;
	private String typeDeCompte;

	// Constructeur par d�faut
	public CompteBancaire() {
		this.numCompte = (int) (Math.random() * 10000);
		this.solde = 12;
		this.idCompte=1;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public String getTypeDeCompte() {
		return typeDeCompte;
	}

	public void setTypeDeCompte(String typeDeCompte) {
		this.typeDeCompte = typeDeCompte;
	}

	// Getters et Setters
	public int getNumeroCompte() {
		return numCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
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

	// Red�finition de la m�thode toString()
	public String toString(int numeroCompte) {
		return "Le compte de num�ro " + this.numCompte + " a pour solde " + this.solde + " euros.";
	}
}
