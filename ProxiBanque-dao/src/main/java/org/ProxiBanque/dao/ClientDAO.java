package org.ProxiBanque.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ProxiBanque.domaine.Client;
import org.ProxiBanque.domaine.Conseiller;
import org.ProxiBanque.domaine.Courant;
import org.ProxiBanque.domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class ClientDAO {

	// ClientDAO est la classe dans la couche DAO qui permet d'acceder aux
	// informations de la table 'Client'de la base de donnee specifiee dans la
	// classe Connexion.
	// Un client correspond a une ligne de la table.
	// Cette classe permet de creer, lire les informations, modifier, supprimer un
	// client, de recuperer ses comptes et de recuperer la liste de la
	// totalite des
	// clients ou seulement ceux propre a un conseiller.

	// Methode permettant d'inserer un client en base de donnee en prenant un
	// objet
	// de type client en entree et retournant un boolean de valeur true si
	// l'operation a ete un succes.
	/**
	 * @param client
	 * @return
	 */
	public boolean createClient(Client client) {
		int i = 0;
		boolean b = false;
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Creation d'un objet de type Statement

			// Affectation a la chaine de caractere s de la requete SQL
			String s = "INSERT INTO `client`(`adresse`, `nom`, `prenom`, `codePostal`, `ville`, `email`, `situationFinanciere`, `situationProfessionnel`, `idConseiller`, `telephone`, `soldeTotal`) VALUES ('"
					+ client.getAdresse() + "', '" + client.getNom() + "', '" + client.getPrenom() + "', '"
					+ client.getCodePostal() + "', '" + client.getVille() + "', '" + client.getEmail() + "', '"
					+ client.getSituationFinanciere() + "', '" + client.getSituationProfessionnel() + "', "
					+ client.getidConseiller() + ", '" + client.getTelephone() + "', " + client.getSoldeTotal() + ")";

			// execution de la requete
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'operation est un succes, i est differend de 0 et la methode
		// retourne
		// true
		if (i != 0)
			b = true;
		return b;

	}

	// Methode permettant de recuperer les informations d'un client de la
	// table
	// 'client' en prenant comme parametre d'entree un objet client presentant
	// comme
	// attribut l'idClient du client a recuperer. La methode retourne un
	// objet
	// client presentants les informations recuperees.
	/**
	 * @param client
	 * @return
	 */
	public Client getClient(Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Creation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "Select * from Client where idClient = " + client.getIdClient();

			// Ex�cution de la requ�te
			ResultSet rs = stmt.executeQuery(s);

			// Lecture des r�sultats de la requ�te
			rs.next();
			client.setIdClient(rs.getInt("idClient"));
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

	// M�thode permettant de modifier les informations d'un client de la table
	// 'client' en prenant comme param�tre d'entr�e un objet client pr�sentant
	// les
	// nouvelles valeurs d'attributs . La m�thode retourne l'objet client
	// r�cup�r�
	// de la base de donn�e avec les nouvelles valeurs d'attribut.
	/**
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "UPDATE client set adresse = '" + client.getAdresse() + "', nom = '" + client.getNom()
					+ "', prenom = '" + client.getPrenom() + "', CodePostal = '" + client.getCodePostal()
					+ "', ville = '" + client.getVille() + "', email = '" + client.getEmail()
					+ "', situationProfessionnel = '" + client.getSituationProfessionnel() + "', idConseiller = "
					+ client.getidConseiller() + ", telephone = '" + client.getTelephone() + "', soldeTotal = "+client.getSoldeTotal()+" where idClient = "
					+ client.getIdClient() + "";
			// ex�cution de la requ�te
			stmt.executeUpdate(s);

			// Affectation � la chaine de caract�re s de la requ�te SQL
			s = "Select * from client where idClient = " + client.getIdClient();
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des r�sultats de la requ�te
			rs.first();
			client.setIdClient(rs.getInt("idClient"));
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

	// M�thode permettant de suppimer l'entr�e de la table 'client' pr�sentant
	// le
	// m�me idClient que l'objet client en param�tre d'entr�e de m�thode et
	// retournant un boolean de valeur true si
	// l'op�ration a �t� un succ�s.
	/**
	 * @param client
	 * @return
	 */
	public boolean deleteClient(Client client) {

		int i;
		boolean b = false;
		try {

			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL, il est
			// n�cessaire
			// de supprimer les comptes du client avant de le supprimer car la table
			// 'compte' est d�pendante de la table 'client'

			String s = "DELETE from compte where idClient = " + client.getIdClient();

			// ex�cution de la requ�te
			i = stmt.executeUpdate(s);

			// Affectation � la chaine de caract�re s de la requ�te SQL
			s = "DELETE from client where idClient = " + client.getIdClient();

			// ex�cution de la requ�te
			i = stmt.executeUpdate(s);
			// Si l'op�ration est un succ�s, i est diff�rend de 0 et la m�thode
			// retourne
			// true
			if (i != 0)
				b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// M�thode retournant une liste de toute les entr�es de la table 'client' de
	// la
	// base de donn�e.
	/**
	 * @return
	 */
	public List<Client> getAllClient() {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "Select * from Client";

			// ex�cution de la requ�te
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des r�sultats de la requ�te et insertion dans la liste pour
			// chaque
			// boucle
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
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
			return null;
		}
		return listClient;
	}

	// M�thode retournant une liste de toute les entr�es de la table 'client'
	// correspondant � l'objet conseiller en entr�e de m�thode
	/**
	 * @param conseiller
	 * @return
	 */
	public List<Client> getAllClientConseiller(Conseiller conseiller) {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "Select * from Client where idConseiller = " + conseiller.getIdConseiller();

			// ex�cution de la requ�te
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des r�sultats de la requ�te et insertion dans la liste pour
			// chaque
			// boucle
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
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
			return null;
		}
		return listClient;
	}

	// M�thode retournant le compte courant associ� au client en param�tre
	// d'entr�e
	// de m�thode.

	/**
	 * @param client
	 * @return
	 */
	public Courant getCompteCourant(Client client) {
		Courant compte = new Courant();
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "Select * from compte inner Join client on compte.idClient = client.idClient where typeDeCompte = 'courant' && client.idClient = "
					+ client.getIdClient();

			// ex�cution de la requ�te
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des r�sultats de la requ�te
			rs.first();
			compte.setIdClient(rs.getInt("IdClient"));
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setDecouvertAutorise(rs.getDouble("decouvertAutorise"));
			compte.setSolde(rs.getDouble("solde"));
			compte.setTypeCarte(rs.getString("typeCarte"));
		} catch (SQLException e) {
			return null;
		}
		return compte;
	}

	// M�thode retournant le compte �pargne associ� au client en param�tre
	// d'entr�e
	// de m�thode.

	/**
	 * @param client
	 * @return
	 */
	public Epargne getCompteEpargne(Client client) {
		Epargne compte = new Epargne();

		try {
			Statement stmt = Connexion.connexion().createStatement(); // Cr�ation d'un objet de type Statement

			// Affectation � la chaine de caract�re s de la requ�te SQL
			String s = "Select * from compte inner Join client on compte.idClient = client.idClient where typeDeCompte = 'epargne' && client.idClient = "
					+ client.getIdClient();

			// ex�cution de la requ�te
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des r�sultats de la requ�te
			rs.next();
			compte.setIdClient(rs.getInt("IdClient"));
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setSolde(rs.getDouble("solde"));
			compte.setTauxInteret(rs.getDouble("tauxInteret"));

		} catch (SQLException e) {
			return null;
		}
		return compte;
	}
}