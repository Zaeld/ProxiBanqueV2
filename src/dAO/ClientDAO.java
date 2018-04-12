package dAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaine.Conseiller;
import domaine.Courant;
import domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class ClientDAO {

	// ClientDAO est la classe dans la couche DAO qui permet d'accéder aux
	// informations de la table 'Client'de la base de donnée spécifiée dans la
	// classe Connexion.
	// Un client correspond à une ligne de la table.
	// Cette classe permet de créer, lire les informations, modifier, supprimer un
	// client, de récupérer ses comptes et de récupérer la liste de la totalité des
	// clients ou seulement ceux propre à un conseiller.

	// Méthode permettant d'insérer un client en base de donnée en prenant un objet
	// de type client en entrée et retournant un boolean de valeur true si
	// l'opération a été un succès.
	/**
	 * @param client
	 * @return
	 */
	public boolean createClient(Client client) {
		int i = 0;
		boolean b = false;
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "INSERT INTO `client`(`adresse`, `nom`, `prenom`, `codePostal`, `ville`, `email`, `situationFinanciere`, `situationProfessionnel`, `idConseiller`, `telephone`, `soldeTotal`) VALUES ('"
					+ client.getAdresse() + "', '" + client.getNom() + "', '" + client.getPrenom() + "', '"
					+ client.getCodePostal() + "', '" + client.getVille() + "', '" + client.getEmail() + "', '"
					+ client.getSituationFinanciere() + "', '" + client.getSituationProfessionnel() + "', "
					+ client.getidConseiller() + ", '" + client.getTelephone() + "', " + client.getSoldeTotal() + ")";

			// exécution de la requète
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'opération est un succès, i est différend de 0 et la méthode retourne
		// true
		if (i != 0)
			b = true;
		return b;

	}

	// Méthode permettant de récupérer les informations d'un client de la table
	// 'client' en prenant comme paramètre d'entrée un objet client présentant comme
	// attribut l'idClient du client à récupérer. La méthode retourne un objet
	// client présentants les informations récupérées.
	/**
	 * @param client
	 * @return
	 */
	public Client getClient(Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from Client where idClient = " + client.getIdClient();

			// Exécution de la requète
			ResultSet rs = stmt.executeQuery(s);

			// Lecture des résultats de la requète
			rs.next();
			client.setAdresse(rs.getString("adresse"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setCodePostal(rs.getString("codePostal"));
			client.setVille(rs.getString("ville"));
			client.setEmail(rs.getString("email"));
			client.setSituationFinanciere(rs.getString("situationFinanciere"));
			client.setSituationProfessionnel(rs.getString("situationProfessionnel"));
			client.setidConseiller(rs.getInt("idConseiller"));
			client.setTelephone(rs.getString("telephone"));
			client.setSoldeTotal(rs.getInt("soldeTotal"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

	// Méthode permettant de modifier les informations d'un client de la table
	// 'client' en prenant comme paramètre d'entrée un objet client présentant les
	// nouvelles valeurs d'attributs . La méthode retourne l'objet client récupéré
	// de la base de donnée avec les nouvelles valeurs d'attribut.
	/**
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "UPDATE client set adresse = '" + client.getAdresse() + "', nom = '" + client.getNom()
					+ "', prenom = '" + client.getPrenom() + "', CodePostal = '" + client.getCodePostal()
					+ "', ville = '" + client.getVille() + "', email = '" + client.getEmail()
					+ "', situationFinanciere = '" + client.getSituationFinanciere() + "', situationProfessionnel = '"
					+ client.getSituationProfessionnel() + "', idConseiller = " + client.getidConseiller()
					+ ", telephone = '" + client.getTelephone() + "', soldeTotal = " + client.getSoldeTotal()
					+ " where idClient = " + client.getIdClient();
			// exécution de la requète
			stmt.executeUpdate(s);

			// Affectation à la chaine de caractère s de la requète SQL
			s = "Select * from client where idClient = " + client.getIdClient();
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète
			rs.first();
			client.setAdresse(rs.getString("adresse"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setCodePostal(rs.getString("codePostal"));
			client.setVille(rs.getString("ville"));
			client.setEmail(rs.getString("email"));
			client.setSituationFinanciere(rs.getString("situationFinanciere"));
			client.setSituationProfessionnel(rs.getString("situationProfessionnel"));
			client.setidConseiller(rs.getInt("idConseiller"));
			client.setTelephone(rs.getString("telephone"));
			client.setSoldeTotal(rs.getInt("soldeTotal"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	// Méthode permettant de suppimer l'entrée de la table 'client' présentant le
	// même idClient que l'objet client en paramètre d'entrée de méthode et
	// retournant un boolean de valeur true si
	// l'opération a été un succès.
	/**
	 * @param client
	 * @return
	 */
	public boolean deleteClient(Client client) {

		int i;
		boolean b = false;
		try {

			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL, il est nécessaire
			// de supprimer les comptes du client avant de le supprimer car la table
			// 'compte' est dépendante de la table 'client'

			String s = "DELETE from compte where idClient = " + client.getIdClient();

			// exécution de la requète
			i = stmt.executeUpdate(s);

			// Affectation à la chaine de caractère s de la requète SQL
			s = "DELETE from client where idClient = " + client.getIdClient();

			// exécution de la requète
			i = stmt.executeUpdate(s);
			// Si l'opération est un succès, i est différend de 0 et la méthode retourne
			// true
			if (i != 0)
				b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// Méthode retournant une liste de toute les entrées de la table 'client' de la
	// base de donnée.
	/**
	 * @return
	 */
	public List<Client> getAllClient() {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from Client";

			// exécution de la requète
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète et insertion dans la liste pour chaque
			// boucle
			while (rs.next()) {
				Client client = new Client();
				client.setAdresse(rs.getString("adresse"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setCodePostal(rs.getString("codePostal"));
				client.setVille(rs.getString("ville"));
				client.setEmail(rs.getString("email"));
				client.setSituationFinanciere(rs.getString("situationFinanciere"));
				client.setSituationProfessionnel(rs.getString("situationProfessionnel"));
				client.setidConseiller(rs.getInt("idConseiller"));
				client.setTelephone(rs.getString("telephone"));
				client.setSoldeTotal(rs.getInt("soldeTotal"));
				listClient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}

	// Méthode retournant une liste de toute les entrées de la table 'client'
	// correspondant à l'objet conseiller en entrée de méthode
	/**
	 * @param conseiller
	 * @return
	 */
	public List<Client> getAllClientConseiller(Conseiller conseiller) {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from Client where idConseiller = " + conseiller.getIdConseiller();

			// exécution de la requète
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète et insertion dans la liste pour chaque
			// boucle
			while (rs.next()) {
				Client client = new Client();
				client.setAdresse(rs.getString("adresse"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setCodePostal(rs.getString("codePostal"));
				client.setVille(rs.getString("ville"));
				client.setEmail(rs.getString("email"));
				client.setSituationFinanciere(rs.getString("situationFinanciere"));
				client.setSituationProfessionnel(rs.getString("situationProfessionnel"));
				client.setidConseiller(rs.getInt("idConseiller"));
				client.setTelephone(rs.getString("telephone"));
				client.setSoldeTotal(rs.getInt("soldeTotal"));
				listClient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}

	// Méthode retournant le compte courant associé au client en paramètre d'entrée
	// de méthode.
	
	/**
	 * @param client
	 * @return
	 */
	public Courant getCompteCourant(Client client) {
		Courant compte = new Courant();
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from compte inner Join client on compte.idClient = client.idClient where typeDeCompte = 'courant' && idClient = "
					+ client.getIdClient();

			// exécution de la requète
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setdecouvertAutorise(rs.getDouble("decouvertAutorise"));
			compte.setSolde(rs.getDouble("solde"));
			compte.setTypeCarte(rs.getString("typeCarte"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	// Méthode retournant le compte épargne associé au client en paramètre d'entrée
	// de méthode.

	/**
	 * @param client
	 * @return
	 */
	public Epargne getCompteEpargne(Client client) {
		Epargne compte = new Epargne();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement

			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from compte inner Join client on compte.idClient = client.idClient where typeDeCompte = 'épargne' && idClient = "
					+ client.getIdClient();

			// exécution de la requète
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setSolde(rs.getDouble("solde"));
			compte.setTauxInteret(rs.getDouble("tauxInteret"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}
}