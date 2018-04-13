package org.ProxiBanque.service;

import java.util.List;


import org.ProxiBanque.dao.ClientDAO;
import org.ProxiBanque.domaine.Client;
import org.ProxiBanque.domaine.Conseiller;
import org.ProxiBanque.domaine.Courant;
import org.ProxiBanque.domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class ClientService {

	// La classe ClientService permet de faire le lien entre la couche présentation
	// et la classe ClientDAO

	// Déclaration
	ClientDAO dao = new ClientDAO();

	/**
	 * @param client
	 * @return
	 */
	public boolean createClient(Client client) {
		return dao.createClient(client);
	}

	/**
	 * @param client
	 * @return
	 */
	public Client getClient(Client client) {
		return dao.getClient(client);
	}

	/**
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client) {
		return dao.updateClient(client);
	}

	/**
	 * @param client
	 * @return
	 */
	public boolean deleteClient(Client client) {
		return dao.deleteClient(client);
	}

	/**
	 * @return
	 */
	public List<Client> getAllClient() {
		return dao.getAllClient();
	}

	/**
	 * @param conseiller
	 * @return
	 */
	public List<Client> getAllClientConseiller(Conseiller conseiller) {
		return dao.getAllClientConseiller(conseiller);
	}

	/**
	 * @param client
	 * @return
	 */
	public Courant getCompteCourant(Client client) {
		return dao.getCompteCourant(client);
	}

	/**
	 * @param client
	 * @return
	 */
	public Epargne getCompteEpargne(Client client) {
		return dao.getCompteEpargne(client);
	}
}
