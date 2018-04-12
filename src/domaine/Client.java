package domaine;

/**
 * @author Stagiaire
 *
 */
public class Client {
	
	// Déclaration des attributs caractérisant un objet de type Client
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String email;
	private String telephone;
	private String situationProfessionnel;
	private String situationFinanciere;
	private double soldeTotal;
	private int idConseiller;

	// Constructeur par défaut et paramétré

	public Client() {
		this.situationProfessionnel = "particulier";
		this.situationFinanciere = "normal";
		this.soldeTotal = 0;
	}

	public Client(int idClient) {
		super();
		this.idClient = idClient;
	}
	// Constructeur pour la modification du client

	public Client(int idClient, String nom, String prenom, String adresse, String codePostal, String ville, String email,
			String telephone, String situationProfessionnel, int idConseiller) {
		super();
		this.idClient=idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.telephone = telephone;
		this.situationProfessionnel = situationProfessionnel;
		this.idConseiller = idConseiller;

	}
	// Constructeur pour la création de client

	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String email,
			String telephone, String situationProfessionnel, int idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.telephone = telephone;
		this.situationProfessionnel = situationProfessionnel;
		this.situationFinanciere = "normal";
		this.soldeTotal = 0;
		this.idConseiller = idConseiller;
	}

	// Getters et Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public double getSoldeTotal() {
		return soldeTotal;
	}

	public void setSoldeTotal(double soldeTotal) {
		this.soldeTotal = soldeTotal;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getSituationFinanciere() {
		return situationFinanciere;
	}

	public void setSituationFinanciere(String situationFinanciere) {
		this.situationFinanciere = situationFinanciere;
	}

	public String getSituationProfessionnel() {
		return situationProfessionnel;
	}

	public void setSituationProfessionnel(String situationProfessionnel) {
		this.situationProfessionnel = situationProfessionnel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getidConseiller() {
		return idConseiller;
	}

	public void setidConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// Redéfinition de la méthode toString()
	public String toString() {
		return this.nom + " " + this.prenom + " est le client n°" + this.getIdClient()
				+ " avec comme conseiller le conseiller n°" + this.idConseiller + " ";
	}
}
