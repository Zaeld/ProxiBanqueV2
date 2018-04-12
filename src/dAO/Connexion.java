package dAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	// Classe appelant le driver et permettant la connexion avec la base de donnée.
	/**
	 * @return
	 */
	public static Connection connexion() {
		Connection maConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanque", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maConnection;
	}
}
