package dAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaineCompte.CCourant;

public class CompteCourantDAO {
	public boolean creerCompte(Client client, CCourant compte) {
		int i = 0;
		boolean b = false;
		try {

			String s = "INSERT INTO `compte`(`numeroCompte`, `decouvertAutorise`, `dateOuverture`, `solde`, `typeCarte`, `idClient`)"
					+ " VALUES ( " + compte.getNumeroCompte() + ", " + compte.getDecouvert() + ", '"
					+ compte.getDateOuverture() + "', " + compte.getSolde() + ", '" + compte.getCarte().getType().name()
					+ "', " + client.getIdClient() + ")";
			Statement stmt = Connexion.connexion().prepareStatement(s);
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0)
			b = true;
		return b;

	}

	public CCourant getCompte(CCourant compte) {
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from compte where idCompte = " + compte.getIdCompte();
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setDecouvert(rs.getDouble("decouvertAutorise"));
			compte.setDateOuverture(rs.getString("dateOuverture"));
			compte.setSolde(rs.getDouble("solde"));
			compte.getCarte().getType().setName(rs.getString("typeCarte"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	public CCourant updateCompte(CCourant compte) {
		try {

			Statement stmt = Connexion.connexion().createStatement();
			String s = "UPDATE compte set numeroCompte = '" + compte.getNumeroCompte() + "', decouvertAutorise = '"
					+ compte.getDecouvert() + "', dateOuverture = " + compte.getDateOuverture() + ", solde = "
					+ compte.getSolde() + ", typeCarte = " + compte.getCarte().getType().name()
					+ " where idcompte = " + compte.getIdCompte();
			stmt.executeUpdate(s);
			s = "Select * from Client where idClient = " + compte.getIdCompte();
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setDecouvert(rs.getDouble("decouvertAutorise"));
			compte.setDateOuverture(rs.getString("dateOuverture"));
			compte.setSolde(rs.getDouble("solde"));
			compte.getCarte().getType().setName(rs.getString("typeCarte"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	public boolean deleteCompte(CCourant compte) {
		int i;
		boolean b = false;
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "DELETE from compte where idCompte = " + compte.getIdCompte();
			i = stmt.executeUpdate(s);
			if (i != 0)
				b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<CCourant> getAllCompte() {
		List<CCourant> listCCourant = new ArrayList<CCourant>();
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from compte";
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			while (rs.next()) {
				CCourant compte = new CCourant();
				compte.setIdCompte(rs.getInt("IdCompte"));
				compte.setNumeroCompte(rs.getInt("numeroCompte"));
				compte.setDecouvert(rs.getDouble("decouvertAutorise"));
				compte.setDateOuverture(rs.getString("dateOuverture"));
				compte.setSolde(rs.getDouble("solde"));
				compte.getCarte().getType().setName(rs.getString("typeCarte"));
				listCCourant.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCCourant;
	}
}
