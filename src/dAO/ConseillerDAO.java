package dAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domaine.Conseiller;

public class ConseillerDAO {
	public Conseiller getConseiller(Conseiller conseiller) {
		try {
			Statement stmt = Connexion.connexion().createStatement();

			String s = "Select * from Conseiller where idConseiller = " + conseiller.getIdConseiller();

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
