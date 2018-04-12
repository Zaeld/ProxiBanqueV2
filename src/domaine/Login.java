package domaine;

/**
 * @author Stagiaire
 *
 */
public class Login {

	// Déclaration des attributs caractérisant un objet de type Login

	private String login;
	private String motDePasse;
	private int idConseiller;

	// Constructeur paramétré

	public Login(String identifiant, String motDePasse) {
		super();
		this.login = identifiant;
		this.motDePasse = motDePasse;
		this.idConseiller = 0;
	}

	// Getters et Setters

	public String getIdentifiant() {
		return login;
	}

	public void setIdentifiant(String identifiant) {
		this.login = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idEmploye) {
		this.idConseiller = idEmploye;
	}

}
