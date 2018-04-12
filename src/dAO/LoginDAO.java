package dAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import domaine.Conseiller;
import domaine.Login;

public class LoginDAO {
	public Conseiller VerificationLogin(Login login) {
		Conseiller conseiller = new Conseiller();

		try {
			Statement stmt = Connexion.connexion().createStatement();

			String s = "Select * from conseiller inner Join Login on conseiller.idConseiller = login.idConseiller where login = '"
					+ login.getIdentifiant() + "' && motDePasse = '" + login.getMotDePasse()+"'";
			ResultSet rs = stmt.executeQuery(s);
			rs.next();
			conseiller.setIdConseiller(rs.getInt("idConseiller"));
			conseiller.setNom(rs.getString("nom"));
			conseiller.setPrenom(rs.getString("prenom"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
			return conseiller;
	}

	}
