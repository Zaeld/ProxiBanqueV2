package dAO;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import domaine.Conseiller;
import domaine.Login;

public class ConseillerDAO {
	// EmployeDAO est la classe dans la couche DAO qui permet d'accéder aux
	// informations de la table 'Employe'de la base de donnée spécifiée dans la
	// classe Connexion.
	// Un gérand est une entrée de la table 'Employe' avec en attribut profession =
	// 'gerand'.
	// Un conseiller est une entrée de la table 'Employe' avec en attribut
	// profession = 'conseiller'.
	// Cette classe permet de créer, lire les informations, modifier, supprimer un
	// client, de récupérer ses comptes et de récupérer la liste de la totalité des
	// clients.
	
	
	public Conseiller getConseiller(Login login) {
		Conseiller conseiller = new Conseiller();
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from Conseiller where idConseiller = " + login.getIdConseiller();
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
