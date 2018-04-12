package Service;

import java.util.List;


import dAO.CompteEpargneDAO;
import domaine.Epargne;

public class EpargneService {
	CompteEpargneDAO dao = new CompteEpargneDAO();

	public boolean creerEpargne(Epargne compte) {
		return dao.createEpargne(compte);
	}
	public Epargne getEpargne(Epargne compte) {
		return dao.getEpargne(compte);
	}

	public Epargne updateEpargne(Epargne compte) {
		return dao.updateEpargne(compte);
	}

	public boolean deleteEpargne(Epargne compte) {
		return dao.deleteEpargne(compte);
	}

	public List<Epargne> getAllEpargne(Epargne compte) {
		return dao.getAllEpargne();
		}
}
