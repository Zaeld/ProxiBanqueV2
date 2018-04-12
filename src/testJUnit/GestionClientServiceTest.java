package testJUnit;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dAO.ClientDAO;
import dAO.CompteCourantDAO;
import dAO.CompteEpargneDAO;
import domaine.Client;
import domaine.Courant;
import domaine.Epargne;
import service.GestionClientService;
import service.IGestionClientFortunes;

public class GestionClientServiceTest {
	private static int idTest = 2;
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

	@BeforeClass
	public static void beforeAll() {
		// On crée les objets qui vont contenir nos sauvegardes de base de donnée
		clientsave.setIdClient(idTest);
		courantsave.setIdClient(clientsave.getIdClient());
		epargnesave.setIdClient(clientsave.getIdClient());

		
		// On affecte les objets avec les entrées de base de donnée à sauvegarder
		clientsave=dao.getClient(clientsave);
		courantsave=courantdao.getCourant(courantsave);
		epargnesave=epargnedao.getEpargne(epargnesave);	
		
		// On crée les objets de test
		client.setIdClient(idTest);
		courant.setIdClient(client.getIdClient());
		epargne.setIdClient(client.getIdClient());
	}
	@Test
	public void verifClientFortuneTest() {
		String résultat;
		client.setSituationFinanciere("normal");
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

	@Test
	public void verifClientFortuneTest1() {
		String résultat;
		client.setSituationProfessionnel("particulier");
		client.setSoldeTotal(200000);
		double totalSolde = client.getSoldeTotal();
		résultat = service.verifClientFortune(client).getSituationFinanciere();
		if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
			assertThat(résultat, IsEqual.equalTo("riche"));
		} else {
			assertThat(résultat, IsEqual.equalTo("normal"));
		}
	}

	@Test
	public void verifClientFortuneTest2() {
		String résultat;
		client.setSituationProfessionnel("entreprise");
		client.setSoldeTotal(1000000);
		résultat = service.verifClientFortune(client).getSituationFinanciere();
		assertThat(résultat, IsEqual.equalTo("normal"));
	}
	@Test
	public void calculSommeTotalTest() {
		courant.setSolde(75000);
		epargne.setSolde(25000);
		double monsolde = 100000;
		client=service.calculSommeTotal(client);
		assertThat(monsolde, IsEqual.equalTo(client.getSoldeTotal()));

	
	}
@AfterClass
public static void afterAll() {
	// La base de donnée est restaurée grace aux sauvegardes
	dao.updateClient(clientsave);
	courantdao.updateCourant(courantsave);
	epargnedao.updateEpargne(epargnesave);

}
}
