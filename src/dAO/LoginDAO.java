package dAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import domaine.Conseiller;
import domaine.Login;

/**
 * @author Stagiaire
 *
 */
public class LoginDAO {
	// LoginDAO est la classe comportant la m�thode Verification Login qui permet de
	// v�rifier si les attributs Login correspondent � une entr�e de la table login
	// de la base de donn�e afin d'autoriser la connexion du conseiller sur le site
	// de ProxiBanque
	/**
	 * @param login
	 * @return
	 */
	public Conseiller VerificationLogin(Login login) {
		Conseiller conseiller = new Conseiller();

		try {
			Statement stmt = Connexion.connexion().createStatement();

			String s = "Select * from conseiller inner Join Login on conseiller.idConseiller = login.idConseiller where login = '"
					+ login.getIdentifiant() + "' && motDePasse = '" + login.getMotDePasse() + "'";
			ResultSet rs = stmt.executeQuery(s);
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
