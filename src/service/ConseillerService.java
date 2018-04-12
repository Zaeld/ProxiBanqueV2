package service;

import dAO.ConseillerDAO;
import domaine.Conseiller;

public class ConseillerService {
	ConseillerDAO dao = new ConseillerDAO();

	public Conseiller createClient(Conseiller conseiller) {
		return dao.getConseiller(conseiller);
	}
}
