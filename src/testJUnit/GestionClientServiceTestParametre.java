package testJUnit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;


import dAO.ClientDAO;
import dAO.CompteCourantDAO;
import dAO.CompteEpargneDAO;
import domaine.Client;
import domaine.Courant;
import domaine.Epargne;
import service.GestionClientService;
import service.IGestionClientFortunes;

@RunWith(Parameterized.class)
public class GestionClientServiceTestParametre {
	private String situationProfessionnel;
	private double soldeTotal;
	
	public GestionClientServiceTestParametre(String situationProfessionnel, double soldeTotal) {
		super();
		this.situationProfessionnel = situationProfessionnel;
		this.soldeTotal=soldeTotal;
	}

	@Parameters
	static public List<Object[]> getParameters() {
		Object[][] parameters = { { "particulier", 200000 }, 
								{ "particulier", 1000000 }, 
								{ "entreprise", 200000 } };
		return Arrays.asList(parameters);
	}
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
		client.setSituationProfessionnel(situationProfessionnel);
		client.setSoldeTotal(soldeTotal);
		double totalSolde = client.getSoldeTotal();
		résultat = service.verifClientFortune(client).getSituationFinanciere();
		if (situationProfessionnel.equals("particulier")) {
		if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
			assertThat(résultat, IsEqual.equalTo("riche"));
		} else {
			assertThat(résultat, IsEqual.equalTo("normal"));
		}
	} else {
		assertThat(résultat, IsEqual.equalTo("riche"));

	}
	}
}


