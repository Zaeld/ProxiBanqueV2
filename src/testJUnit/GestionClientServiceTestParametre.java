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
		// On cr�e les objets qui vont contenir nos sauvegardes de base de donn�e
		clientsave.setIdClient(idTest);
		courantsave.setIdClient(clientsave.getIdClient());
		epargnesave.setIdClient(clientsave.getIdClient());

		
		// On affecte les objets avec les entr�es de base de donn�e � sauvegarder
		clientsave=dao.getClient(clientsave);
		courantsave=courantdao.getCourant(courantsave);
		epargnesave=epargnedao.getEpargne(epargnesave);	
		
		// On cr�e les objets de test
		client.setIdClient(idTest);
		courant.setIdClient(client.getIdClient());
		epargne.setIdClient(client.getIdClient());
	}
	@Test
	public void verifClientFortuneTest() {
		String r�sultat;
		client.setSituationProfessionnel(situationProfessionnel);
		client.setSoldeTotal(soldeTotal);
		double totalSolde = client.getSoldeTotal();
		r�sultat = service.verifClientFortune(client).getSituationFinanciere();
		if (situationProfessionnel.equals("particulier")) {
		if (totalSolde > IGestionClientFortunes.valeurIsFortune) {
			assertThat(r�sultat, IsEqual.equalTo("riche"));
		} else {
			assertThat(r�sultat, IsEqual.equalTo("normal"));
		}
	} else {
		assertThat(r�sultat, IsEqual.equalTo("riche"));

	}
	}
}


