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

	// La classe GestionClientService est compos�e des m�thodes verifClientFortune
	// et calculSommeTotal qui permettent de modifier sous conditions les attributs
	// situationFinanciere et soldeTotal d'un objet de type Client

	// D�claration
	ClientDAO dao = new ClientDAO();

	// La m�thode verifClientFortune prend un objet de type Client en param�tre
	// d'entr�e et modifie son attribut situationFinanciere sous conditions

	public Client verifClientFortune(Client client) {

		// On r�cup�re la situation professionnelle du client
		String isEntreprise = client.getSituationProfessionnel();

		// On r�cup�re le solde total du client
		double totalSolde = client.getSoldeTotal();

		// Si le client est un particulier on test son solde total

		if (isEntreprise.equals("particulier")) {

			// Si le solde total d�passe la limite de client Fortune, sa situation
			// financi�re prend la valeur "riche"
			if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
				client.setSituationFinanciere("riche");
			} else {
				// Si le solde total ne d�passe pas la limite de client Fortune, sa situation
				// financi�re prend la valeur "normal"
				client.setSituationFinanciere("normal");
			}
			// On met � jour les informations du client dans la base de donn�e
			dao.updateClient(client);
		}
		return client;
	}

	// La m�thode calculSommeTotal prend un objet de type Client en param�tre
	// d'entr�e et calcul son solde total
	public Client calculSommeTotal(Client client) {

		// D�claration
		double soldeTotal = 0;
		Courant compteCourant = new Courant();
		Epargne compteEpargne = new Epargne();

		// On r�cup�re dans la base de donn�e les comptes associ�s au client

		compteCourant = dao.getCompteCourant(client);
		compteEpargne = dao.getCompteEpargne(client);

		// Si le client poss�de un compte courant on ajoute son solde � la variable
		// soldeTotal
		if (compteCourant != null) {
			soldeTotal += compteCourant.getSolde();
		}
		// Si le client poss�de un compte �pargne on ajoute son solde � la variable
		// soldeTotal
		if (compteEpargne != null) {
			soldeTotal += compteEpargne.getSolde();
		}
		// On set le solde total du client
		client.setSoldeTotal(soldeTotal);

		// On v�rifie si le client change de situation financi�re
		this.verifClientFortune(client);

		// On met � jour les informations du client dans la base de donn�e
		dao.updateClient(client);

		return client;

	}
}
