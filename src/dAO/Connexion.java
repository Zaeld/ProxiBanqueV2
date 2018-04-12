package dAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	public static Connection connexion() {
		Connection maConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxybanque", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maConnection;
	}
}
