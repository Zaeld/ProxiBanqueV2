package org.ProxiBanque.service;

import org.ProxiBanque.dao.ConseillerDAO;

import org.ProxiBanque.domaine.Conseiller;

/**
 * @author Stagiaire
 *
 */
public class ConseillerService {

	// La classe ConseillerService permet de faire le lien entre la couche
	// présentation
	// et la classe ConseillerDAO

	// Déclaration
	ConseillerDAO dao = new ConseillerDAO();

	/**
	 * @param conseiller
	 * @return
	 */
	public Conseiller getConseiller(Conseiller conseiller) {
		return dao.getConseiller(conseiller);
	}
}
