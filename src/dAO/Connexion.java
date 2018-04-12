package dAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Stagiaire
 *
 */
public class Connexion {
	// Classe appelant le driver et permettant la connexion avec la base de donnée.
	/**
	 * @return
	 */
	public static Connection connexion() {
		Connection maConnection = null; // Déclaration d'un objet de type Connection.
		try {
			// Importation du Driver permettant la liaison avec le serveur de Base de
			// donnée.
			Class.forName("com.mysql.jdbc.Driver");
			// L'objet maConnection est configurée avec les coordonnées de la base de donnée
			// de proxibanque
			maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanque", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// La méthode retourne un objet de type Connection permettant aux méthodes de la
		// couche DAO d'interargir avec la base de donnée.
		return maConnection;
	}
}
