package org.ProxiBanque.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import org.ProxiBanque.domaine.Conseiller;
import org.ProxiBanque.domaine.Login;

/**
 * @author Stagiaire
 *
 */
public class LoginDAO {
	// LoginDAO est la classe comportant la m�thode Verification Login qui permet
	// de
	// v�rifier si les attributs Login correspondent � une entr�e de la table
	// login
	// de la base de donn�e afin d'autoriser la connexion du conseiller sur le
	// site
	// de ProxiBanque
	/**
	 * @param login
	 * @return
	 */
	public Conseiller VerificationLogin(Login login) {
		Conseiller conseiller = new Conseiller();

		try {
			// Creation d'un objet de type Statement
			Statement stmt = Connexion.connexion().createStatement();

			// Affectation a la chaine de caractere s de la requete SQL
			String s = "Select * from conseiller inner Join Login on conseiller.idConseiller = login.idConseiller where login = '"
					+ login.getIdentifiant() + "' && motDePasse = '" + login.getMotDePasse() + "'";

			// execution de la requete
			ResultSet rs = stmt.executeQuery(s);
			
			// Lecture des resultats de la requete
			rs.next();
			conseiller.setIdConseiller(rs.getInt("idConseiller"));
			conseiller.setNom(rs.getString("nom"));
			conseiller.setPrenom(rs.getString("prenom"));

		} catch (SQLException e) {
			return null;
		}
		return conseiller;
	}

}
