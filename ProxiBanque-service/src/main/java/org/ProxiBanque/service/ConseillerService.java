package org.ProxiBanque.service;

import org.ProxiBanque.dao.ConseillerDAO;

import org.ProxiBanque.domaine.Conseiller;

/**
 * @author Stagiaire
 *
 */
public class ConseillerService {

	// La classe ConseillerService permet de faire le lien entre la couche
	// pr�sentation
	// et la classe ConseillerDAO

	// D�claration
	ConseillerDAO dao = new ConseillerDAO();

	/**
	 * @param conseiller
	 * @return
	 */
	public Conseiller getConseiller(Conseiller conseiller) {
		return dao.getConseiller(conseiller);
	}
}
