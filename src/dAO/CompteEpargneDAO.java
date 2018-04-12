package dAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaineCompte.CCourant;
import domaineCompte.CEpargne;

public class CompteEpargneDAO {
	public boolean creerCompte(Client client, CEpargne compte) {
		int i = 0;
		boolean b = false;
		try {

			String s = "INSERT INTO `compte`(`numeroCompte`, `tauxInteret`, `dateOuverture`, `solde`, `idClient`)"
					+ " VALUES ( " + compte.getNumeroCompte() + ", " + compte.getTaux() + ", '"
					+ compte.getDateOuverture() + "', " + compte.getSolde() + ", '" + client.getIdClient() + ")";
			Statement stmt = Connexion.connexion().prepareStatement(s);
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0)
			b = true;
		return b;

	}

	public CEpargne getCompte(CEpargne compte) {
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from compte where idCompte = " + compte.getIdCompte();
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setTaux(rs.getDouble("tauxInteret"));
			compte.setDateOuverture(rs.getString("dateOuverture"));
			compte.setSolde(rs.getDouble("solde"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	public CEpargne updateCompte(CEpargne compte) {
		try {

			Statement stmt = Connexion.connexion().createStatement();
			String s = "UPDATE compte set numeroCompte = '" + compte.getNumeroCompte() + "', tauxInteret = '"
					+ compte.getTaux() + "', dateOuverture = " + compte.getDateOuverture() + ", solde = "
					+ compte.getSolde() + " where idcompte = " + compte.getIdCompte();
			stmt.executeUpdate(s);
			s = "Select * from Client where idClient = " + compte.getIdCompte();
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			compte.setIdCompte(rs.getInt("IdCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setTaux(rs.getDouble("tauxInteret"));
			compte.setDateOuverture(rs.getString("dateOuverture"));
			compte.setSolde(rs.getDouble("solde"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compte;
	}

	public boolean deleteCompte(CEpargne compte) {
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

	public List<CEpargne> getAllCompte() {
		List<CEpargne> listCEpargne = new ArrayList<CEpargne>();
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from compte";
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			while (rs.next()) {
				CEpargne compte = new CEpargne();
				compte.setIdCompte(rs.getInt("IdCompte"));
				compte.setNumeroCompte(rs.getInt("numeroCompte"));
				compte.setTaux(rs.getDouble("tauxInteret"));
				compte.setDateOuverture(rs.getString("dateOuverture"));
				compte.setSolde(rs.getDouble("solde"));
				listCEpargne.add(compte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCEpargne;
	}
}
