package dAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Client;
import domaineCompte.CCourant;
import domaineCompte.CEpargne;
import domaineCompte.Compte;

public class ClientDAO {
	

	public boolean creerClient(Client client) {
		int i = 0;
		boolean b = false;
		try {
		Statement stmt = Connexion.connexion().createStatement();
		String s = "INSERT INTO `client`(`idClient`, `nom`, `prenom`, `idConseiller`, `age`) VALUES ("
				+ client.getIdClient() + ", '" + client.getNom() + "', '" + client.getPrenom() + "', '"
				+ client.getIdConseiller() + "', " + client.getAge() + ")";
		
			i = stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (i != 0)
			b = true;
		return b;

	}

	public Client getClient(int idClient, Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from Client where idClient = " + idClient;
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			client.setIdClient(rs.getInt("idClient"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setIdConseiller(rs.getInt("idConseiller"));
			client.setAge(rs.getInt("age"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;

	}

	public Client updateClient(Client client) {
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "UPDATE client set nom = '" + client.getNom() + "', prenom = '" + client.getPrenom()
					+ "', idConseiller = " + client.getIdConseiller() + ", age = " + client.getAge()
					+ " where idclient = " + client.getIdClient();
			stmt.executeUpdate(s);
			s = "Select * from Client where idClient = " + client.getIdClient();
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			rs.next();
			client.setIdClient(rs.getInt("idClient"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setIdConseiller(rs.getInt("idConseiller"));
			client.setAge(rs.getInt("age"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}

	public boolean deleteClient(Client client) {
		int i;
		boolean b = false;
		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "DELETE from client where idClient = " + client.getIdClient();
			i = stmt.executeUpdate(s);
			if (i != 0)
				b = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public List<Client> getAll() {
		List<Client> listClient = new ArrayList<Client>();

		try {
			Statement stmt = Connexion.connexion().createStatement();
			String s = "Select * from Client";
			// Etape 4 : exécution de la requete
			ResultSet rs = stmt.executeQuery(s);
			// Etape 5 : lecture
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setIdConseiller(rs.getInt("idConseiller"));
				client.setAge(rs.getInt("age"));
				listClient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClient;
	}
	public List<CCourant> getAllCompte() {
		List<CCourant> listCCourant = new ArrayList<CCourant>();
		List<CEpargne> listCEpargne = new ArrayList<CEpargne>();
		List listCompte = new ArrayList<Compte>();
		listCompte.addAll(listCCourant);
		listCompte.addAll(listCEpargne);
		return listCompte;
	}
}