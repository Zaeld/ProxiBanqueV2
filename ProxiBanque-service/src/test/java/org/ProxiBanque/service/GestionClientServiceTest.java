package org.ProxiBanque.service;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.ProxiBanque.dao.ClientDAO;
import org.ProxiBanque.dao.CompteCourantDAO;
import org.ProxiBanque.dao.CompteEpargneDAO;
import org.ProxiBanque.domaine.Client;
import org.ProxiBanque.domaine.Courant;
import org.ProxiBanque.domaine.Epargne;
import org.ProxiBanque.service.GestionClientService;
import org.ProxiBanque.service.IGestionClientFortunes;

public class GestionClientServiceTest {
	// La classe GestionClientServiceTest permet de tester les méthodes de la classe
	// GestionClientService

	// Déclaration
	private static int idTest = 3;
	GestionClientService service = new GestionClientService();
	static ClientDAO dao = new ClientDAO();
	static CompteCourantDAO courantdao = new CompteCourantDAO();
	static CompteEpargneDAO epargnedao = new CompteEpargneDAO();

	static Client client = new Client();
	static Courant courant = new Courant();
	static Epargne epargne = new Epargne();

	static Client clientsave = new Client();
	static Courant courantsave = new Courant();
	static Epargne epargnesave = new Epargne();

	// Cette méthode va s'éxécuter une fois avant tout les tests pour sauvegarder
	// nos données et affecter un idClient à nos objets
	@BeforeClass
	public static void beforeAll() {
		// On crée les objets qui vont contenir nos sauvegardes de base de donnée
		clientsave.setIdClient(idTest);
		courantsave.setIdClient(clientsave.getIdClient());
		epargnesave.setIdClient(clientsave.getIdClient());

		// On affecte les objets avec les entrées de base de donnée à sauvegarder
		clientsave = dao.getClient(clientsave);
		courantsave = courantdao.getCourant(courantsave);
		epargnesave = epargnedao.getEpargne(epargnesave);

		// On crée les objets de test
		client.setIdClient(idTest);
		courant.setIdClient(client.getIdClient());
		epargne.setIdClient(client.getIdClient());
	}

	@Test
	public void verifClientFortuneTest() {
		String résultat;
		client.setSituationProfessionnel("particulier");
		client.setSoldeTotal(1000000);
		double totalSolde = client.getSoldeTotal();
		résultat = service.verifClientFortune(client).getSituationFinanciere();
		if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
			assertThat(résultat, IsEqual.equalTo("riche"));
		} else {
			assertThat(résultat, IsEqual.equalTo("normal"));
		}
	}



	@AfterClass
	public static void afterAll() {
		// La base de donnée est restaurée grace aux sauvegardes
		dao.updateClient(clientsave);
		courantdao.updateCourant(courantsave);
		epargnedao.updateEpargne(epargnesave);

	}
}
