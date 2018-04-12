package service;

import java.util.List;

import dAO.CompteEpargneDAO;
import domaine.Epargne;

/**
 * @author Stagiaire
 *
 */
public class EpargneService {

	// La classe EpargneService permet de faire le lien entre la couche présentation
	// et la classe CompteEpargneDAO

	// Déclaration
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
