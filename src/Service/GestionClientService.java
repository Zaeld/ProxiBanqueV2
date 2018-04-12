package Service;

import dAO.ClientDAO;

import domaine.Client;
import domaine.Courant;
import domaine.Epargne;

public class GestionClientService {
	ClientDAO dao = new ClientDAO();

	public Client verifClientFortune(Client client) {
		String isEntreprise = client.getSituationProfessionnel();
		this.calculSommeTotal(client);
		double totalSolde = client.getSoldeTotal();
		if (isEntreprise.equals("particulier")) {
			if (totalSolde > IGestionClientFortunes.valeurIsRich) {
				client.setSituationFinanciere("riche");
			} else {
				client.setSituationFinanciere("normal");
			}
			dao.updateClient(client);
		}
		return client;
	}

	public Client calculSommeTotal(Client client) {
		double soldeTotal = 0;
		Courant compteCourant = new Courant();
		Epargne compteEpargne = new Epargne();
		compteCourant = dao.getCompteCourant(client);
		compteEpargne = dao.getCompteEpargne(client);

		if (compteCourant != null) {
			soldeTotal += compteCourant.getSolde();
		}
		if (compteEpargne != null) {
			soldeTotal += compteEpargne.getSolde();
		}
		client.setSoldeTotal(soldeTotal);
		dao.updateClient(client);

		return client;

	}
}
