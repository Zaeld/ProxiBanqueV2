package service;

import java.util.List;



import dAO.ClientDAO;
import domaine.Client;
import domaine.Courant;
import domaine.Epargne;


public class ClientService {
	ClientDAO dao = new ClientDAO();

	public boolean createClient(Client client) {
		return dao.createClient(client);
	
	}

	public Client getClient(Client client) {
		return dao.getClient(client);
	}

	public Client updateClient(Client client) {
		return dao.updateClient(client);
	}

	public boolean deleteClient(Client client) {
		return dao.deleteClient(client);
	}

	public List<Client> getAllClient() {
		return dao.getAllClient();
		}
	public Courant getCompteCourant(Client client) {
		return dao.getCompteCourant(client);
		}
	public Epargne getCompteEpargne(Client client) {
		return dao.getCompteEpargne(client);
		}
}


