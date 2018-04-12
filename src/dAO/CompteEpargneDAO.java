package dAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class CompteEpargneDAO {
	// CompteEpargneDAO est la classe dans la couche DAO qui permet d'accéder aux
	// informations de la table 'Compte'de la base de donnée spécifiée dans la
	// classe Connexion.
	// Un compte épargne est une entrée de la table 'compte' avec en attribut
	// typeCompte = 'épargne'.
	// Cette classe permet de créer, lire les informations, modifier, supprimer un
	// compte épargne, et de récupérer la liste de la totalité des
	// comptes épargnes.

	// Méthode permettant d'insérer un compte en base de donnée en prenant un objet
	// de type compte en entrée et retournant un boolean de valeur true si
	// l'opération a été un succès.
	/**
	 * @param compte
	 * @return
	 */
	public boolean createEpargne(Epargne compte) {
		int i = 0;
		boolean b = false;
		try {
			// Affectation à la chaine de caractère s de la requète SQL
			String s = "INSERT INTO `compte`(`numeroCompte`, `tauxInteret`, `dateOuverture`, `solde`, `idClient`, `typeDeCompte`)"
					+ " VALUES ( " + compte.getNumeroCompte() + ", " + compte.getTauxInteret() + ", "
					+ compte.getSolde() + ", " + compte.getIdClient() + ", '"+compte.getTypeDeCompte()+")";
			// Création d'un objet de type Statement
			Statement stmt = Connexion.connexion().prepareStatement(s);
			// exécution de la requete
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

	// Méthode permettant de récupérer les informations d'un compte de la table
	// 'compte' en prenant comme paramètre d'entrée un objet de type Epargne
	// présentant comme
	// attribut l'idCompte du compte à récupérer. La méthode retourne un objet
	// compte présentants les informations récupérées.
	/**
	 * @param compte
	 * @return
	 */
	public Epargne getEpargne(Epargne compte) {
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement
			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from compte where idCompte = " + compte.getIdCompte();
			// exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setTauxInteret(rs.getDouble("tauxInteret"));
			compte.setSolde(rs.getDouble("solde"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	// Méthode permettant de modifier les informations d'un client de la table
	// 'compte' en prenant comme paramètre d'entrée un objet compte présentant les
	// nouvelles valeurs d'attributs. La méthode retourne l'objet compte récupéré
	// de la base de donnée avec les nouvelles valeurs d'attribut.
	/**
	 * @param compte
	 * @return
	 */
	public Epargne updateEpargne(Epargne compte) {
		try {

			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement
			// Affectation à la chaine de caractère s de la requète SQL
			String s = "UPDATE compte set numeroCompte = '" + compte.getNumeroCompte() + "', tauxInteret = '"
					+ compte.getTauxInteret() + ", solde = " + compte.getSolde() + " where idcompte = "
					+ compte.getIdCompte();
			stmt.executeUpdate(s);
			// Affectation à la chaine de caractère s de la requète SQL
			s = "Select * from compte where idClient = " + compte.getIdCompte();
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setTauxInteret(rs.getDouble("tauxInteret"));
			compte.setSolde(rs.getDouble("solde"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	// Méthode permettant de suppimer l'entrée de la table 'compte' présentant le
	// même idCompte que l'objet compte en paramètre d'entrée de méthode et
	// retournant un boolean de valeur true si
	// l'opération a été un succès
	/**
	 * @param compte
	 * @return
	 */
	public boolean deleteEpargne(Epargne compte) {
		int i;
		boolean b = false;
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement
			// Affectation à la chaine de caractère s de la requète SQL
			String s = "DELETE from compte where idCompte = " + compte.getIdCompte();
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

	// Méthode retournant une liste de toute les entrées de la table 'compte' de la
	// base de donnée avec en attribut
	// typeCompte = 'épargne'.
	/**
	 * @return
	 */
	public List<Epargne> getAllEpargne() {
		List<Epargne> listCEpargne = new ArrayList<Epargne>();
		try {
			Statement stmt = Connexion.connexion().createStatement(); // Création d'un objet de type Statement
			// Affectation à la chaine de caractère s de la requète SQL
			String s = "Select * from compte";
			// exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Lecture des résultats de la requète et insertion dans la liste pour chaque
			// boucle
			while (rs.next()) {
				Epargne compte = new Epargne();
				compte.setIdCompte(rs.getInt("IdCompte"));
				compte.setNumeroCompte(rs.getInt("numeroCompte"));
				compte.setTauxInteret(rs.getDouble("tauxInteret"));
				compte.setSolde(rs.getDouble("solde"));
				listCEpargne.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCEpargne;
	}
}
