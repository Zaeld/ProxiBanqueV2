package org.ProxiBanque.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import org.ProxiBanque.domaine.Conseiller;

public class ConseillerDAO {
	// ConseillerDAO est la classe comportant la methode getConseiller qui permet de
	// retourner un objet de type Conseiller recupere dans la base de donnee en
	// prenant en entree un objet conseiller vide
	public Conseiller getConseiller(Conseiller conseiller) {
		try {
			// Creation d'un objet de type Statement
			Statement stmt = Connexion.connexion().createStatement();
			
			// Affectation a la chaine de caractere s de la requete SQL
			String s = "Select * from Conseiller where idConseiller = " + conseiller.getIdConseiller();
			
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
