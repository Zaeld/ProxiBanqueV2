package service;

import dAO.ClientDAO;

import domaine.Client;
import domaine.Courant;
import domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class GestionClientService {

	// La classe GestionClientService est composée des méthodes verifClientFortune
	// et calculSommeTotal qui permettent de modifier sous conditions les attributs
	// situationFinanciere et soldeTotal d'un objet de type Client

	// Déclaration
	ClientDAO dao = new ClientDAO();

	// La méthode verifClientFortune prend un objet de type Client en paramètre
	// d'entrée et modifie son attribut situationFinanciere sous conditions

	public Client verifClientFortune(Client client) {

		// On récupère la situation professionnelle du client
		String isEntreprise = client.getSituationProfessionnel();

		// On récupère le solde total du client
		double totalSolde = client.getSoldeTotal();

		// Si le client est un particulier on test son solde total

		if (isEntreprise.equals("particulier")) {

			// Si le solde total dépasse la limite de client Fortune, sa situation
			// financière prend la valeur "riche"
			if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
				client.setSituationFinanciere("riche");
			} else {
				// Si le solde total ne dépasse pas la limite de client Fortune, sa situation
				// financière prend la valeur "normal"
				client.setSituationFinanciere("normal");
			}
			// On met à jour les informations du client dans la base de donnée
			dao.updateClient(client);
		}
		return client;
	}

	// La méthode calculSommeTotal prend un objet de type Client en paramètre
	// d'entrée et calcul son solde total
	public Client calculSommeTotal(Client client) {

		// Déclaration
		double soldeTotal = 0;
		Courant compteCourant = new Courant();
		Epargne compteEpargne = new Epargne();

		// On récupère dans la base de donnée les comptes associés au client

		compteCourant = dao.getCompteCourant(client);
		compteEpargne = dao.getCompteEpargne(client);

		// Si le client possède un compte courant on ajoute son solde à la variable
		// soldeTotal
		if (compteCourant != null) {
			soldeTotal += compteCourant.getSolde();
		}
		// Si le client possède un compte épargne on ajoute son solde à la variable
		// soldeTotal
		if (compteEpargne != null) {
			soldeTotal += compteEpargne.getSolde();
		}
		// On set le solde total du client
		client.setSoldeTotal(soldeTotal);

		// On vérifie si le client change de situation financière
		this.verifClientFortune(client);

		// On met à jour les informations du client dans la base de donnée
		dao.updateClient(client);

		return client;

	}
}
